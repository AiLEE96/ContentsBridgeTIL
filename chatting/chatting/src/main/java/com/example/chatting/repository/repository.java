package com.example.chatting.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.chatting.entity.Member;

@Repository
public interface repository extends JpaRepository<Member, Long> {
    
    Optional<Member> findById(String id); 
    
}