package di;

import javax.inject.Inject;

public class LoggingService {
    @Inject public LoggingService() {}
    public void log(String msg) { System.out.println("[LOG]: " + msg); }
}
