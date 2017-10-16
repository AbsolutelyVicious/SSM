package cn.cntl.usermanage.test;

import cn.cntl.usermanage.pojo.User;
import cn.cntl.usermanage.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void setUp() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml",
                "spring/applicationContext-mybatis.xml", "spring/applicationContext-transaction.xml");
        this.userService = context.getBean(UserService.class);
    }

    @Test
    public void queryUsersByPage() throws Exception {
    }

    @Test
    public void queryEasyUIResult() throws Exception {
    }

    @Test
    public void addUser() throws Exception {
        User user1 = new User();
        user1.setUserName("狗蛋儿XX");
        user1.setPassword("123456");
        User user2 = new User();
        user2.setUserName("狗蛋儿OO");
        user2.setPassword("123456");
        this.userService.addUser(user1,user2);
    }

}