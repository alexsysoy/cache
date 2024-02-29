package alex.otus.lrucache.service;

import alex.otus.lrucache.model.User;
import alex.otus.lrucache.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    @Override
    public User add(User user) {
        log.info("Add to db: {}", user);
        return repository.add(user);
    }

    @Override
    public User get(Long id) {
        User user = repository.get(id);
        log.info("Get user from db: {}", user);
        return user;
    }

    @Override
    public Collection<User> getAll() {
        log.info("Get all from db");
        return repository.getAll();
    }
}
