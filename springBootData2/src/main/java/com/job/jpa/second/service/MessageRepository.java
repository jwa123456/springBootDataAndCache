package com.job.jpa.second.service;


import com.job.jpa.second.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepository extends JpaRepository<Message, Long> {


}
