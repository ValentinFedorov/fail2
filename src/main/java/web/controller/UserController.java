package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping(value = "/")
    public String showAllUsers (Model model) {
        List<User> allUsers = userDao.getAllUsers();
        model.addAttribute("allUsers", allUsers);

        return "all-users";
    }
}
