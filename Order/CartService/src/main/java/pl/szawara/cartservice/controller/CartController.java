package pl.szawara.cartservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.szawara.cartservice.dto.response.CartOutResponse;
import pl.szawara.cartservice.dto.request.CreateCartRequest;
import reactor.core.publisher.Mono;
import jakarta.validation.Valid;
@Controller
@RequestMapping("/cart")
public class CartController {
    /*@PostMapping("/create")
    public Mono<CartOutResponse> createCart(@RequestBody @Valid CreateCartRequest request){

    }*/
}
