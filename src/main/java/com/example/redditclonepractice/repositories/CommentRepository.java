package com.example.redditclonepractice.repositories;

import com.example.redditclonepractice.model.Comment;
import com.sun.mail.imap.protocol.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, ID> {
}
