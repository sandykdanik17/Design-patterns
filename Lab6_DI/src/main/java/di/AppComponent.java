package di;

import dagger.Component;

@Component
public interface AppComponent {
    AppManager getAppManager();
}
