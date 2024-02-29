package alex.otus.lrucache.cache;

import alex.otus.lrucache.model.User;
import lombok.extern.slf4j.Slf4j;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Slf4j
public class LruCache implements LruSoftCache<Long, User> {
    private final int capacity;
    private final Map<Long, SoftReference<User>> map;

    public LruCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity);
    }

    public boolean exists(Long key) {
        SoftReference<User> softValue = map.get(key);
        return softValue != null && softValue.get() != null;
    }

    public User get(Long key) {
        SoftReference<User> softValue = map.remove(key);
        User value = softValue == null ? null : softValue.get();

        if (value == null) {
            throw new NoSuchElementException();
        }

        map.put(key, softValue);
        log.info("Get from cash: {}", value);
        return value;
    }

    public void add(Long key, User value) {
        if (exists(key))
            map.put(key, new SoftReference<>(value));
        else {
            if (map.size() == capacity) {
                map.remove(map.keySet().iterator().next());
            }

            map.put(key, new SoftReference<>(value));
        }
    }
}
