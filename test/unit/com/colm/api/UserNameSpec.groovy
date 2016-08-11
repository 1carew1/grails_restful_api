package com.colm.api

import grails.test.mixin.TestFor
import grails.validation.ValidationException
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(UserName)
class UserNameSpec extends Specification {
  User user

  def setup() {
    def mockUser = mockFor(User)
    user = (User) mockUser.createMock()
  }

  def cleanup() {
  }

  def "A User Name must have a user"() {
    given:
    UserName un = new UserName()
    when:
    un.save(failOnError: true)
    then:
    ValidationException ex = thrown()
  }

  def "A User Name must have a first name"() {
    given:
    UserName un = new UserName(user: user, last: 'carew', title: 'mr')
    when:
    un.save(failOnError: true)
    then:
    ValidationException ex = thrown()
  }

  def "A User Name must have a last name"() {
    given:
    UserName un = new UserName(user: user, first: 'colm', title: 'mr')
    when:
    un.save(failOnError: true)
    then:
    ValidationException ex = thrown()
  }

  def "A User Name must have a title within the list"() {
    given:
    UserName un = new UserName(user: user, first: 'colm', last: 'carew', title: 'Something Crazy')
    when:
    un.save(failOnError: true)
    then:
    ValidationException ex = thrown()
  }
}
