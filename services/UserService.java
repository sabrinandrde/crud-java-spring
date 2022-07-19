package br.com.aulaapi.services;

import br.com.aulaapi.entities.User;
import br.com.aulaapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> searchUser(){
        return userRepository.findAll();
    }

    public User searchUser(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user){
        user.getPhones().forEach(phone -> phone.setUser(user));
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }


}
