package ouzss.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.HtmlUtils;

import ouzss.chat.Repo.MessageRepository;
import ouzss.chat.model.Greeting;
import ouzss.chat.model.HelloMessage;
import ouzss.chat.model.Message;
import ouzss.chat.model.User;

@Controller
public class GreetingController {

	@Autowired
	MessageRepository repository;
	
	@MessageMapping("/chat.register")
	@SendTo("/topic/greetings")
	public User register(@Payload User chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getName());
		return chatMessage;
	}

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(@RequestBody Message message) throws Exception {
        Thread.sleep(100);
        repository.save(message);
        return message.getContent();
    }

}