package pl.szawara.cartservice.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@AllArgsConstructor
@Data
@Builder
public class DeleteCartEvent {
    private String userId;
}
