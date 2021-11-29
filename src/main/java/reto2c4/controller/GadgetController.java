/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto2c4.controller;

import java.util.List;
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
import r2c4.modelos.Gadgets;
import r2c4.services.GadgetService;

/**
 *
 * @author anita
 */
@RestController
@RequestMapping("/api/gadget")
@CrossOrigin("*")
public class GadgetController {
    @Autowired
    private GadgetService gadgetService;
            
     @GetMapping("/all")
    public List<Gadgets> getAll() {
        return gadgetService.getAll();
    }
    //Registrar usuario

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadgets create(@RequestBody Gadgets gadget) {
        return gadgetService.create(gadget);
    }
/**
 * 
 * @param reference
 * @return 
 *  @GetMapping("/{reference}") R E V I S A R 
    public Optional<Gadgets> getClothe(@PathVariable("reference") String reference) {
        return gadgetService.getClothe(reference);
    }
 */
   @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadgets update(@RequestBody Gadgets gadget) {
        return gadgetService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return gadgetService.delete(reference);
    } 
    

}
