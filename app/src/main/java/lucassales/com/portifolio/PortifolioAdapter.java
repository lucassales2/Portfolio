package lucassales.com.portifolio;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lucas on 10/10/16.
 */

public class PortifolioAdapter extends ArrayAdapter<App> {
    public PortifolioAdapter(Context context, List<App> list) {
        super(context, R.layout.app_row, list);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.app_row, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        App item = getItem(position);
        viewHolder.textView.setText(item.getAppName());
        viewHolder.imageView.setImageResource(item.getAppIcon());
        return convertView;
    }

    static class ViewHolder {
        final ImageView imageView;
        final TextView textView;

        public ViewHolder(View convertView) {
            imageView = (ImageView) convertView.findViewById(R.id.imageView);
            textView = (TextView) convertView.findViewById(R.id.textView);
        }
    }
}
