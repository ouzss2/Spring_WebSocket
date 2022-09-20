package ouzss.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@ComponentScan
@SpringBootApplication
public class SpringWebsocketChatAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebsocketChatAppApplication.class, args);
	}

}
