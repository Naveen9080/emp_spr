package com.tryit.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.tryit.demo.model.Login;
import com.tryit.demo.model.TableMapping;
@Repository
@EnableJpaRepositories
public interface TabelRepository extends JpaRepository<TableMapping, Integer> {
     List<TableMapping> findByLogin(Login login);
}
