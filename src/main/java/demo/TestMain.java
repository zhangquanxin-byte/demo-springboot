package demo;


import demo.pojo.User;
import org.apache.lucene.util.RamUsageEstimator;

import java.util.ArrayList;
import java.util.UUID;

public class TestMain {
    private int stackLength = 0;

    public static void main(String[] args) {
        final ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i <1000 ; i++) {
            final User user = new User();
            user.setId(i);
            user.setPassword(UUID.randomUUID().toString());
            user.setUsername("123f");
            user.setAddress("adadadadadadrwwrwrwr");
            user.setAge(i + 199);
            users.add(user);
        }
        System.out.println("users init value is " + RamUsageEstimator.sizeOf(users));
        System.out.println("users humanSizeOf value is " + RamUsageEstimator.humanSizeOf(users));
    }

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
}
