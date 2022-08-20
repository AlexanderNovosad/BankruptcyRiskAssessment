package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.Message;
import com.api.BankruptcyRiskAssessment.entity.User;
import com.api.BankruptcyRiskAssessment.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class MessageService implements IMessageService {
    private final IUserService userService;
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(IUserService userService, MessageRepository messageRepository){
        this.userService = userService;
        this.messageRepository = messageRepository;
    }

    @Override
    public Message sendMessage(Message message) {
        if (isNull(message)) {
            throw new EntityNotFoundException("Message not exist");
        }
        return messageRepository.saveAndFlush(message);
    }

    @Override
    public void deleteMessage(Long messageId) {
        Message message = messageRepository.findById(messageId).orElseThrow(() -> new EntityNotFoundException("Message not found"));
        messageRepository.delete(message);
    }

    @Override
    public List<Message> getUsersMessages(Long receiverId) {
        User receiver = userService.getUser(receiverId);
        return messageRepository.findAllByReceiverId(receiver.getUserId());
    }

    @Override
    public List<Message> getUsersMessagesFromUser(Long receiverId, Long senderId) {
        User receiver = userService.getUser(receiverId);
        User sender = userService.getUser(senderId);
        List<Message> messages = new ArrayList<>();
        messageRepository.findAll().forEach(message -> {
            if ((message.getReceiverId().equals(receiver.getUserId())  && message.getSenderId().equals(sender.getUserId()))
                    || (message.getReceiverId().equals(sender.getUserId()) && message.getSenderId().equals(receiver.getUserId()))) {
                messages.add(message);
            }
        });
        return messages;
    }
}
