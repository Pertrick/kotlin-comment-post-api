package com.layeredarchitecture.commentpost.repository

import com.layeredarchitecture.commentpost.domain.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository : JpaRepository<Comment, String>{


}