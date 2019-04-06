package com.api.BankruptcyRiskAssessment.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity (name = "Massage")
@Table(name = "massage")
@EntityListeners(AuditingEntityListener.class)
public class Message implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long messageId;

    @Column(nullable = false)
    private String messageBody;

    @Column(nullable = false)
    private Long senderId;

    @Column(nullable = false)
    private Long receiverId;

    public Message() {
    }

    public void setMessageId(Long massageId) {
        this.messageId = massageId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getSenderId() {
        return senderId;
    }
}
