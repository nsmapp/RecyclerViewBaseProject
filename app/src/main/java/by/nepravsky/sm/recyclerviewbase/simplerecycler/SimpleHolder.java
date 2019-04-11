package by.nepravsky.sm.recyclerviewbase.simplerecycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.nepravsky.sm.recyclerviewbase.base.BaseViewHolder;
import by.nepravsky.sm.recyclerviewbase.data.Item;
import by.nepravsky.sm.recyclerviewbase.databinding.ItemSimpleBinding;

public class SimpleHolder extends BaseViewHolder<Item,SimpleViewModel, ItemSimpleBinding> {


    public SimpleHolder(ItemSimpleBinding binding, SimpleViewModel viewModel) {
        super(binding, viewModel);
    }

    public static SimpleHolder provideHolder(SimpleViewModel viewModel, ViewGroup view){

        ItemSimpleBinding binding = ItemSimpleBinding.inflate(LayoutInflater.from(view.getContext()));
        return new SimpleHolder(binding, viewModel);
    }


}
