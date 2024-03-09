package alex.otus.lrucache.repository;

import alex.otus.lrucache.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FakeRepositoryImpl implements UserRepository {

    private Map<Long, User> db = new HashMap<>();
    @Override
    public User add(User user) {
        return db.put(user.getId(), user);
    }

    @Override
    public User get(Long id) {
        return db.get(id);
    }

    @Override
    public Collection<User> getAll() {
        return db.values();
    }
}
