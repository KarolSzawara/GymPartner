package pl.szawara.cartservice.dto.details;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class CartItemDetails {
    private String productId;
    private int quantity;
}
