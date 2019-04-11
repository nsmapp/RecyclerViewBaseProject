package by.nepravsky.sm.recyclerviewbase.base;

import by.nepravsky.sm.recyclerviewbase.data.Entity;

public class BaseClickedModel<E extends Entity> {

    private E entity;
    private int position;

    public BaseClickedModel(E entity, int position) {
        this.entity = entity;
        this.position = position;
    }

    public E getEntity() {
        return entity;
    }

    public int getPosition() {
        return position;
    }
}
