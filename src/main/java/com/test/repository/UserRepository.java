package com.test.repository;

import com.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 可以在这里添加自定义查询方法，比如按用户名查询
    // User findByUsername(String username);
}