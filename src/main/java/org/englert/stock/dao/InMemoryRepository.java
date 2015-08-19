package org.englert.stock.dao;

import org.englert.stock.domain.Trade;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 */
public abstract class InMemoryRepository<T>  {
    List<T> items = new LinkedList<>();

    public Collection<T> getAll(){
        return new LinkedList<>(items);
    }

    public void add(T item){
        items.add(item);
    }
}
