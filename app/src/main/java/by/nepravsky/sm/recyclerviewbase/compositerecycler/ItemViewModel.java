package by.nepravsky.sm.recyclerviewbase.compositerecycler;

import androidx.databinding.ObservableField;
import by.nepravsky.sm.recyclerviewbase.base.BaseClickedModel;
import by.nepravsky.sm.recyclerviewbase.base.BaseViewModel;
import by.nepravsky.sm.recyclerviewbase.data.Item;
import io.reactivex.subjects.PublishSubject;

public class ItemViewModel extends BaseViewModel<Item> {

    private Item item;
    private  int position;
    public ObservableField<String> id = new ObservableField<>("");
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> data = new ObservableField<>("");

    private PublishSubject<BaseClickedModel<Item>> upClickSubject;
    private PublishSubject<BaseClickedModel<Item>> downClickSubject;
    private PublishSubject<BaseClickedModel<Item>> delClickSubject;

    public ItemViewModel(PublishSubject<BaseClickedModel<Item>> upClickSubject,
                         PublishSubject<BaseClickedModel<Item>> downClickSubject,
                         PublishSubject<BaseClickedModel<Item>> delClickSubject) {

        this.upClickSubject = upClickSubject;
        this.downClickSubject = downClickSubject;
        this.delClickSubject = delClickSubject;
    }

    @Override
    public void setEntity(Item entity, int position) {
        id.set(entity.getId());
        name.set(entity.getName());
        data.set(entity.getData());

        this.item = entity;
        this.position = position;
    }

    public void onClickUp(){
        upClickSubject.onNext(new BaseClickedModel<Item>(item, position));
    }

    public void onClickDown(){downClickSubject.onNext(new BaseClickedModel<Item>(item, position));}

    public void onClickDel(){
        delClickSubject.onNext(new BaseClickedModel<Item>(item, position));
    }

    @Override
    public void onItemClick() {

    }
}
