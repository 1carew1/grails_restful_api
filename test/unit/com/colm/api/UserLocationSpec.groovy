package com.colm.api

import grails.test.mixin.TestFor
import grails.validation.ValidationException
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(UserLocation)
class UserLocationSpec extends Specification {
  User user

  def setup() {
    def mockUser = mockFor(User)
    user = (User) mockUser.createMock()
  }

  def cleanup() {
  }

  def "A Location will fail to save if it does not have necssary fields"() {
    given:
    UserLocation ul = new UserLocation()
    when:
    ul.save(failOnError: true)
    then:
    ValidationException ex = thrown()
  }

  def "A Location must have all necessary fields to save"() {
    given:
    UserLocation ul = new UserLocation(user: user, street: 'West', city: 'Waterford', state: 'WA', zip: 1234)
    when:
    ul.save(failOnError: true)
    then:
    noExceptionThrown()
  }

  def "A Location does not need a zip"() {
    given:
    UserLocation ul = new UserLocation(user: user, street: 'West', city: 'Waterford', state: 'WA')
    when:
    ul.save(failOnError: true)
    then:
    noExceptionThrown()
  }
}
