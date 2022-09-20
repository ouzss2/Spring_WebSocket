package ouzss.chat.Repo;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ouzss.chat.model.User;


@Repository
public interface UserRepository extends MongoRepository<User, String>{

	List<User> findByEtat(String etat);
	List<User>  findByName(String name);
}
