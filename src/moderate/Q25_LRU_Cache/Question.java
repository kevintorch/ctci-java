package moderate.Q25_LRU_Cache;

// Design and build a "least recently used" cache, which evicts the least recently used item.
// The cache should map from keys to values (allowing you to insert
// and retrieve a value associated with a particular key) and be initialized with a max size.
// When it is full, it should evict the least recently used item.
// You can assume the keys are integers and the values are strings.

public class Question {

    public static void main(String[] args) {
        int cache_size = 5;
        Cache cache = new Cache(cache_size);

        cache.insert(1, "1");
        System.out.println(cache.getCacheAsString());
        cache.insert(2, "2");
        System.out.println(cache.getCacheAsString());
        cache.insert(3, "3");
        System.out.println(cache.getCacheAsString());
        cache.getValue(1);
        System.out.println(cache.getCacheAsString());
        cache.insert(4, "4");
        System.out.println(cache.getCacheAsString());
        cache.getValue(2);
        System.out.println(cache.getCacheAsString());
        cache.insert(5, "5");
        System.out.println(cache.getCacheAsString());
        cache.getValue(5);
        System.out.println(cache.getCacheAsString());
        cache.insert(6, "6");
        System.out.println(cache.getCacheAsString());
        cache.getValue(1);
        System.out.println(cache.getCacheAsString());
        cache.insert(5, "5a");
        System.out.println(cache.getCacheAsString());
        cache.getValue(3);
        System.out.println(cache.getCacheAsString());
        // 6->5->2->4->1
    }


}
