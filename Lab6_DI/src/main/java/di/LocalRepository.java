package di;

import javax.inject.Inject;

public class LocalRepository {
    @Inject public LocalRepository() {}
    public void connect() { System.out.println("3. Підключено до локальної БД..."); }
}
