package Reto2_Web.repositorio;

import Reto2_Web.interfaces.InterfaceUser;
import Reto2_Web.modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



/**
 *
 * @author RUBEN GIRALDO
 */
@Repository
public class UserRepositorio {

    @Autowired
    private InterfaceUser userRepository;

    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> getUser(int id) {
        return userRepository.findById(id);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public boolean emailExists(String email) {
        Optional<User> usuario = userRepository.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<User> authenticateUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public Optional<User> lastUserId() {
        return userRepository.findTopByOrderByIdDesc();
    }
}
