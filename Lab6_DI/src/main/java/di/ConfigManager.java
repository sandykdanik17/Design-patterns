package di;

import javax.inject.Inject;

public class ConfigManager {
    @Inject public ConfigManager() {}
    public void load() {System.out.println("2. Конфігурацію завантажено..."); }
}
