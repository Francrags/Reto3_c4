package Reto2_Web.repositorio;

import Reto2_Web.interfaces.InterfaceOrder;
import Reto2_Web.modelo.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;




/**
 *
 * @author RIBEN GIRALDO
 */
@Repository
public class OrderRepositorio {

    @Autowired
    private InterfaceOrder orderRepositorio;

    @Autowired
    private MongoTemplate mongoTemplate;


public List<Order> getAll() {
        return (List<Order>) orderRepositorio.findAll();
    }
    
    public Optional<Order> getOrder(int id) {
        return orderRepositorio.findById(id);
    }

   public Order create(Order order) {
        return orderRepositorio.save(order);
    }

    public void update(Order order) {
        orderRepositorio.save(order);
    }

    public void delete(Order order) {
        orderRepositorio.delete(order);
    }

    public Optional<Order> lastUserId() {
        return orderRepositorio.findTopByOrderByIdDesc();
    }

    public List<Order> findByZone(String zona) {
        return orderRepositorio.findByZone(zona);
    }
    
    public List<Order> ordersSalesManByID(Integer id) {
        Query query = new Query();

        Criteria criterio = Criteria.where("salesMan.id").is(id);
        query.addCriteria(criterio);

        List<Order> orders = mongoTemplate.find(query, Order.class);

        return orders;
    }
       
}    