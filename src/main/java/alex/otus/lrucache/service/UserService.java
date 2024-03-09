package alex.otus.lrucache.service;

import alex.otus.lrucache.model.User;

import java.util.Collection;

public interface UserService {
    User add(User user);

    User get(Long id);

    Collection<User> getAll();
}
