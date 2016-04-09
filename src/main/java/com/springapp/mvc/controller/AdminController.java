package com.springapp.mvc.controller;

import com.springapp.mvc.domain.User;
import com.springapp.mvc.repository.TableRepository;
import com.springapp.mvc.repository.UserRepository;
import com.springapp.mvc.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Yurii on 16.10.2015.
 */
@Controller
public class AdminController extends TableController {

    private UserRepository userRepository;
    private UserValidator userValidator;
    private DoctorController doctorController;

    private boolean checkUser(User user, String role) {
        if (user != null) {
            List<User> users = this.userRepository.getAll();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getLogin().equals(user.getLogin())) {
                    if (users.get(i).getPass().equals(user.getPass())) {
                        if (user.getRole().equals(role))
                            return true;
                    }
                }
            }
        }
        return false;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getBooks() {
        return "index";
    }

    @Autowired
    public AdminController(UserRepository userRepository, UserValidator userValidator,
                           DoctorController doctorController, TableRepository tableRepository) {
        super(tableRepository);
        this.userRepository = userRepository;
        this.userValidator = userValidator;
        this.doctorController = doctorController;
        initTables();
    }



    @Override
    public void initTables() {
        Table t = new Table("apparatus", "Апарати", getTableRepository());
        t.addField(new Field("id", Field.TYPES.INT, "Ід", "", true, false));
        t.addField(new Field("name", Field.TYPES.VARCHAR, "Назва", "", false, true));
        try {
            t.addBeforeListener(Events.class.getMethod("validateApparatus", Table.class));
        }catch (Exception e){}
        this.getTables().add(t);
        t = new Table("medicinecard1", "Пацієнти", getTableRepository());
        t.addField(new Field("id", Field.TYPES.INT, "Ід", "", true, false));
        t.addField(new Field("pib", Field.TYPES.VARCHAR, "ПІБ", "", false, true));
        t.addField(new Field("adress", Field.TYPES.VARCHAR, "Адреса", "", false, true));
        t.addField(new Field("burnDate", Field.TYPES.DATE, "Дата народження", "", false, true));
        t.addField(new Field("identifyCode", Field.TYPES.VARCHAR, "Ідентифікаційний код", "", false, true));
        try {
            t.addBeforeListener(Events.class.getMethod("validateMedicinecard", Table.class));
        }catch (Exception e){}
        this.getTables().add(t);
        t = new Table("manipulations", "Маніпуляції", getTableRepository());
        Field f = new Field("id", Field.TYPES.INT, "ID", "", true, false);
        t.addField(f);
        f = new Field("value", Field.TYPES.VARCHAR, "Значення", "", false, true);
        t.addField(f);
        f = new Field("manipulation_dictionary_id", Field.TYPES.FK, "Назва маніпуляції", "", false, true);
        f.setFk("manipulation_dictionary", "id", "name");
        t.addField(f);
        f = new Field("revisions_id", Field.TYPES.FK, "Номер обстеження", "", false, true);
        f.setFk("revisions", "id", "id");
        t.addField(f);
        f = new Field("place", Field.TYPES.VARCHAR, "Опис", "", false, true);
        t.addField(f);
        this.getTables().add(t);
        t = new Table("manipulation_dictionary", "Словник маніпуляцій", getTableRepository());
        f = new Field("id", Field.TYPES.INT, "ID", "", true, false);
        t.addField(f);
        f = new Field("name", Field.TYPES.VARCHAR, "Назва маніпуляції", "", false, true);
        t.addField(f);
        t.setMainTemplate("Виконані маніпуляції", "manipulation_dictionary_id", "2", "id");
        t.setMainTemplateVisible(true);
        t.setMainTemplateCaption("Виконані маніпуляції");

        this.getTables().add(t);
    }


    @RequestMapping(value = "userList", method = RequestMethod.GET)
    public String userList(Model model, HttpSession httpSession) {
        if (!checkUser(((User) httpSession.getAttribute("user")), "admin")) {
            return "index";
        }
        List<User> users = this.userRepository.getAll();
        model.addAttribute("users", users);
        return "userList";
    }

    @RequestMapping(value = "removeUser/{id}", method = RequestMethod.GET)
    public String removeUser(@PathVariable Integer id, HttpSession httpSession) {
        if (!checkUser(((User) httpSession.getAttribute("user")), "admin")) {
            return "index";
        }
        this.userRepository.removeUser(id);
        return "redirect:/userList";
    }

    @RequestMapping(value = "addUser", method = RequestMethod.GET)
    public String addUser(Model model, HttpSession httpSession) {
        if (!checkUser(((User) httpSession.getAttribute("user")), "admin")) {
            return "index";
        }
        model.addAttribute("user", new User());
        return "addUser";
    }

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, BindingResult bindingResult, HttpSession httpSession) {
        if (!checkUser(((User) httpSession.getAttribute("user")), "admin")) {
            return "index";
        }
        this.userValidator.setUserRepository(userRepository);
        this.userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "addUser";
        }
        this.userRepository.addUser(user);
        return "redirect:/userList";
    }

    @RequestMapping(value = "validate", method = RequestMethod.POST)
    public String validate(@RequestParam("login") String login, @RequestParam("pass") String pass, Model model, HttpSession httpSession) {
        List<User> users = this.userRepository.getAll();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login)) {
                if (users.get(i).getPass().equals(pass)) {
                    httpSession.setAttribute("user", users.get(i));
                    if (users.get(i).getRole().equals("admin")) {
                        model.addAttribute("admin", users.get(i));
                        return "admin";
                    }
                    if (users.get(i).getRole().equals("doctor")) {
                        return doctorController.revisionList(model, httpSession);
                    }
                    if (users.get(i).getRole().equals("registry")) {
                        return "registry";
                    }
                }
            }
        }
        return "index";
    }
}
