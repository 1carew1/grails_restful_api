package com.colm.api

import grails.rest.*

/**
 * This Domain is used to persist the user data using the grails built in rest features
 * It allows for both XML and JSON formats
 */

@Resource(uri = '/user', formats = ['json', 'xml'])
class User {
  String gender
  String email
  String username
  String phone
  String password
  String salt
  String md5
  String sha1
  String sha256
  String cell
  String PPS
  Long dob
  Long registered

  static constraints = {
    gender inList: ['male', 'female']
    email email: true
    username nullable: false, unique: true
    phone nullable: true
    cell nullable: true
    dob nullable: false
    registered nullable: false
    password nullable: false
    salt nullable: false
    md5 nullable: false
    sha1 nullable: false
    sha256 nullable: false
  }

  static hasOne = [name: UserName, location: UserLocation, picture: UserPicture]

  /**
   * The purpose of this method is to find users with usernames
   * Similar to the given username
   * @param username
   * @return
   */
  static List<User> findUsersWithUsernamesLike(String username) {
    def userCriteria = createCriteria()
    def results = (List<User>) userCriteria.list {like('username', "%$username%")}
    return results
  }

  /**
   * The purpose of this method is to find all users with the
   * given last name
   * @param lastName
   * @return
   */
  static List<User> findUsersWithLastName(String lastName) {
    def userCriteria = createCriteria()
    def results = (List<User>) userCriteria.list {eq('name.last', lastName)}
    return results
  }
}
