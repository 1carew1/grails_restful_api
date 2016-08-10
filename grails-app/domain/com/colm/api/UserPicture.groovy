package com.colm.api

class UserPicture {

  String large
  String medium
  String thumbnail

  static constraints = {
    large nullable: true
    medium nullable: true
    thumbnail nullable: true
  }

  static belongsTo = [user: User]
}
