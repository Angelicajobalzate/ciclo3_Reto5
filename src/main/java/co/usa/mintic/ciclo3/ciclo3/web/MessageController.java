/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.mintic.ciclo3.ciclo3.web;

import co.usa.mintic.ciclo3.ciclo3.model.Message;
import co.usa.mintic.ciclo3.ciclo3.service.MessageService;
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
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MessageController {
    
   @Autowired
   private MessageService messageService;
   
   @GetMapping("/all")
   public List<Message>getMessages(){
       return messageService.getAll();
   }
   
   @GetMapping("/{idMessage}")
   public Optional<Message>getMessage(@PathVariable("idMessage")int idMessage){
       return messageService.getMessage(idMessage);      
   }
   
   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED)
   public Message save(@RequestBody Message m){
       return messageService.save(m);
      
   }
   
   @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message m){
        return messageService.update(m);
    }
    
    @DeleteMapping("/{idMessage}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMessage(@PathVariable("idMessage")int idMessage){
        return messageService.deleteMessage(idMessage);
    }
    
    
}
