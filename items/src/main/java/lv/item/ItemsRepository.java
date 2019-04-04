package lv.item;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemsRepository extends MongoRepository<Item, String> {

    List<Item> findByUserId(String userId);
}