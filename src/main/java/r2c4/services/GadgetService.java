/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r2c4.services;

import java.util.List;
import java.util.Optional;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.springframework.beans.factory.annotation.Autowired;
import r2c4.modelos.Gadgets;
import r2c4.repository.GadgetRepository;


/**
 *
 * @author anita
 */

public class GadgetService {
  
         @Autowired
    private GadgetRepository gadgetRepository;

    public List<Gadgets> getAll() {
        return gadgetRepository.getAll();
    }

   public Optional<Gadgets> getGadget(int id) {
        return gadgetRepository.getGadget(id);
    }

    public Gadgets create(Gadgets accesory) {
        if (accesory.getId() == null) {
            return accesory;
        } else {
            return gadgetRepository.create(accesory);
        }
    }

    public Gadgets update(Gadgets accesory) {

        if (accesory.getId() != null) {
            Optional<Gadgets> accesoryDb = gadgetRepository.getGadget(accesory.getId());
            if (!accesoryDb.isPresent()) {
                
                if (accesory.getBrand()!= null) {
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
                gadgetRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getGadget(gadget).map(accesory -> {
            gadgetRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
