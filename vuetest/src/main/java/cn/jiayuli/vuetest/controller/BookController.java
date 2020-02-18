package cn.jiayuli.vuetest.controller;

import cn.jiayuli.vuetest.entity.Book;
import cn.jiayuli.vuetest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: BookController <br>
 * Description: TODO
 *
 * @author jiayu
 * @version V1.0
 * @date 2020/02/17
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/findAll")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
