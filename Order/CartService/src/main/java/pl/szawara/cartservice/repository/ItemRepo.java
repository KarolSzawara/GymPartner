package pl.szawara.cartservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pl.szawara.cartservice.dto.event.AddToCartEvent;
import pl.szawara.cartservice.dto.request.AddToCartRequest;
import pl.szawara.cartservice.model.Item;
import reactor.core.publisher.Mono;

public interface ItemRepo  {
    public Mono<Item> addToCart(AddToCartEvent item);
    public Mono<Item> getCartItem();
}
