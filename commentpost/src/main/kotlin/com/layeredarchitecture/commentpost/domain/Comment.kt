package com.layeredarchitecture.commentpost.domain

import javax.persistence.*

@Entity
class Comment(@Id val id:String, val text:String){

}