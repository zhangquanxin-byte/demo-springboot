package demo;

import demo.pojo.User;
import demo.service.UserService;
import demo.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BaseTest {

    @Autowired(required=true)
    private UserService userService;

    @Test
    public void testUser() {
        /*User user = new User(12,"2625324336","123456789");
        String s = userService.addUser(user);
        System.out.println("s = " + s);
        Assert.assertEquals("两者一致：","2",s);*/
    }
}
