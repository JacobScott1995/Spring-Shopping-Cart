package com.ShoppingCart.Shopping.Services;

import com.ShoppingCart.Shopping.Models.User;
import com.ShoppingCart.Shopping.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class UserServices implements UserInterfaceService {

    private final UserRepository userRepository;

    private Map<User,Long> userMap = new HashMap<>();

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> viewUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user){
    userRepository.save(user);
    }

    @Override
    public void removeUser(Long id) {
        boolean a = userRepository.existsById(id);
        if(a){
            userRepository.deleteById(id);
        }
        else {
            System.out.println("User not found");
        }
    }

    @Override
    public void updateUser(Long id, String username, String password) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            user.get().setUsername(username);
            user.get().setPassword(password);
            userRepository.save(user.get());
        }


    }
}
