package com.ShoppingCart.Shopping.Controller;

import com.ShoppingCart.Shopping.Models.User;
import com.ShoppingCart.Shopping.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userServices.viewUsers();
    }

    @PostMapping("/add")
    public void addUser(User user) {
        userServices.addUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void removeUser(Long id) {
        userServices.removeUser(id);
    }

    @PutMapping("/update/{id}")
    public void updateUser(Long id,String username, String password)
    {
        userServices.updateUser(id,username,password);
    }
}
