package ouzss.chat.controller;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import ouzss.chat.Repo.MessageRepository;
import ouzss.chat.Repo.UserRepository;
import ouzss.chat.model.Greeting;
import ouzss.chat.model.HelloMessage;
import ouzss.chat.model.Message;
import ouzss.chat.model.User;


@RestController
@CrossOrigin("http://localhost:4200")
public class MessageController {
	
	@Autowired
	private MessageRepository repository;
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Message addNewMessage(@RequestBody Message user) {
		
		return repository.save(user);
	}
	
	@GetMapping("/GetUsers/{etat}")
	public List<User> GetAllUsers(@PathVariable String etat){
		return userRepository.findByEtat(etat);
	}
	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public User addNewUser(@RequestBody User user) {
		List<User> usersiffound=userRepository.findByName(user.getName());
		if(usersiffound.size()==0)  {
			return userRepository.save(user);
		}else {
			return user;
		}
		
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/{name}")
	public List<Message> getMessages(@PathVariable String name ){
		return repository.findBySender(name);
	}
	
	

}
