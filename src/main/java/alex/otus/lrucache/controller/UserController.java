package alex.otus.lrucache.controller;

import alex.otus.lrucache.cache.LruCache;
import alex.otus.lrucache.cache.LruSoftCache;
import alex.otus.lrucache.model.User;
import alex.otus.lrucache.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final LruSoftCache<Long, User> cache;

    @GetMapping("/get/{id}")
    public User get(@PathVariable(name = "id") Long id) {
        log.info("Front get user {}", id);

        if (cache.exists(id)) {
            return cache.get(id);
        }
        User user = userService.get(id);
        cache.add(user.getId(), user);

        return user;
    }

    @PostMapping("/add")
    public User add(@RequestBody User user) {
        log.info("Front: {}", user);

        if (cache.exists(user.getId())) {
            log.info("User {} in cache", user.getId());
            return cache.get(user.getId());
        }
        return userService.add(user);
    }

    @GetMapping("/getAll")
    public Collection<User> getAll() {
        log.info("Front getAll");
        return userService.getAll();
    }
}
