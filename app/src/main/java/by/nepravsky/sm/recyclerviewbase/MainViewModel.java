package by.nepravsky.sm.recyclerviewbase;


import java.util.ArrayList;
import java.util.List;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import by.nepravsky.sm.recyclerviewbase.base.BaseAdapter;
import by.nepravsky.sm.recyclerviewbase.base.BaseClickedModel;
import by.nepravsky.sm.recyclerviewbase.data.BlackBox;
import by.nepravsky.sm.recyclerviewbase.data.Empty;
import by.nepravsky.sm.recyclerviewbase.data.Item;
import by.nepravsky.sm.recyclerviewbase.compositerecycler.CompositeAdapter;
import by.nepravsky.sm.recyclerviewbase.simplerecycler.SimpleAdapter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class MainViewModel  extends ViewModel {

    private List<Item> itemList = new ArrayList<>();
    public ObservableField<BaseAdapter> observAdapter = new ObservableField<>();
    private CompositeAdapter compositeAdapter = new CompositeAdapter();
    private SimpleAdapter simpleAdapter = new SimpleAdapter();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    public void onLoadSimpleAdapter(){

        itemList = loadItemList();
        simpleAdapter.setEntity(itemList);
        observAdapter.set(simpleAdapter);

    }

    public void onLoadWithClickAdapter(){

        itemList = loadItemList();
        compositeAdapter.setEntity(itemList);

        compositeDisposable.add(
        compositeAdapter.observeDelClick()
                .subscribe(new Consumer<BaseClickedModel<Item>>() {
                    @Override
                    public void accept(BaseClickedModel<Item> itemBaseClickedModel) throws Exception {
                        compositeAdapter.delItem(itemBaseClickedModel.getPosition());
                    }
                })
        );

        compositeDisposable.add(
        compositeAdapter.observeUpClick()
                .subscribe(new Consumer<BaseClickedModel<Item>>() {
                    @Override
                    public void accept(BaseClickedModel<Item> itemBaseClickedModel) throws Exception {
                        compositeAdapter.moveUp(itemBaseClickedModel.getPosition());
                    }
                })
        );

        compositeDisposable.add(
        compositeAdapter.observeDownClick()
                .subscribe(new Consumer<BaseClickedModel<Item>>() {
                    @Override
                    public void accept(BaseClickedModel<Item> itemBaseClickedModel) throws Exception {
                        compositeAdapter.moveDown(itemBaseClickedModel.getPosition());
                    }
                })
        );

        compositeDisposable.add(
        compositeAdapter.observeAddNewElement()
                .subscribe(new Consumer<BaseClickedModel<Empty>>() {
                    @Override
                    public void accept(BaseClickedModel<Empty> emptyBaseClickedModel) throws Exception {
                    compositeAdapter.addElement();

                    }
                })
        );

        observAdapter.set(compositeAdapter);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        if (compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }

    }

    private List<Item> loadItemList(){
        return new BlackBox().getItemList();
    }
}
