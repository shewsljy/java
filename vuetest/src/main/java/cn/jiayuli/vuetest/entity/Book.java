package cn.jiayuli.vuetest.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * ClassName: Book <br>
 * Description: TODO
 *
 * @author jiayu
 * @version V1.0
 * @date 2020/02/17
 */
@Entity
@Data
public class Book {
    @Id
    private Integer id;
    private String name;
    private String author;
}
