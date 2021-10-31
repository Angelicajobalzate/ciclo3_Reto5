/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.mintic.ciclo3.ciclo3.repository;

import co.usa.mintic.ciclo3.ciclo3.model.Message;
import co.usa.mintic.ciclo3.ciclo3.repository.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Angélica Alzate
 */

@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    
    public List<Message> getAll(){
        return (List<Message>)messageCrudRepository.findAll();
    }
    
    public Optional<Message> getMessage(int idMsg){
        return messageCrudRepository.findById(idMsg);       
    }
   
    public Message save(Message m){
        return messageCrudRepository.save(m);
    }
    
    public void delete(Message m){
        messageCrudRepository.delete(m);
    }
    
}
