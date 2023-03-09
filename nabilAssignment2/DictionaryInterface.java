import java.util.LinkedList;

interface DictionaryInterface<K,V> {
    public abstract V get(K key);
    public abstract boolean put(K key, V value);
    public abstract boolean remove(K key);
    public abstract boolean replace(K key, V value);
    public abstract int size();
    public abstract boolean isEmpty();
    public abstract LinkedList<K> keys();
    public abstract LinkedList<V> values();
    public abstract void clear();

}