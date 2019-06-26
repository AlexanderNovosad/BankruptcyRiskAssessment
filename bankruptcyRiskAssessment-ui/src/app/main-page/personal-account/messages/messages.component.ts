import { Component, OnInit } from '@angular/core';
import {User} from '../../../model/User';
import {Message} from '../../../model/message';
import {UserService} from '../../../service/user.service';
import {MessageService} from '../../../service/message.service';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  constructor(
    private userService: UserService,
    private messageService: MessageService,
  ) {
    this.currentUser = userService.getCurrentUser();
    userService.getUsers()
      .then(users => this.users = users);
  }

  private currentUser: User;
  selectedUser: User;
  messages: Message[];
  users: User[];
  ngOnInit() {}

  scrollDown() {
    let element = document.getElementById('scrollingBox');
    element.scroll(0, element.scrollHeight - element.clientHeight);
  }

  selectUser(user: User) {
    this.selectedUser = user;
    this.messageService.getMessageStoryWithUser(this.selectedUser.userId, this.currentUser.userId)
      .then(messages => {
        this.messages = messages;
        setTimeout(() => this.scrollDown(), 50);
      });
  }

  isReaded(isReaded: boolean) {
    return (isReaded) ? '#f8f8ff' : '#c6e2ff';
  }

  isUserReceiver(receiver: number) {
    return (this.currentUser.userId === receiver) ? 'right' : 'left';
  }

  parseDate(date: number) {
    return new Date(date).toLocaleDateString('en-GB');
  }

  sendMessage(message: string) {
    this.messageService.sendMessageToUser({
      receiverId: this.selectedUser.userId,
      senderId: this.currentUser.userId,
      messageBody: message,
      readed: false,
      id: 0,
      date: Date.now()
    }).then(() => {
      this.messageService.getMessageStoryWithUser(this.selectedUser.userId, this.currentUser.userId)
        .then(messages => this.messages = messages);
    });
  }
}
