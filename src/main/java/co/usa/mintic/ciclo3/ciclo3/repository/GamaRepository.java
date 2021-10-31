/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.mintic.ciclo3.ciclo3.repository;

import co.usa.mintic.ciclo3.ciclo3.model.Gama;
import co.usa.mintic.ciclo3.ciclo3.repository.crud.GamaCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Angélica Alzate
 */
@Repository
public class GamaRepository {
    
    @Autowired
    private GamaCrudRepository gamaCrudRepository;
    
    public List<Gama> getAll(){
        return (List<Gama>) gamaCrudRepository.findAll();
        
    }
    public Optional<Gama> getGama(int idGama){
        return gamaCrudRepository.findById(idGama);
    }
     
    public Gama save(Gama g){
        return gamaCrudRepository.save(g);
    }
    
    public void delete(Gama g){
        gamaCrudRepository.delete(g);
    }
}
