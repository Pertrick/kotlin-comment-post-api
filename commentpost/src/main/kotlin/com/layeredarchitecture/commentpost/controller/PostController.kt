package com.layeredarchitecture.commentpost.controller

import com.layeredarchitecture.commentpost.domain.Post
import com.layeredarchitecture.commentpost.dto.PostRequest
import com.layeredarchitecture.commentpost.dto.PostResponse
import com.layeredarchitecture.commentpost.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/posts")
class PostController(var postService: PostService) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createPost(@RequestBody postRequest: PostRequest): PostResponse {
        var createdPost = postService.createPost(Post(UUID.randomUUID().toString(), postRequest.text));
        return PostResponse(createdPost.id, createdPost.text, emptyList())
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    fun getPostById(@PathVariable("id") id:String): PostResponse? {
        var fetchPost = postService.getPost(id);
        if (fetchPost != null) {
            return PostResponse(fetchPost.id, fetchPost.text,fetchPost.comments)
        }
        return null
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    fun getAllPost(): List<PostResponse>? {
        var fetchPosts = postService.getAllPosts();
        if (fetchPosts != null) {
            return fetchPosts.map{ post -> PostResponse(post.id, post.text, post.comments)
            }
        }
        return null
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    fun updatePost(@PathVariable("id") id:String, @RequestBody postRequest:PostRequest): PostResponse? {
        var postComment = postService.getPost(id)
        if(postComment != null){
            val updatedPost = postService.updatePost(Post(id,postRequest.text, postComment.comments), id)
            return PostResponse(updatedPost.id, updatedPost.text, updatedPost.comments)
        }
        return  null
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable("id") id:String){
        postService.deletePost(id)
    }

}