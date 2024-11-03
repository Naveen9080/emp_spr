package com.tryit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tryit.demo.model.Login;
import java.util.List;


@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
	Login getByEmailId(String emailId);
}
