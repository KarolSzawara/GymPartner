package pl.szawara.cartservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pl.szawara.cartservice.model.Cart;

@Repository
public interface CartRepo extends ReactiveMongoRepository<Cart,String> {

}
