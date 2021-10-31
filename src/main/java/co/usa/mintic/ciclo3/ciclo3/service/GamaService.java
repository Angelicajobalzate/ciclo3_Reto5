/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.mintic.ciclo3.ciclo3.service;

import co.usa.mintic.ciclo3.ciclo3.model.Gama;
import co.usa.mintic.ciclo3.ciclo3.repository.GamaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Angélica Alzate
 */
@Service
public class GamaService {

    @Autowired
    private GamaRepository gamaRepository;

    public List<Gama> getAll() {
        return gamaRepository.getAll();
    }

    public Optional<Gama> getGama(int idGama) {
        return gamaRepository.getGama(idGama);
    }

    public Gama save(Gama g) {
        if (g.getIdGama() == null) {
            return gamaRepository.save(g);

        } else {
            Optional<Gama> gaux = gamaRepository.getGama(g.getIdGama());
            if (!gaux.isPresent()) {
                return gamaRepository.save(g);
            } else {
                return g;
            }
        }

    }

    public Gama update(Gama g) {
        if (g.getIdGama() != null) {
            Optional<Gama>p=gamaRepository.getGama(g.getIdGama());
            if (p.isPresent()) {
                if (g.getName() != null) {
                    p.get().setName(g.getName());                
                }
                if(g.getDescription()!=null){
                    p.get().setDescription(g.getDescription());
                }              
                return gamaRepository.save(p.get());
            }
        }
        return g;
    }   
    
    public boolean deleteGama(int id){
        Optional<Gama> c=getGama(id);
        if(c.isPresent()){
            gamaRepository.delete(c.get());
            return true;
    }
    return false;
    }

}
