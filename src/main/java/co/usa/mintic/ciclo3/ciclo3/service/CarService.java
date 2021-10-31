/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.mintic.ciclo3.ciclo3.service;

import co.usa.mintic.ciclo3.ciclo3.model.Car;
import co.usa.mintic.ciclo3.ciclo3.repository.CarRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Angélica Alzate
 */
@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll() {
        return carRepository.getAll();

    }

    public Optional<Car> getCar(int idCar) {
        return carRepository.getCar(idCar);
    }
    
    public Car save(Car c){
        if(c.getIdCar()== null){
            return carRepository.save(c);
        }else{
            Optional<Car> caux=carRepository.getCar(c.getIdCar());
            if(!caux.isPresent()){
                return carRepository.save(c);
            }else{
                return c;
            }
        }
    }
    
    public Car update(Car c) {
        if (c.getIdCar() != null) {
            Optional<Car> p = carRepository.getCar(c.getIdCar());
            if (p.isPresent()) {
                if (c.getName() != null) {
                    p.get().setName(c.getName());
                }
                if(c.getBrand()!=null){
                    p.get().setBrand(c.getBrand());
                }
                if(c.getYear()!=null){
                    p.get().setYear(c.getYear());
                }              
               if(c.getDescription()!=null){
                    p.get().setDescription(c.getDescription());
                }
                return carRepository.save(p.get());
            }
        }
        return c;
    }   
    public boolean deleteCar(int id){
        Optional<Car> c=getCar(id);
        if(c.isPresent()){
            carRepository.delete(c.get());
            return true;
    }
    return false;
    }
}
