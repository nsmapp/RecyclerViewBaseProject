package by.nepravsky.sm.recyclerviewbase.compositerecycler;

import by.nepravsky.sm.recyclerviewbase.base.BaseClickedModel;
import by.nepravsky.sm.recyclerviewbase.base.BaseViewModel;
import by.nepravsky.sm.recyclerviewbase.data.Empty;
import io.reactivex.subjects.PublishSubject;

public class AddNewItemViewModel extends BaseViewModel<Empty> {


    private PublishSubject<BaseClickedModel<Empty>>  addElementSubject;
    private Empty empty;
    private int position;


    public AddNewItemViewModel(PublishSubject<BaseClickedModel<Empty>> addElementSubject) {
        this.addElementSubject = addElementSubject;
    }

    @Override
    public void setEntity(Empty entity, int position) {
        this.empty = entity;
        this.position = position;
    }

    @Override
    public void onItemClick() {

    }

    public void onClickAddElement(){
        addElementSubject.onNext(new BaseClickedModel<Empty>(empty, position));
    }
}
