package com.api.BankruptcyRiskAssessment.controller;

import com.api.BankruptcyRiskAssessment.entity.Message;
import com.api.BankruptcyRiskAssessment.entity.User;
import com.api.BankruptcyRiskAssessment.repository.MessageRepository;
import com.api.BankruptcyRiskAssessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {
    @Autowired MessageRepository messageRepository;
    @Autowired UserRepository userRepository;

    @PostMapping("/message")
    public Message sendMessage(@Valid @RequestBody Message message){
        return messageRepository.save(message);
    }

    @DeleteMapping("/message")
    public ResponseEntity<Message> deleteMessage(@RequestParam(value = "message_id") Long messageId){
        Message message = messageRepository.getOne(messageId);
        if(message == null)
            return ResponseEntity.notFound().build();
        messageRepository.deleteById(messageId);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/receiver/messages")
    public List<Message> getUsersMessages(@RequestParam(value = "receiver_id")Long receiverId){
        User receiver = userRepository.getOne(receiverId);
        if(receiver == null)
            return new ArrayList<>();
        return messageRepository.findAllByReceiverId(receiver.getUserId());
    }

    @GetMapping("/receiver/messages/sender")
    public List<Message> getUsersMessagesFromUser(@RequestParam(value = "receiver_id") Long receiverId,
                                                  @RequestParam(value = "sender_id")Long senderId){
        User receiver = userRepository.getOne(receiverId);
        User sender = userRepository.getOne(senderId);
        if(receiver == null || sender == null) {
            return new ArrayList<>();
        }
        List<Message> messages = messageRepository.findAll();
        List<Message> retMessages = new ArrayList<>();
        messages.forEach(message -> {
            if ((message.getReceiverId().equals(receiverId)  && message.getSenderId().equals(senderId))
                    || (message.getReceiverId().equals(senderId) && message.getSenderId().equals(receiverId))) {
                retMessages.add(message);
            }
        });
        return retMessages;
    }
}
