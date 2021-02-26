package cn.jiayuli.allsome.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String userCode;
    private String userName;
    private String userPassword;
    private Integer userAge;
}
