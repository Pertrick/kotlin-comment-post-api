package com.layeredarchitecture.commentpost.domain

import javax.persistence.*

@Entity
@Table(name="post")
data class Post(@Id var id:String, var text:String) {

    @OneToMany
    @JoinColumn(name="post_id")
    private val _comments = mutableListOf<Comment>()
    val comments get() = _comments.toList()
    fun addComment(newComment:Comment) {
        _comments.add(newComment)
    }


}