package cn.jiayuli.allsome.vo;

import lombok.Data;

@Data
public class UserVO {
    private Long id;
    private String userCode;
    private String userName;
    private String userPassword;
    private Integer userAge;
}
