/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.mintic.ciclo3.ciclo3.service;

import co.usa.mintic.ciclo3.ciclo3.model.Message;
import co.usa.mintic.ciclo3.ciclo3.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Angélica Alzate
 */

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        return messageRepository.getAll();       
    }
    
    public Optional<Message> getMessage(int idMessage){
        return messageRepository.getMessage(idMessage);
    }
    
    public Message save(Message m){
        if(m.getIdMessage()==null){
            return messageRepository.save(m);           
        }else{
            Optional<Message> maux=messageRepository.getMessage(m.getIdMessage());
            if(!maux.isPresent()){
                return messageRepository.save(m);
            }else{
                return m;
            }
        }
    }
    
    public Message update(Message m) {
        if (m.getIdMessage() != null) {
            Optional<Message> p = messageRepository.getMessage(m.getIdMessage());
            if (p.isPresent()) {
                if (m.getMessageText()!= null) {
                    p.get().setMessageText(m.getMessageText());
                }
                return messageRepository.save(p.get());
            }
        }
        return m;
    }   
    public boolean deleteMessage(int id){
        Optional<Message> m=getMessage(id);
        if(m.isPresent()){
            messageRepository.delete(m.get());
            return true;
    }
    return false;
    }
    
}
