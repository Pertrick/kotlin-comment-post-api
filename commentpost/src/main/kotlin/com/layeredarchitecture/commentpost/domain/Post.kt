package com.layeredarchitecture.commentpost.domain

import javax.persistence.*

@Entity
class Post(
    @Id var id:String,
    var text:String,
    @OneToMany(cascade = [CascadeType.ALL])
    @Column(nullable = true)
    val comments: List<Comment> = emptyList()

) {




}