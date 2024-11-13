package pl.szawara.cartservice.dto.event;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class DeleteCartEvent {
    private String userId;
}
