package Reto2_Web.servicio;

import Reto2_Web.modelo.CleaningProduct;
import Reto2_Web.repositorio.CleaningProductRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author RUBEN GIRALDO
 */
@Service
public class CleaningProductService {

    @Autowired
    private CleaningProductRepositorio cleaningRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<CleaningProduct> getAll() {
        return cleaningRepository.getAll();
    }

    public Optional<CleaningProduct> getClothe(Integer id) {
        return cleaningRepository.getClothe(id);
    }

    public CleaningProduct create(CleaningProduct accesory) {
        if (accesory.getId() == null) {
            return accesory;
        } else {
            return cleaningRepository.create(accesory);
        }
    }

    public CleaningProduct update(CleaningProduct accesory) {

        if (accesory.getId() != null) {
            Optional<CleaningProduct> accesoryDb = cleaningRepository.getClothe(accesory.getId());
            if (!accesoryDb.isEmpty()) {

                if (accesory.getBrand() != null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getName() != null) {
                    accesoryDb.get().setName(accesory.getName());
                }

                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                cleaningRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(Integer id) {
        Boolean aBoolean = getClothe(id).map(accesory -> {
            cleaningRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
