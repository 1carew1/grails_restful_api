package com.colm.api

/**
 * This domain is used to track the location of a user and as it is a domain it will
 * persist to the database when the user is saved
 */

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
