package com.ShoppingCart.Shopping.Services;

import com.ShoppingCart.Shopping.Models.User;

import java.util.List;

public interface UserInterfaceService {

    List<User> viewUsers();
    void addUser(User user);

    void removeUser(Long id);
    void updateUser(Long id, String username, String password);
}
