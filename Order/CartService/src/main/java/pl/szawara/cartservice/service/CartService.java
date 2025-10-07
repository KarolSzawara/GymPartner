package pl.szawara.cartservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.szawara.cartservice.dto.event.CreateCartEvent;
import pl.szawara.cartservice.dto.event.DeleteCartEvent;
import pl.szawara.cartservice.dto.request.CreateCartRequest;
import pl.szawara.cartservice.dto.response.CartOutResponse;
import pl.szawara.cartservice.repository.MongoCartRepository;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class CartService {
    private final MongoCartRepository cartRepository;
    
    public Mono<CartOutResponse> createCart(CreateCartRequest request){
        CreateCartEvent event = CreateCartEvent.builder()
                .userId(request.getUserId())
                .userEmail(request.getUserEmail())
                .build();
                
        return cartRepository.createCart(event)
                .map(cart -> CartOutResponse.builder()
                        .id(cart.getId())
                        .userId(cart.getUserId())
                        .userEmail(cart.getUserEmail())
                        .build());
    }
    
    public Mono<Void> deleteCart(String userId) {
        DeleteCartEvent deleteEvent = DeleteCartEvent.builder()
                .userId(userId)
                .build();
        return cartRepository.deleteCart(deleteEvent);
    }
}
