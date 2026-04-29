package di;

import javax.inject.Inject;

public class AppManager {
    private final DatabaseService dbService;
    private final NetworkService networkService;
    private final LoggingService loggingService;

    @Inject
    public AppManager(DatabaseService dbService, NetworkService networkService, LoggingService loggingService) {
        this.dbService = dbService;
        this.networkService = networkService;
        this.loggingService = loggingService;
    }

    public void start() {
        loggingService.log("Запуск додатку...");
        dbService.init();
        networkService.connect();
        loggingService.log("Додаток успішно працює!");
    }
}
