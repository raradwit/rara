package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import test.domain.User;
import test.service.UserRepository;

import java.util.List;

/**
 * Created by saneel on 8/23/15.
 */
@Controller
public class UserController {
    @Autowired
    private UserRepository users;

    /*Even we write
    * @RequestMapping("add") or
    * @RequestMapping("/add")
    * it will map as same as /add do.
    * */

    @RequestMapping(value="/",method= RequestMethod.GET)
    public String adduser() {
        return "Add User";
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String insertUser(@ModelAttribute User user,Model model) {
        users.insert(user);
        List<User> userList = users.getAllUser();
        model.addAttribute("user", userList);
        return "Show Users";
    }


    @RequestMapping("/edit")
    public String editUser(@RequestParam("id") int id,Model model) {
        User u = users.edit(id);
        model.addAttribute("user",u);
        return "edit User";
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public String update(@ModelAttribute User user,Model model) {
        users.update(user);
        List<User> userList = users.getAllUser();
        model.addAttribute("user",userList);
        return "Show Users";
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam("id") int id,Model model) {
        users.delete(id);
        List<User> userList = users.getAllUser();
        model.addAttribute("user",userList);
        return "Show Users";
    }



}
