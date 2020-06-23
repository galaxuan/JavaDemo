package com.demo.controller;

import com.demo.entity.Team;
import com.demo.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: javademo
 * @description:
 * @author: wanggang
 * @create: 2019-11-15 15:39
 */
@RestController
public class UserController {

    @RequestMapping("/hi")
    public String hi() {
        return "hhh";
    }

    @RequestMapping("/myTest0")
    public String myTest0(@RequestBody String userString) {
        System.out.println(userString);
        return userString;
    }

    @RequestMapping("/myTest1")
    public String myTest1(@RequestBody User user) {
        System.out.println(user.toString());
        return user.toString();
    }

    @RequestMapping("/myTest2")
    public String myTest2(@RequestBody Team team) {
        System.out.println(team.toString());
        return team.toString();
    }

    @RequestMapping("/myTest3")
    public String myTest3(@RequestBody User user, @RequestParam("token") String token) {
        System.out.println(user.toString());
        System.out.println(token);
        return token + ">>>" + user.toString();
    }

    @RequestMapping("/myTest4")
    public String myTest4(@RequestBody User user, @RequestParam("arrays") List<String> arrays) {
        System.out.println(user.toString());
        StringBuffer sb = new StringBuffer();
        for (String array : arrays) {
            sb.append(array);
            sb.append("  ");
            System.out.println(array);
        }
        return sb.toString() + ".." + user.toString();
    }

    @RequestMapping("/myTest5")
    public String myTest4(@RequestBody User user1, User user2) {
        System.out.println(user1.toString());
        System.out.println(user2.toString());
        return user2.toString() + ".." + user1.toString();
    }
}