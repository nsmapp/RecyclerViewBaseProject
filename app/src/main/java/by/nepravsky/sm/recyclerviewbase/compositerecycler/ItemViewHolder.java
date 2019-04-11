package by.nepravsky.sm.recyclerviewbase.compositerecycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.nepravsky.sm.recyclerviewbase.base.BaseViewHolder;
import by.nepravsky.sm.recyclerviewbase.data.Item;
import by.nepravsky.sm.recyclerviewbase.databinding.ItemItemBinding;

public class ItemViewHolder extends BaseViewHolder<Item, ItemViewModel, ItemItemBinding> {



    public ItemViewHolder(ItemItemBinding binding, ItemViewModel viewModel) {
        super(binding, viewModel);
    }

    public static ItemViewHolder  provideHolder(ViewGroup viewGroup, ItemViewModel viewModel){
        ItemItemBinding itemBinding = ItemItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()));
        return new ItemViewHolder(itemBinding, viewModel);
    }


}
