package com.spring.boot.springbootrestapi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.springbootrestapi.model.Books;

public interface BookRepository extends JpaRepository<Books,Integer>{
    
}
