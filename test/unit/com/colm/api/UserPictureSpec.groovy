package com.colm.api

import grails.test.mixin.TestFor
import grails.validation.ValidationException
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(UserPicture)
class UserPictureSpec extends Specification {
  User user

  def setup() {
    def mockUser = mockFor(User)
    user = (User) mockUser.createMock()
  }

  def cleanup() {
  }

  void "A User Picture can contain no image urls"() {
    given:
    UserPicture up = new UserPicture(user: user)
    when:
    up.save(failOnError: true)
    then:
    noExceptionThrown()
  }

  void "A User Picture must have a user"() {
    given:
    UserPicture up = new UserPicture()
    when:
    up.save(failOnError: true)
    then:
    ValidationException ex = thrown()
  }
}
