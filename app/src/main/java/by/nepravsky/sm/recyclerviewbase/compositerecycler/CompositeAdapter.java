package by.nepravsky.sm.recyclerviewbase.compositerecycler;

import android.util.Log;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import by.nepravsky.sm.recyclerviewbase.base.BaseAdapter;
import by.nepravsky.sm.recyclerviewbase.base.BaseClickedModel;
import by.nepravsky.sm.recyclerviewbase.base.BaseViewHolder;


import by.nepravsky.sm.recyclerviewbase.data.Empty;
import by.nepravsky.sm.recyclerviewbase.data.ItemCount;
import by.nepravsky.sm.recyclerviewbase.data.Item;

import io.reactivex.Observable;

import io.reactivex.subjects.PublishSubject;

public class CompositeAdapter extends BaseAdapter<Item, ItemViewModel> {

    private final int VIEW_ITEM_COUNT = 1;
    private final int VIEW_ADD_NEW_ITEM = 2;

    @Override
    public void setEntity(List<Item> entityList) {
        super.setEntity(entityList);

    }

    @Override
    public int getItemCount() {
        return entityList.size() + 2;
    }

    private PublishSubject<BaseClickedModel<Item>> upClickSubject = PublishSubject.create();
    private PublishSubject<BaseClickedModel<Item>> downClickSubject = PublishSubject.create();
    private PublishSubject<BaseClickedModel<Item>> delClickSubject = PublishSubject.create();
    private PublishSubject<BaseClickedModel<Empty>> addItemClickSubject = PublishSubject.create();

    @Override
    public int getItemViewType(int position) {

        if (position == 0){
            return VIEW_ITEM_COUNT;
        } if(position == getItemCount()-1){
            return VIEW_ADD_NEW_ITEM;
        }
        return super.getItemViewType(position);

    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == VIEW_ITEM_COUNT){
            return CounterViewHolder.provideViewHolder(parent,
                    new CounterViewModel());
        }
        if(viewType == VIEW_ADD_NEW_ITEM){
            return AddNewItemViewHolder.provideViewHolder(parent,
                    new AddNewItemViewModel(addItemClickSubject));
        }

        return ItemViewHolder.provideHolder(
                parent,
                new ItemViewModel(
                        upClickSubject,
                        downClickSubject,
                        delClickSubject));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (position != 0 && position != getLastElementPosition()){
            super.onBindViewHolder(holder, position -1);
        }else {
            if (position == 0){
                BaseViewHolder<ItemCount, CounterViewModel, ?> itemCountHolder =
                        (BaseViewHolder<ItemCount, CounterViewModel, ?>) holder;
                itemCountHolder.bind(new ItemCount(String.valueOf(entityList.size())), position);
            }
            if (position == getItemCount()){
                BaseViewHolder<Empty, AddNewItemViewModel, ?> addNewItemHolder
                        = (BaseViewHolder<Empty, AddNewItemViewModel, ?>) holder;
                addNewItemHolder.bind(new Empty(), position);
            }
        }
    }

    public Observable<BaseClickedModel<Item>> observeUpClick(){
        return upClickSubject;
    }
    public Observable<BaseClickedModel<Item>> observeDownClick(){
        return downClickSubject;
    }
    public Observable<BaseClickedModel<Item>> observeDelClick(){
        return delClickSubject;
    }
    public Observable<BaseClickedModel<Empty>> observeAddNewElement(){
        return addItemClickSubject;
    }

    public void addElement() {
        entityList.add(new Item("", "", ""));
        notifyDataSetChanged();
    }

    private int getLastElementPosition(){
        return getItemCount() - 1;
    }

    public void delItem(int position){

        entityList.remove(position);
        notifyDataSetChanged();
    }

    public void moveUp(int position){

        if(position != 0){
            Item entity = entityList.remove(position);
            entityList.add(position -1, entity);
            notifyItemMoved(position + 1, position);
            notifyItemRangeChanged(position + 1, 2);
        }
    }

    public void moveDown(int position){

        if(position != (entityList.size() -1)){
            Item entity = entityList.remove(position);
            entityList.add(position + 1, entity);
            notifyItemMoved(position + 1, position + 2);
            notifyItemRangeChanged(position + 1, 2);
        }
    }
}
