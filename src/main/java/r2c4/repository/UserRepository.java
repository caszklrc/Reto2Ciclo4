/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r2c4.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import r2c4.interfaces.UserInterface;
import r2c4.modelos.User;

/**
 *
 * @author anita
 */
@Repository
public class UserRepository {

    @Autowired
    private UserInterface userInterface;

    /*
    Traer los datos de la tabla
     */
    public List<User> getAll() {
        return (List<User>) userInterface.findAll();

    }

    public Optional<User> getUser(int id) {
        return userInterface.findById(id);
    }

    public User create(User user) {
        return userInterface.save(user);
    }

    public void update(User user) {
        userInterface.save(user);
    }
    
    public void delete(User user) {
        userInterface.delete(user);
    }

    public boolean emailExists(String email) {
        Optional<User> usuario = userInterface.findByEmail(email);
        
        return !usuario.isPresent();
    }
    
    public Optional<User> authenticateUser(String email, String password) {
        return userInterface.findByEmailAndPassword(email, password);
    }
     
     
}