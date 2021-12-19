package Reto2_Web.controlador;

import Reto2_Web.modelo.CleaningProduct;
import Reto2_Web.servicio.CleaningProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author RUBEN GIRALDO
 */
@RestController
@RequestMapping("/api/cleaningprod")
@CrossOrigin("*")
public class CleaningProductController {
    
    @Autowired
    private CleaningProductService cleaningProductService;
       
     @GetMapping("/all")
    public List<CleaningProduct> getAll() {
        return cleaningProductService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<CleaningProduct> getClothe(@PathVariable("id") Integer id) {
        return cleaningProductService.getClothe(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct create(@RequestBody CleaningProduct gadget) {
        return cleaningProductService.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct update(@RequestBody CleaningProduct gadget) {
        return cleaningProductService.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return cleaningProductService.delete(id);
    }
    
}