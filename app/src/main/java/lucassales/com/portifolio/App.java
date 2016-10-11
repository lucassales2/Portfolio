package lucassales.com.portifolio;

import android.support.annotation.DrawableRes;

/**
 * Created by lucas on 10/10/16.
 */

public class App {
    private int appIcon;
    private String appName;
    private String url;

    public App(@DrawableRes int appIcon, String appName, String url) {
        this.appIcon = appIcon;
        this.appName = appName;
        this.url = url;
    }

    public String getAppName() {
        return appName;
    }

    public
    @DrawableRes
    int getAppIcon() {
        return appIcon;
    }

    public String getUrl() {
        return url;
    }
}
