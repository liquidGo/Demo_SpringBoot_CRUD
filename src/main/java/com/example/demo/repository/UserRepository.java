package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    // 基础的 CRUD 操作已经由 JpaRepository 提供
    // 如果需要自定义查询方法可以在这里添加，例如：
    // UserModel findByName(String name);
}
