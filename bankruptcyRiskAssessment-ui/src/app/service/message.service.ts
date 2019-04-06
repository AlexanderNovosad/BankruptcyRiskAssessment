import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Message} from '../model/message';
import {promise} from 'selenium-webdriver';

@Injectable()
export class MessageService {

  constructor(
    private httpClient: HttpClient) { }

    public getMessageStoryWithUser(receiverId, senderId): Promise<Message[]> {
      return this.httpClient.get<Message[]>(
        `api/receiver/messages/sender?receiver_id=${receiverId}&sender_id=${senderId}`)
        .toPromise();
    }

    public sendMessageToUser(message: Message): Promise<Message> {
      return this.httpClient.post(`/api/message`, message)
        .toPromise().then(data => data as Message);
    }
}
