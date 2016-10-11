package lucassales.com.portifolio;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by lucas on 10/10/16.
 */

public class PortfolioAdapter extends RecyclerView.Adapter<PortfolioAdapter.ViewHolder> {
    private List<App> list;
    private WeakReference<Listener> listener;

    public PortfolioAdapter(List<App> list, Listener listener) {
        this.list = list;
        this.listener = new WeakReference<>(listener);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.app_row, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final App item = list.get(position);
        holder.textView.setText(item.getAppName());
        holder.imageView.setImageResource(item.getAppIcon());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.get().onItemClickListener(item.getUrl());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    interface Listener {
        void onItemClickListener(String url);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
