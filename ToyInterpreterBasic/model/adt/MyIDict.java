package model.adt;

import exceptions.ADTException;

public interface MyIDict<K, V> {
    void put(K k, V v) throws ADTException;

    void update(K k, V newV) throws ADTException;

    boolean isDefined(K k);

    V lookUp(K k);

}
