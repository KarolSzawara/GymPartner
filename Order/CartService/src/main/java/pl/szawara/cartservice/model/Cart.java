package pl.szawara.cartservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("cart")
public class Cart {
    @Id
    private String id;

    @Indexed(unique = true)
    private String userId;
    private String userEmail;

    @DBRef
    @Builder.Default
    private List<Item> itemList = new ArrayList<>();
}
