package com.colm.api

/**
 * This domain is used to track the user's profile photo via String URLs
 * It persists to the database when the user is saved
 */


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
