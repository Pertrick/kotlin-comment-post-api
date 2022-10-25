package com.layeredarchitecture.commentpost.service

import com.layeredarchitecture.commentpost.domain.Comment
import com.layeredarchitecture.commentpost.domain.Post
import com.layeredarchitecture.commentpost.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService(@Autowired var postRepository: PostRepository) {
    fun createPost(post: Post): Post{
        return postRepository.save(post)
    }

    fun getAllPosts(): List<Post>? {
        return postRepository.findAll()
    }

    fun getPost(id: String): Post? {
        return postRepository.findById(id).orElse(null)
    }

    fun updatePost(post: Post, id: String): Post {
        postRepository.findById(id).orElse(null)
        return postRepository.save(post)
    }

    fun deletePost(id: String) {
        val post = postRepository.findById(id).orElse(null)
        if(post != null){
            postRepository.deleteById(post.id)
        }

    }

}