package pl.szawara.cartservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.szawara.cartservice.dto.response.CartOutResponse;
import pl.szawara.cartservice.dto.request.CreateCartRequest;
import pl.szawara.cartservice.service.CartService;
import reactor.core.publisher.Mono;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/cart")
@AllArgsConstructor
public class CartController {
    
    private final CartService cartService;
    
    @PostMapping("/create")
    public Mono<CartOutResponse> createCart(@RequestBody @Valid CreateCartRequest request){
        return cartService.createCart(request);
    }
    
    @DeleteMapping("/{userId}")
    public Mono<Void> deleteCart(@PathVariable String userId) {
        return cartService.deleteCart(userId);
    }
}
