package com.wiperi.novuscrm.mappers;
import com.wiperi.novuscrm.models.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM world.user")
    List<User> findAllUsers();

    @Select("SELECT * FROM world.user WHERE username = #{username} and id = #{id}")
    List<User> findUserByIdAge(@Param("id") Integer id, @Param("username") String username);

    @Delete("DELETE FROM world.user where id = #{id}")
    Integer deleteUser(Integer id);

    @Insert("INSERT INTO world.user(id,userName,password,name,age) VALUES (#{id},#{username},#{password},#{name},#{age})")
    Integer addUser(User user);

    @Update("UPDATE world.user SET userName = #{username}, password = #{password}, name = #{name}, age = #{age} WHERE id = #{id}")
    Integer updateUser(User user);

    List<User> findAllUsersXML();
}