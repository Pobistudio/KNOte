package id.pobistudio.knote.main;

import android.app.Application;
import android.content.Context;

import id.pobistudio.knote.R;
import id.pobistudio.knote.helper.Constanta;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by kukuh on 16/02/18.
 */

public class App extends Application {

    private static Context context;
    private static App app;

    @Override public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        app = this;
        //Custom Fonts
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Ubuntu-Medium.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        //Configuration Realm Database
        Realm.init(context);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(Constanta.Config.DATABASE_NAME)
                .schemaVersion(Constanta.Config.DATABASE_VERSION)
                .migration(new DataMigration())
                .build();
        Realm.setDefaultConfiguration(config);
        Realm.getInstance(config);
    }

    @Override
    public void onTerminate() {
        Realm.getDefaultInstance().close();
        super.onTerminate();
    }
    public static synchronized Context getContext() {
        return context;
    }

    public static synchronized App getInstance() {
        return app;
    }

}
