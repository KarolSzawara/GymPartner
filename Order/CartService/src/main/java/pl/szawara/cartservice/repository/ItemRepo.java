package pl.szawara.cartservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pl.szawara.cartservice.model.Item;
@Repository
public interface ItemRepo extends ReactiveMongoRepository<Item,String> {
}
