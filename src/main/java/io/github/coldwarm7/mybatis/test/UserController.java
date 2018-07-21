package io.github.coldwarm7.mybatis.test;

import io.github.coldwarm7.mybatis.inter.UserMapper;
import io.github.coldwarm7.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by coldwarm on 2018/7/21.
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/findById/{id}")
    public User findById(@PathVariable int id){
        return userMapper.findById(id);
    }

    @RequestMapping("/addUser")
    public void addUser(){
        //User user = new User("zzz","222","zzzz");
        userMapper.insert("zzz","25","www");
    }

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userMapper.findAll();
    }

}
