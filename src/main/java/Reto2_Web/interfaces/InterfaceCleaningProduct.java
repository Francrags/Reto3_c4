package Reto2_Web.interfaces;

import Reto2_Web.modelo.CleaningProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author RUBEN GIRALDO
 */
public interface InterfaceCleaningProduct extends MongoRepository<CleaningProduct, Integer> {
    
}
