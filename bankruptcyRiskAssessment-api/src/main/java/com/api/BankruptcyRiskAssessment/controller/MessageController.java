package com.api.BankruptcyRiskAssessment.controller;

import com.api.BankruptcyRiskAssessment.entity.Message;
import com.api.BankruptcyRiskAssessment.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {
    private final IMessageService messageService;

    @Autowired
    public MessageController(IMessageService messageService){
        this.messageService = messageService;
    }

    @PostMapping("/message")
    public ResponseEntity<Message> sendMessage(@Valid @RequestBody Message message){
        return ResponseEntity.status(HttpStatus.CREATED).body(messageService.sendMessage(message));
    }

    @DeleteMapping("/message")
    public ResponseEntity deleteMessage(@RequestParam(value = "message_id") Long messageId){
        messageService.deleteMessage(messageId);
        return ResponseEntity.status(HttpStatus.OK).body("delete completed successfully");
    }

    @GetMapping("/receiver/messages")
    public ResponseEntity<List<Message>> getUsersMessages(@RequestParam(value = "receiver_id")Long receiverId){
        return ResponseEntity.status(HttpStatus.OK).body(messageService.getUsersMessages(receiverId));
    }

    @GetMapping("/receiver/messages/sender")
    public ResponseEntity<List<Message>> getUsersMessagesFromUser(@RequestParam(value = "receiver_id") Long receiverId,
                                                                  @RequestParam(value = "sender_id")Long senderId){
        return ResponseEntity.status(HttpStatus.OK).body(messageService.getUsersMessagesFromUser(receiverId, senderId));
    }
}
