package io.github.coldwarm7.mybatis.test;

/**
 * Create by coldwarm on 2018/7/20.
 */

import java.io.Reader;
import java.util.List;

import io.github.coldwarm7.mybatis.model.User;
import io.github.coldwarm7.mybatis.inter.IUserOperation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    public static void main(String[] args) {
//        findById(1);
//        findAll("%");
//        System.out.println();
//        addUser("coldwarmtree","22","china");
//        findAll("%");
//        updateUser();
//        findAll("%");
        deleteUser(8);
        findAll("%");
    }

    public static void findById(int id){
        SqlSession session = sqlSessionFactory.openSession();
        IUserOperation iUserOperation = session.getMapper(IUserOperation.class);
        User user = iUserOperation.selectUserByID(id);
        System.out.println(user.getUserName() + ": " + user.getUserAge());

        session.close();
    }

    public static void findAll(String userName){
        SqlSession session = sqlSessionFactory.openSession();

        IUserOperation iUserOperation = session.getMapper(IUserOperation.class);
        List<User> users = iUserOperation.selectUsers(userName);
        for (User user : users){
            System.out.println(user.getId() + ", " +
                    user.getUserName() + ", " + user.getUserAddress());
            session.close();
        }
    }

    public static void addUser(String userName,String userAge,String userAddress){
        User user = new User(userName,userAge,userAddress);
        SqlSession session = sqlSessionFactory.openSession();

        IUserOperation iUserOperation = session.getMapper(IUserOperation.class);
        iUserOperation.addUser(user);
        session.commit();

        System.out.println("当前增加的用户id为: " + user.getId());

        session.close();
    }

    public static void updateUser(){
        SqlSession session = sqlSessionFactory.openSession();
        IUserOperation iUserOperation = session.getMapper(IUserOperation.class);
        User user = iUserOperation.selectUserByID(7);
        user.setUserName("coldwarmmm");
        iUserOperation.updateUser(user);
        session.commit();

        session.close();
    }

    public static void deleteUser(int id){
        SqlSession session = sqlSessionFactory.openSession();
        IUserOperation iUserOperation = session.getMapper(IUserOperation.class);

        iUserOperation.deleteUser(id);
        session.commit();

        session.close();
    }
}
