package com.colm.api

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
