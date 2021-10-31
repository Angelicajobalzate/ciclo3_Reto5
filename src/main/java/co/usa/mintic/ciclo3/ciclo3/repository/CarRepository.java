/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.mintic.ciclo3.ciclo3.repository;

import co.usa.mintic.ciclo3.ciclo3.model.Car;
import co.usa.mintic.ciclo3.ciclo3.repository.crud.CarCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Angélica Alzate
 */
@Repository
public class CarRepository {
    
    @Autowired
    private CarCrudRepository carCrudRepository;
    
    public List<Car> getAll(){
        return (List<Car>) carCrudRepository.findAll();
    }
        
    public Optional<Car> getCar(int idCar){
        return carCrudRepository.findById(idCar);     
    }
    
    public Car save(Car c){
        return carCrudRepository.save(c);
    }
    
    public void delete(Car c){
        carCrudRepository.delete(c);
    }
}
