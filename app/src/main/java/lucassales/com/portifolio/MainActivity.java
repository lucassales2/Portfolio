package lucassales.com.portifolio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list_view);
        List<App> list = new ArrayList<>();
        String[] stringArray = getResources().getStringArray(R.array.app_names);
        for (int i = 0; i < stringArray.length; i++) {
            String appName = stringArray[i];
            @DrawableRes int drawable;
            switch (i) {
                case 0:
                    drawable = R.mipmap.ic_launcher;
                    break;
                case 1:
                    drawable = R.drawable.ic_launcher_sunshine;
                    break;
                case 2:
                    drawable = R.drawable.ic_launcher_mdb;
                    break;
                default:
                    drawable = R.drawable.ic_working;
                    break;
            }
            list.add(new App(drawable, appName));
            listView.setAdapter(new PortifolioAdapter(this, list));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent browserIntent;
                    switch (position) {
                        case 0:
                            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/lucassales2/Portfolio"));
                            startActivity(browserIntent);
                            break;
                        case 1:
                            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/lucassales2/Sunshine"));
                            startActivity(browserIntent);
                            break;
                        case 2:
                            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/lucassales2/MovieDataBase"));
                            startActivity(browserIntent);
                            break;
                        default:
                            Toast.makeText(getApplicationContext(), getString(R.string.working), Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });
        }


    }
}
