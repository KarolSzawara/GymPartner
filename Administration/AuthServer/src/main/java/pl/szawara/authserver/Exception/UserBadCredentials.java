package pl.szawara.authserver.Exception;

public class UserBadCredentials extends RuntimeException{
    public UserBadCredentials(String message){
        super(message);
    }
}
