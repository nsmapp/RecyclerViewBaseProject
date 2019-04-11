package by.nepravsky.sm.recyclerviewbase.simplerecycler;


import androidx.databinding.ObservableField;
import by.nepravsky.sm.recyclerviewbase.base.BaseViewModel;
import by.nepravsky.sm.recyclerviewbase.data.Item;

public class SimpleViewModel extends BaseViewModel<Item> {

    public ObservableField<String> id = new ObservableField<>("");
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> data = new ObservableField<>("");


    @Override
    public void setEntity(Item entity, int position) {
        id.set(entity.getId());
        name.set(entity.getName());
        data.set(entity.getData());

    }



    @Override
    public void onItemClick() {

    }
}
