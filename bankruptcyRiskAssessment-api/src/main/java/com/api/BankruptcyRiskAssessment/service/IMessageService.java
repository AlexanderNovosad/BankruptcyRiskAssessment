package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.Message;

import java.util.List;

public interface IMessageService {
    Message sendMessage (Message message);

    void deleteMessage(Long messageId);

    List<Message> getUsersMessages (Long receiverId);

    List<Message> getUsersMessagesFromUser(Long receiverId, Long senderId);
}
