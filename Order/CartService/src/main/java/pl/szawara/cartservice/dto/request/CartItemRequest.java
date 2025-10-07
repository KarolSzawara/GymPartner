package pl.szawara.cartservice.dto.request;

public record CartItemRequest(
        String productId,
        int quantity
) {
}
