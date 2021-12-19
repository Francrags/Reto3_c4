package Reto2_Web.servicio;

import Reto2_Web.modelo.Order;
import Reto2_Web.repositorio.OrderRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RUBEN GIRALDO
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepositorio orderRepositorio;

    public List<Order> getAll() {
        return orderRepositorio.getAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepositorio.getOrder(id);
    }

    public Order create(Order order) {
        Optional<Order> orderIdMaxima = orderRepositorio.lastUserId();
        if (order.getId() == null) {
            if (orderIdMaxima.isEmpty())
                order.setId(1);
            else 
                order.setId(orderIdMaxima.get().getId() + 1);

            }
            Optional<Order> e = orderRepositorio.getOrder(order.getId());
            if (e.isEmpty()) {
                return orderRepositorio.create(order);
            } else {
                return order;
            }
        }
    

    public Order update(Order order) {

        if (order.getId() != null) {
            Optional<Order> orderDb = orderRepositorio.getOrder(order.getId());
            if (!orderDb.isEmpty()) {
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                orderRepositorio.update(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getOrder(id).map(order -> {
            orderRepositorio.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Order> findByZone(String zona) {
        return orderRepositorio.findByZone(zona);
    }

    public List<Order> ordersSalesManByID(Integer id) {
        return orderRepositorio.ordersSalesManByID(id);
    }
}
