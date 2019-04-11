package by.nepravsky.sm.recyclerviewbase.compositerecycler;

import androidx.databinding.ObservableField;
import by.nepravsky.sm.recyclerviewbase.base.BaseViewModel;
import by.nepravsky.sm.recyclerviewbase.data.ItemCount;

public class CounterViewModel extends BaseViewModel<ItemCount> {


    public ObservableField<String> itemCount = new ObservableField<>("");

    @Override
    public void setEntity(ItemCount entity, int position) {

        itemCount.set(entity.getItemCount());
    }

    @Override
    public void onItemClick() {

    }
}
