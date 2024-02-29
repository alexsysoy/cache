package alex.otus.lrucache.configuration;

import alex.otus.lrucache.cache.LruCache;
import alex.otus.lrucache.cache.LruSoftCache;
import alex.otus.lrucache.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ApplicationContextConfiguration {
    @Value("${cache.capacity}")
    private int capacity;

    @Bean
    public LruSoftCache<Long, User> cache() {
        return new LruCache(capacity);
    }
}
