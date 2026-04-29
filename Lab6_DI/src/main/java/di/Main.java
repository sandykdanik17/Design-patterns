package di;

public class Main {
    public static void main(String[] args) {
        AppComponent appComponent = DaggerAppComponent.create();

        AppManager app = appComponent.getAppManager();

        app.start();
    }
}
