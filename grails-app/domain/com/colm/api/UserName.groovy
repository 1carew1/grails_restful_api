package com.colm.api

/**
 * The UserName Domain keeps track of the user's title and name
 * It persists to the database when the user is saved
 */

class UserName {

  String title
  String first
  String last

  static constraints = {
    title inList: ['miss', 'mister', 'ms', 'mrs', 'mr']
    first nullable: false
    last nullable: false
  }

  static belongsTo = [user : User]
}
