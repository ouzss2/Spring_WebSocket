package ouzss.chat.Repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ouzss.chat.model.Message;


@Repository
public interface MessageRepository extends MongoRepository<Message, String>{

	List<Message> findBySender(String sender);
}
