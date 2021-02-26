package cn.jiayuli.allsome.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String userCode;
    private String userName;
    private String userPassword;
    private Integer userAge;
}
