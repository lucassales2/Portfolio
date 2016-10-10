package lucassales.com.portifolio;

import android.support.annotation.DrawableRes;

/**
 * Created by lucas on 10/10/16.
 */

public class App {
    private int appIcon;
    private String appName;
    public App(@DrawableRes int appIcon, String appName) {
        this.appIcon = appIcon;
        this.appName = appName;
    }

    public String getAppName() {
        return appName;
    }

    public @DrawableRes int getAppIcon() {
        return appIcon;
    }
}
