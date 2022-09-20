package ouzss.chat.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document("Messages")
public class Message {
	
	 @Id
     private String id;
	 
	private String content;
	private String sender;
	private String receiver;
	
	
	
	

}
