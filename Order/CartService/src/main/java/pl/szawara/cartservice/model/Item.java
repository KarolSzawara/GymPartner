package pl.szawara.cartservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Data
@AllArgsConstructor
@Document("cart_items")
@Builder
public class Item {
    @Id
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;
    private String productId;
    private int quantity;

    @DBRef
    private Cart cart;
}
