package com.tryit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tryit.demo.model.Details;
import com.tryit.demo.model.TableMapping;

import java.util.List;


@Repository
public interface DetailsRepository extends JpaRepository<Details,Integer>{
     List<Details> findByDmap(TableMapping dmap);
     void deleteByDmap(TableMapping dmap);
}
