package com.iptech.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iptech.mysql.domain.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long>{

}
