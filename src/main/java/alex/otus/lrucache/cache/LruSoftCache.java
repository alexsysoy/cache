package alex.otus.lrucache.cache;

public interface LruSoftCache<K, V> {
    boolean exists(K key);
    V get(K key);
    void add(K key, V value);
}
