package alex.otus.lrucache.repository;

import alex.otus.lrucache.model.User;

import java.util.Collection;

public interface UserRepository {
    User add(User user);

    User get(Long id);

    Collection<User> getAll();
}
