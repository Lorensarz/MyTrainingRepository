import java.util.Random;

public class Main {

    private static final String CONFIG_ADDRESS = "redis://127.0.0.1:6379";
    private static final int COUNT_OF_USERS = 20;
    private static final int ONE_USER_BETWEEN = 10;

    public static void main(String[] args) {

        RedisStorage storage = RedisStorage.createConfig(CONFIG_ADDRESS);

        storage.addUser(COUNT_OF_USERS);
        storage.writeAllUsers();

    }


}

