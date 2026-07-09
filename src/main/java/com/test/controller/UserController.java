package com.test.controller;

import com.test.dto.UserDTO;
import com.test.model.User;
import com.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // GET 查询所有用户（不含密码）
    @GetMapping
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserDTO(
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }

    // GET 根据ID查询单个用户（不含密码）
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("用户不存在，ID: " + id));
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }
}