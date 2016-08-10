package com.colm.api

import grails.rest.*


@Resource(uri = '/user', formats = ['json', 'xml'])
class User {
  String gender

  static constraints = {
    gender inList: ['male', 'female']
  }
}
