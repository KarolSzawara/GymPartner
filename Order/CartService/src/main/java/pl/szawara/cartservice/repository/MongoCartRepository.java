package pl.szawara.cartservice.repository;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.szawara.cartservice.dto.event.CreateCartEvent;
import pl.szawara.cartservice.dto.event.DeleteCartEvent;
import pl.szawara.cartservice.model.Cart;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Repository
public class MongoCartRepository implements  CartRepo{
    private final JpaCartRepo jpaCartRepo;
    @Override
    @Transactional
    public Mono<Cart> createCart(CreateCartEvent cartEvent) {
        var cart=Cart.builder()
                .userId(cartEvent.getUserId())
                .userEmail(cartEvent.getUserEmail())
                .build();
        return jpaCartRepo.save(cart);
    }

    @Override
    @Transactional
    public Mono<Void> deleteCart(DeleteCartEvent cartEvent) {
        return jpaCartRepo.findByUserId(cartEvent.getUserId())
                .flatMap(cart -> jpaCartRepo.delete(cart));
    }
}

interface JpaCartRepo extends ReactiveMongoRepository<Cart,String> {
    @Query("{'userId': ?0}")
    Mono<Cart> findByUserId(String userId);

}
