package com.layeredarchitecture.commentpost.service

import com.layeredarchitecture.commentpost.domain.Comment
import com.layeredarchitecture.commentpost.repository.CommentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CommentService(@Autowired var commentRepository: CommentRepository) {
    fun createComment(comment: Comment): Comment{
        return commentRepository.save(comment)
    }

    fun getAllComments(): List<Comment>? {
        return commentRepository.findAll()
    }

    fun getComment(id: String): Comment? {
        return commentRepository.findById(id).orElse(null)
    }

    fun updateComment(comment: Comment, id: String): Comment {
        commentRepository.findById(id).orElse(null)
        return commentRepository.save(comment)
    }

    fun deleteComment(id: String) {
        val comment = commentRepository.findById(id).orElse(null)
        if(comment != null){
            commentRepository.deleteById(comment.id)
        }

    }

}