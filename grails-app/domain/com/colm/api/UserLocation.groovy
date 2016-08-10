package com.colm.api

class UserLocation {

  String street
  String city
  String state
  Long zip


  static constraints = {
    street nullable: false
    city nullable: false
    state nullable: false
    zip nullable: true
  }

  static belongsTo = [user : User]
}
