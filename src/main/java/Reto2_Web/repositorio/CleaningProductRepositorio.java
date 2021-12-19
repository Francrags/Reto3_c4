package Reto2_Web.repositorio;

import Reto2_Web.interfaces.InterfaceCleaningProduct;
import Reto2_Web.modelo.CleaningProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



/**
 *
 * @author RUBEN GIRALDO
 */
@Repository
public class CleaningProductRepositorio {
    @Autowired
    private InterfaceCleaningProduct InterfaceOrder;

    public List<CleaningProduct> getAll() {
        return InterfaceOrder.findAll();
    }

    public Optional<CleaningProduct> getClothe(Integer id) {
        return InterfaceOrder.findById(id);
    }
    public CleaningProduct create(CleaningProduct clothe) {
        return InterfaceOrder.save(clothe);
    }

    public void update(CleaningProduct clothe) {
        InterfaceOrder.save(clothe);
    }
    
    public void delete(CleaningProduct clothe) {
        InterfaceOrder.delete(clothe);
    }
}
