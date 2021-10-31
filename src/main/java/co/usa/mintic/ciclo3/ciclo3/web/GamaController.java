/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.mintic.ciclo3.ciclo3.web;

import co.usa.mintic.ciclo3.ciclo3.model.Gama;
import co.usa.mintic.ciclo3.ciclo3.service.GamaService;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Angélica Alzate
 */
@RestController
@RequestMapping("/api/Gama")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class GamaController {
    
    @Autowired
    private GamaService gamaService;
    
    @GetMapping("/all")
    public List<Gama> getGamas(){
        return gamaService.getAll();
    }
    
    @GetMapping("/{idGama}")
    public Optional<Gama> getGama(@PathVariable("idGama")int idGama){
        return gamaService.getGama(idGama);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama save(@RequestBody Gama g){
        return gamaService.save(g);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama update(@RequestBody Gama g){
        return gamaService.update(g);
    }
    
    @DeleteMapping("/{idGama}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteGama(@PathVariable("idGama")int idGama){
        return gamaService.deleteGama(idGama);
    }
}
