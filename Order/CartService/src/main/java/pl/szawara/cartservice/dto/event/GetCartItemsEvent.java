package pl.szawara.cartservice.dto.event;

public record GetCartItemsEvent(
        String userId
) {
    public GetCartItemsEvent(String userId) {
        this.userId = userId;
    }
}
