package lv.user;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepositiry extends MongoRepository<User, String> {

    List<User> findByName(String name);

}
