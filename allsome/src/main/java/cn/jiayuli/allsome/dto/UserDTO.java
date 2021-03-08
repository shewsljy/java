package cn.jiayuli.allsome.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String code;
    private String name;
    private String password;
    private Integer age;
}
