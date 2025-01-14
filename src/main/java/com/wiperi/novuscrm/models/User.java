package com.wiperi.novuscrm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;
}

class UserTest {
    public static void main(String[] args)
    {
        User user = new User(1,"wjh","123456","wjh",18);
        System.out.println(user);
    }
}
