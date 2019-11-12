package cn.jiayuli.honey.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * ClassName: User <br>
 * Description: TODO
 *
 * @author jiayu
 * @version V1.0
 * @date 2019/11/06
 */
@Data
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = -3953579749626234285L;

    @Id
    private Long id;

    private String name;

    private String sex;

    private Integer age;
}
