package pl.szawara.cartservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.szawara.cartservice.dto.event.CreateCartEvent;
import pl.szawara.cartservice.dto.request.CreateCartRequest;
import pl.szawara.cartservice.dto.response.CartOutResponse;
import pl.szawara.cartservice.repository.MongoCartRepository;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class CartService {
    private final MongoCartRepository cartRepository;
    /*public Mono<CartOutResponse> createCart(Mono<CreateCartRequest> request){
    }*/
}
