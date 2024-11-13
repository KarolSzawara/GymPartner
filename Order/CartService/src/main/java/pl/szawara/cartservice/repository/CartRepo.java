package pl.szawara.cartservice.repository;

import pl.szawara.cartservice.dto.event.CreateCartEvent;
import pl.szawara.cartservice.dto.event.DeleteCartEvent;
import pl.szawara.cartservice.model.Cart;
import reactor.core.publisher.Mono;

public interface CartRepo {
    public Mono<Cart> createCart(CreateCartEvent cartEvent);
    public Mono<Void> deleteCart(DeleteCartEvent cartEvent);

}
