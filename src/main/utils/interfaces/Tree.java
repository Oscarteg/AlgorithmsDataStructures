package main.utils.interfaces;

/**
 * Created by Oscar on 08/04/2017.
 */
public interface Tree<K> {
    void insert(K k);

    boolean search(K k);

    void delete(K k);
}
