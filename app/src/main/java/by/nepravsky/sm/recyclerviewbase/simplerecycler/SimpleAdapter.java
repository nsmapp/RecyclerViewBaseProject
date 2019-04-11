package by.nepravsky.sm.recyclerviewbase.simplerecycler;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;
import by.nepravsky.sm.recyclerviewbase.base.BaseAdapter;
import by.nepravsky.sm.recyclerviewbase.data.Item;

public class SimpleAdapter extends BaseAdapter<Item, SimpleViewModel> {


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return SimpleHolder
                .provideHolder(new SimpleViewModel(), parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
    }
}
