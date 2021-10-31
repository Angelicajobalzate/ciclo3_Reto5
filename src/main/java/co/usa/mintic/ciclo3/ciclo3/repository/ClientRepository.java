/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.mintic.ciclo3.ciclo3.repository;

import co.usa.mintic.ciclo3.ciclo3.model.Client;
import co.usa.mintic.ciclo3.ciclo3.repository.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Angélica Alzate
 */
@Repository
public class ClientRepository {
    
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    
    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    public Optional<Client> getClient(int idClient){
        return clientCrudRepository.findById(idClient);
    }
    
    public Client save(Client t){
        return clientCrudRepository.save(t);
    }
    
    public void delete(Client t){
        clientCrudRepository.delete(t);
    }
}
