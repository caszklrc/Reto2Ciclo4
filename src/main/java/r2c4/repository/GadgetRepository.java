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
import r2c4.interfaces.GadgetInterface;
import r2c4.modelos.Gadgets;

/**
 *
 * @author anita
 */
@Repository
public class GadgetRepository {

    @Autowired
    private GadgetInterface repository;

    public List<Gadgets> getAll() {
        return repository.findAll();
    }

    public Optional<Gadgets> getGadget(String brand) {
        return repository.findById(brand);
    }

    public Gadgets create(Gadgets gadgets) {
        return repository.save(gadgets);
    }

    public void update(Gadgets gadgets) {
        repository.save(gadgets);
    }

    public void delete(Gadgets gadgets) {
        repository.delete(gadgets);
    }

    public Optional<Gadgets> getGadget(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}