package ru.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.spring.DAO.UserDao;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserDao userDao;

    @Autowired
    public UsersController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userDao.index());
        return "users/index";
    }
    @GetMapping("/{id}")
    public String show (@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDao.show(id));
        return "users/show";
    }
}