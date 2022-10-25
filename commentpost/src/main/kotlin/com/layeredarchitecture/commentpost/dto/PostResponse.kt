package com.layeredarchitecture.commentpost.dto

import com.layeredarchitecture.commentpost.domain.Comment

class PostResponse(val id:String, val text:String, val comment: List<Comment>) {
}