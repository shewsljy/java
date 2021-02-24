package cn.jiayuli.allsome.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@Table(name = "t_user")
public class UserBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String userCode;
    @Column
    private String userName;
    @Column
    private String userPassword;
    @Column
    private Integer userAge;
}
