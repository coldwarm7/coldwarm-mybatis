package io.github.coldwarm7.mybatis.inter;

import io.github.coldwarm7.mybatis.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by coldwarm on 2018/7/21.
 */
@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user where id=#{id}")
    @Results(
            {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "userName",property = "userName"),
                    @Result(column = "userAge", property = "userAge"),
                    @Result(column = "userAddress", property = "userAddress")
            }
    )
    User findById(@Param("id") int id);

    @Insert("insert into user(userName, userAge, userAddress) values (#{userName}, #{userAge}, #{userAddress})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(@Param("userName") String userName,@Param("userAge") String userAge,@Param("userAddress") String userAddress);

    @Select("select id, userName, userAge, userAddress from user")
//    @ResultMap("User.resultListMap")
    @Results(
            {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "userName",property = "userName"),
                    @Result(column = "userAge", property = "userAge"),
                    @Result(column = "userAddress", property = "userAddress")
            }
    )
    List<User> findAll();

}
