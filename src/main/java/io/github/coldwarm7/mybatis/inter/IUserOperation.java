package io.github.coldwarm7.mybatis.inter;

import io.github.coldwarm7.mybatis.model.User;

import java.util.List;

/**
 * Create by coldwarm on 2018/7/20.
 */

public interface IUserOperation {
    User selectUserByID(int id);

    List selectUsers(String userName);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);
}
