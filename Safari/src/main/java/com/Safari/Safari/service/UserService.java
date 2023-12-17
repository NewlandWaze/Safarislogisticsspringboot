package com.Safari.Safari.service;

import com.Safari.Safari.model.UserModel;
import com.Safari.Safari.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    public UserModel registerUser(String login, String email, String password){
        if (login == null || password == null){
            return null;
        }else{
            if(userRepo.findFirstByLogin(login).isPresent() && userRepo.findFirstByEmail(email).isPresent()){
                System.out.println("Duplicate login and Email");
                return null;
            }
            UserModel userModel = new UserModel();
            userModel.setLogin(login);
            userModel.setEmail(email);
            userModel.setPassword(password);
            return userRepo.save(userModel);
        }
    }

    public UserModel authenticate(String login, String password){
        return userRepo.findByLoginAndPassword(login, password).orElse(null);
    }
}
