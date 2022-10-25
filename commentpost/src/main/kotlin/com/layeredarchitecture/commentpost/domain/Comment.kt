package com.layeredarchitecture.commentpost.domain

import javax.persistence.*

@Entity
@Table(name= "comment")
class Comment(
    @Id val id:String,
    val text:String,
    @ManyToOne
    @JoinColumn(name = "post_id")
    private var post: Post? = null){


}