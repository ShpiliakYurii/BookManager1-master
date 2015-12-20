package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Avtorisation;
import com.springapp.mvc.domain.Book;
import com.springapp.mvc.domain.User;
import com.springapp.mvc.repository.AvtorisationRepository;
import com.springapp.mvc.repository.BookRepository;
import com.springapp.mvc.repository.UserRepository;
import com.springapp.mvc.validation.AvtorisationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    private UserRepository userRepository;

    @Autowired
    public BookController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getBooks(Model model) {
        //List<Book> books = this.bookRepository.listAll();
//        List<User> users = this.userRepository.getAll();

        //model.addAttribute("books", books);
        //model.addAttribute("avt", avtorisations);

        return "index";
    }


    @RequestMapping(value = "addBook", method = RequestMethod.GET)
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @RequestMapping(value = "addBook", method = RequestMethod.POST)
    public String addBock(@ModelAttribute("book") Book book, Model model){
        //this.bookRepository.addBook(book);
        //model.addAttribute("avt",avtorisation);
        return "admin";
    }

    @RequestMapping(value = "validate", method = RequestMethod.POST)
    public String valdate(@RequestParam("login") String login, @RequestParam("pass") String pass,Model model){
        /*List<Avtorisation> avtorisations = this.avtorisationRepository.getAll();
        for(int i = 0; i < avtorisations.size();i++){
            if (avtorisations.get(i).getLogin().equals(login)){
                if (avtorisations.get(i).getPass().equals(pass))
                    model.addAttribute("role",avtorisations.get(i).getRole());
                return "admin";
            }
        }*/
        List<User> users = this.userRepository.getAll();
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getLogin().equals(login)){
                if(users.get(i).getPass().equals(pass)) {
                    if (users.get(i).getRole().equals("admin")){
                        model.addAttribute("admin",users.get(i));
                        return "admin";
                    }
                    if(users.get(i).getRole().equals("doctor")){
                        return "doctor";
                    }
                    if (users.get(i).getRole().equals("registry")){
                        return "registry";
                    }
                }
            }
        }

        return "index";
    }




}
