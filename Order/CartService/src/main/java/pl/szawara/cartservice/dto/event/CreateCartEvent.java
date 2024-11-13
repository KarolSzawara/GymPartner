package pl.szawara.cartservice.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CreateCartEvent {
    String userId;
    String userEmail;
}
