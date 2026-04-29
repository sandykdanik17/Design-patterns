package di;

import javax.inject.Inject;

public class NetworkService {
    private final AuthManager authManager;

    @Inject
    public NetworkService(AuthManager authManager) {
        this.authManager = authManager;
    }
    public void connect() {
        authManager.authenticate();
        System.out.println("-> Мережеве з'єднання встановлено.");
    }
}
