package pl.szawara.cartservice.dto.request;

import lombok.AllArgsConstructor;

public record AddToCartRequest(
        String userId,
        String productId,
        int quantity
) {
    public AddToCartRequest(String userId, String productId, int quantity) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }
}
