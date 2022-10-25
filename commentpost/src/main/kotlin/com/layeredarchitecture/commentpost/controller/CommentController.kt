package com.layeredarchitecture.commentpost.controller

import com.layeredarchitecture.commentpost.domain.Comment
import com.layeredarchitecture.commentpost.dto.CommentRequest
import com.layeredarchitecture.commentpost.dto.CommentResponse
import com.layeredarchitecture.commentpost.service.CommentService
import com.layeredarchitecture.commentpost.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/posts")
class CommentController(var commentService: CommentService, val postService: PostService) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}/comments")
    fun createComment(@RequestBody commentRequest: CommentRequest, @PathVariable("id") id:String): CommentResponse {
        val post = postService.getPost(id)
        val createdComment =  Comment(UUID.randomUUID().toString(),commentRequest.text)
        post?.addComment(createdComment)
        return CommentResponse(createdComment.id, createdComment.text)

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}/comments")
    fun getCommentById(@PathVariable("id") id:String): CommentResponse? {
        var fetchComment = commentService.getComment(id);
        if (fetchComment != null) {
            return CommentResponse(fetchComment.id, fetchComment.text)
        }
        return null
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("comments")
    fun getAllComment(): List<CommentResponse>? {
        var fetchComments = commentService.getAllComments();
        if (fetchComments != null) {
            return fetchComments.map{ comment -> CommentResponse(comment.id, comment.text)
            }
        }
        return null
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("{id}/comments")
    fun updateComment(@PathVariable("id") id:String, @RequestBody commentRequest:CommentRequest): CommentResponse {
        val updatedComment = commentService.updateComment(Comment(id,commentRequest.text), id)
        return CommentResponse(updatedComment.id, updatedComment.text)


    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}/comments")
    fun deleteComment(@PathVariable("id") id:String){
        commentService.deleteComment(id)
    }

}