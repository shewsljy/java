package cn.jiayuli.allsome.user.vo;

import lombok.Data;

@Data
public class UserVo {
    private Long id;
    private String userCode;
    private String userName;
    private String userPassword;
    private Integer userAge;
}
