package com.wiperi.novuscrm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public static void main(String[] args) {
        Department de = new Department(1, "Test", LocalDateTime.now(), LocalDateTime.now());
        System.out.println(de);
    }
}

