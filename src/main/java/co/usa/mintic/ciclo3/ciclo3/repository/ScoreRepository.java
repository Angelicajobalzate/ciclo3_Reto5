/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.mintic.ciclo3.ciclo3.repository;

import co.usa.mintic.ciclo3.ciclo3.model.Score;
import co.usa.mintic.ciclo3.ciclo3.repository.crud.ScoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Angélica Alzate
 */
@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> getAll() {
        return (List<Score>) scoreCrudRepository.findAll();
    }

    public Optional<Score> getScore(int idScore) {
        return scoreCrudRepository.findById(idScore);
    }

    public Score save(Score s) {
        return scoreCrudRepository.save(s);
    }

    public void delete(Score s){
        scoreCrudRepository.delete(s);
    }
}
