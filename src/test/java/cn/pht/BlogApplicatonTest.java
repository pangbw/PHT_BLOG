/*
 * 版权所有 (c) 2021. 写Bug的小杜 <https://github.com/shaoxiongdu>  保留所有权利
 */

package cn.pht;

import cn.pht.po.User;
import cn.pht.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@SpringBootTest
public class BlogApplicatonTest {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    public void test1() throws IOException {
        User user = new User();

        user.setId(2L);
        user.setUsername("pangbw");
        user.setPassword("123456");
        user.setNickname("pangbw");
        user.setEmail("2761268695@qq.com");
        user.setCreateTime(new Date().from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        user.setCreateTime(new Date().from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        user.setAvatar("https://pongbw-learn.oss-cn-chengdu.aliyuncs.com/%E5%A4%B4%E5%83%8F%EF%BC%88%E6%96%B9%EF%BC%89.jpg");
        user.setType(1);
        user.setBlogs(null);

        User user1 = userServiceImpl.checkUser("pangbw","123456");

        System.out.println(user1);

    }

}
