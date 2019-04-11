package by.nepravsky.sm.recyclerviewbase.compositerecycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import by.nepravsky.sm.recyclerviewbase.base.BaseViewHolder;
import by.nepravsky.sm.recyclerviewbase.data.ItemCount;
import by.nepravsky.sm.recyclerviewbase.databinding.ItemCounterBinding;

public class CounterViewHolder extends BaseViewHolder<ItemCount, CounterViewModel, ItemCounterBinding> {
    
    
    public CounterViewHolder(ItemCounterBinding binding, CounterViewModel viewModel) {
        super(binding, viewModel);
    }
    
    
    public static CounterViewHolder provideViewHolder(ViewGroup parent, CounterViewModel viewModel){

        ItemCounterBinding binding = ItemCounterBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new CounterViewHolder(binding, viewModel);
    }
}
