package by.nepravsky.sm.recyclerviewbase.base;

import androidx.lifecycle.ViewModel;
import by.nepravsky.sm.recyclerviewbase.data.Entity;

public abstract class BaseViewModel<E extends Entity> extends ViewModel {

    private E entity;

    public abstract void setEntity(E entity, int position);

    public abstract void onItemClick();
}
