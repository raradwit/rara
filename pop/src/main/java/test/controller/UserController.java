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

//    @RequestMapping("/user")
//    public ModelAndView getUser(@RequestParam("id") int id) {
//        System.out.println("user id is: " + users.getUser(id));
//
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("user");
////        String str = "test";
//        User u = users.getUser(id);
//        mav.addObject("message", u);
//
//        return mav;
//    }

    /*Even we write
    * @RequestMapping("add") or
    * @RequestMapping("/add")
    * it will map as same as /add do.
    * */

    @RequestMapping(value="/",method= RequestMethod.GET)
    public String adduser(Model model) {
        model.addAttribute("greeting",new User());
        return "Add User";
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String insertUser(@ModelAttribute User user,Model model) {

        users.insert(user);
        List<User> userList = users.getAllUser();
        System.out.println("ulist: "+userList);
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

}
