import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

import java.util.Date;

public class RedisStorage {
    private RedissonClient redisson;
    private RKeys rKeys;
    private RScoredSortedSet<String> users;
    private final static String KEY = "Users";

    public RedisStorage(RedissonClient redisson) {
        users = redisson.getScoredSortedSet(KEY, new StringCodec("UTF-8"));
        rKeys = redisson.getKeys();
        rKeys.delete(KEY);
    }

    public double getTs() {
        return new Date().getTime();
    }

    public static RedisStorage createConfig(String configAddress) {
        Config config = new Config();
        config.useSingleServer().setAddress(configAddress);
        return (new RedisStorage(Redisson.create(config)));
    }

    public void addUser(int n) {
        for (int i = 1; i <= n; i++) {
            users.add(getTs(), String.valueOf(i));
        }
    }

    public void writeAllUsers() {
        for (int i = 1; i <= users.size(); i++) {
            System.out.println(i + " - " + users.getScore(String.valueOf(i)));
        }
    }

    public void shutdown() {
        redisson.shutdown();
    }

}

