package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    // 创建用户
    @PostMapping
    public UserModel createUser(@RequestBody UserModel user) {
        return userRepository.save(user);
    }
    
    // 获取所有用户
    @GetMapping
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }
    
    // 根据ID获取用户
    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    
    // 更新用户
    @PutMapping("/{id}")
    public UserModel updateUser(@PathVariable Integer id, @RequestBody UserModel user) {
        user.setId(id);
        return userRepository.save(user);
    }
    
    // 删除用户
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }
}
