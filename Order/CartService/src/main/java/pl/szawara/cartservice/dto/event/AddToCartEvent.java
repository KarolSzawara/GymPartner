package pl.szawara.cartservice.dto.event;

import lombok.Builder;
import lombok.Data;
import pl.szawara.cartservice.dto.details.CartItemDetails;


@Builder
public record AddToCartEvent(
        CartItemDetails event,
    String userId
) {
    public AddToCartEvent(CartItemDetails event, String userId) {
        this.event = event;
        this.userId = userId;
    }
}
