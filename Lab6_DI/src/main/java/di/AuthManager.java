package di;

import javax.inject.Inject;

public class AuthManager {
    @Inject public AuthManager() {}
    public void authenticate() {System.out.println("1. Авторизація успішна..."); }
}
