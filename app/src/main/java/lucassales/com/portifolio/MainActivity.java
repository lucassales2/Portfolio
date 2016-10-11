package lucassales.com.portifolio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PortfolioAdapter.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<App> list = new ArrayList<>();
        String[] stringArray = getResources().getStringArray(R.array.app_names);
        for (int i = 0; i < stringArray.length; i++) {
            String appName = stringArray[i];
            String url;
            @DrawableRes int drawable;
            switch (i) {
                case 0:
                    drawable = R.mipmap.ic_launcher;
                    url = "https://github.com/lucassales2/Portfolio";
                    break;
                case 1:
                    drawable = R.drawable.ic_launcher_sunshine;
                    url = "https://github.com/lucassales2/Sunshine";
                    break;
                case 2:
                    drawable = R.drawable.ic_launcher_mdb;
                    url = "https://github.com/lucassales2/MovieDataBase";
                    break;
                default:
                    drawable = R.drawable.ic_working;
                    url = "";
                    break;
            }
            list.add(new App(drawable, appName, url));
        }
        recyclerView.setAdapter(new PortfolioAdapter(list, this));


    }

    @Override
    public void onItemClickListener(String url) {
        if (url.isEmpty()) {
            Toast.makeText(getApplicationContext(), getString(R.string.working), Toast.LENGTH_SHORT).show();
        } else {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }

    }
}
