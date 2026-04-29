package di;

import javax.inject.Inject;

public class DatabaseService {
    private final LocalRepository localRepo;
    private final ConfigManager configManager;

    @Inject
    public DatabaseService(LocalRepository localRepo, ConfigManager configManager) {
        this.localRepo = localRepo;
        this.configManager = configManager;
    }
    public void init() {
        configManager.load();
        localRepo.connect();
        System.out.println("-> База даних готова до роботи.");
    }
}
