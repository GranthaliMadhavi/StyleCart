package com.stylecart.stylecart.Service;

import com.stylecart.stylecart.entity.User;
import com.stylecart.stylecart.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Optional;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User saveUser(User user){

    String encodedPassword =
            passwordEncoder.encode(user.getPassword());

    user.setPassword(encodedPassword);

    return userRepository.save(user);

}

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
