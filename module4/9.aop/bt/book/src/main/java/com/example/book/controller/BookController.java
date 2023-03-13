package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.model.OrderBook;
import com.example.book.service.IBookService;
import com.example.book.service.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService bookService;
    @Autowired
    OrderBookService orderBookService;

    @GetMapping("list")
    public String showList(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("book", bookList);
        return "list";
    }

    @GetMapping("/{id}/order")
    public String orderBook(@PathVariable int id, Model model) {
        OrderBook orderBook = new OrderBook();
        int code = (int) (Math.random() * (99999 - 10000) + 11111);
        orderBook.setCode(code);
        orderBook.setDate(new Date(System.currentTimeMillis()));
        orderBook.setBook(bookService.findById(id));
        orderBookService.save(orderBook);
        model.addAttribute("order", orderBook);
        model.addAttribute("book", bookService.findById(id));
        return "order";
    }

    @GetMapping("/lend")
    public String viewBookLend(@RequestParam int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
//        model.addAttribute("order", orderBookService.findById(id));
        return "lend";
    }

//    @PostMapping("/lend")
//    public String lendBook(@PathVariable int id, Model model) throws Exception{
//        Book book = bookService.findById(id);
//
//    }

    @PostMapping("/order")

    public String saveOrder(@RequestParam int id, Book book, Model model) throws Exception {
        Book book1 = bookService.findById(id);
        book1.setCount(book1.getCount() - 1);
        if (book1.getCount() == -1) {
            throw new Exception();
        }
        bookService.save(book1);
        model.addAttribute("book", bookService.findAll());
        return "list";
    }


    @GetMapping("/view")
    public String viewOrder(@RequestParam int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("order", orderBookService.findById(id));
        return "view";
    }

    @ExceptionHandler(Exception.class)
    public String error() {
        return "error";
    }
}
