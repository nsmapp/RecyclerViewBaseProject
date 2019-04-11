package by.nepravsky.sm.recyclerviewbase.compositerecycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.nepravsky.sm.recyclerviewbase.base.BaseViewHolder;
import by.nepravsky.sm.recyclerviewbase.data.Empty;
import by.nepravsky.sm.recyclerviewbase.databinding.ItemAddnewBinding;

public class AddNewItemViewHolder extends BaseViewHolder<Empty, AddNewItemViewModel, ItemAddnewBinding> {

    public AddNewItemViewHolder(ItemAddnewBinding binding, AddNewItemViewModel viewModel) {
        super(binding, viewModel);
    }

    public static AddNewItemViewHolder provideViewHolder(
            ViewGroup parent,
            AddNewItemViewModel viewModel){

        ItemAddnewBinding binding = ItemAddnewBinding
                .inflate(LayoutInflater.from(parent.getContext()));
        return new AddNewItemViewHolder(binding, viewModel);
    }
}
