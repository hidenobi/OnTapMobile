package ptit.hide.mai_dmo1;

import android.app.Application;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        appDatabase = AppDatabase.getAppDatabase(MyApp.this);
    }

    public static AppDatabase appDatabase;

}
