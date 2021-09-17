package cn.jiayuli.allsome.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserDTO implements Serializable {
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户年龄
     */
    private Integer userAge;

    /**
     * 用户密码
     */
    private String userPassWord;

    /**
     * 用户状态（0：正常；1：停用）
     */
    private Integer userStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人编码
     */
    private String createUserCode;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人编码
     */
    private String updateUserCode;

    private static final long serialVersionUID = 1L;
}
