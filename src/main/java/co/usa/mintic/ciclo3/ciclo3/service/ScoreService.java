/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.mintic.ciclo3.ciclo3.service;

import co.usa.mintic.ciclo3.ciclo3.model.Score;
import co.usa.mintic.ciclo3.ciclo3.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Angélica Alzate
 */
@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int idScore) {
        return scoreRepository.getScore(idScore);
    }

    public Score save(Score s) {
        if (s.getIdScore() == null) {
            return scoreRepository.save(s);
        } else {
            Optional<Score> saux = scoreRepository.getScore(s.getIdScore());
            if (!saux.isPresent()) {
                return scoreRepository.save(s);
            } else {
                return s;
            }
        }

    }
    
     public Score update(Score s) {
        if (s.getIdScore()!= null) {
            Optional<Score> p = scoreRepository.getScore(s.getIdScore());
            if (p.isPresent()) {
                if (s.getScore()!= null) {
                    p.get().setScore(s.getScore());
                }
                if (s.getMessage()!= null) {
                    p.get().setMessage(s.getMessage());
                }
                return scoreRepository.save(p.get());
            }
        }
        return s;
    }   
    public boolean deleteScore(int id){
        Optional<Score> s=getScore(id);
        if(s.isPresent()){
            scoreRepository.delete(s.get());
            return true;
    }
    return false;
    }
    
}
