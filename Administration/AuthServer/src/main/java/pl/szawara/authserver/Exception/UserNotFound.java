package pl.szawara.authserver.Exception;

public class UserNotFound extends RuntimeException{
    UserNotFound(String message){
        super(message);
    }
}
