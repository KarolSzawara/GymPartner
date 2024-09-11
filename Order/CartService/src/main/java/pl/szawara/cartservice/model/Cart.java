package pl.szawara.cartservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cart {
    @Id
    Integer Id;
}
