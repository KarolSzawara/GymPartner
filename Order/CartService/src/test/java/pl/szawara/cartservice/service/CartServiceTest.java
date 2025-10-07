package pl.szawara.cartservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.szawara.cartservice.dto.request.CreateCartRequest;
import pl.szawara.cartservice.dto.response.CartOutResponse;
import pl.szawara.cartservice.model.Cart;
import pl.szawara.cartservice.repository.MongoCartRepository;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    @Mock
    private MongoCartRepository cartRepository;

    @InjectMocks
    private CartService cartService;

    private CreateCartRequest createCartRequest;
    private Cart cart;

    @BeforeEach
    void setUp() {
        createCartRequest = CreateCartRequest.builder()
                .userId("user123")
                .userEmail("test@example.com")
                .build();

        cart = Cart.builder()
                .id("cart123")
                .userId("user123")
                .userEmail("test@example.com")
                .build();
    }

    @Test
    void createCart_ShouldReturnCartOutResponse_WhenValidRequest() {
        when(cartRepository.createCart(any()))
                .thenReturn(Mono.just(cart));

        Mono<CartOutResponse> result = cartService.createCart(createCartRequest);

        StepVerifier.create(result)
                .expectNextMatches(response ->
                    response.getId().equals("cart123") &&
                    response.getUserId().equals("user123") &&
                    response.getUserEmail().equals("test@example.com")
                )
                .verifyComplete();
    }

    @Test
    void createCart_ShouldReturnError_WhenRepositoryFails() {
        when(cartRepository.createCart(any()))
                .thenReturn(Mono.error(new RuntimeException("Database error")));

        Mono<CartOutResponse> result = cartService.createCart(createCartRequest);

        StepVerifier.create(result)
                .expectError(RuntimeException.class)
                .verify();
    }

    @Test
    void deleteCart_ShouldComplete_WhenValidUserId() {
        when(cartRepository.deleteCart(any()))
                .thenReturn(Mono.empty());

        Mono<Void> result = cartService.deleteCart("user123");

        StepVerifier.create(result)
                .verifyComplete();
    }

    @Test
    void deleteCart_ShouldReturnError_WhenRepositoryFails() {
        when(cartRepository.deleteCart(any()))
                .thenReturn(Mono.error(new RuntimeException("Cart not found")));

        Mono<Void> result = cartService.deleteCart("user123");

        StepVerifier.create(result)
                .expectError(RuntimeException.class)
                .verify();
    }
}