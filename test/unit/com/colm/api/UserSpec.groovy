package com.colm.api

import grails.test.mixin.TestFor
import grails.validation.ValidationException
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

  UserName userName
  UserLocation userLocation
  UserPicture userPicture
  User perfectUser

  def setup() {
    def mockUserNameAsset = mockFor(UserName)
    userName = (UserName) mockUserNameAsset.createMock()

    def mockUserLocationAsset = mockFor(UserLocation)
    userLocation = (UserLocation) mockUserLocationAsset.createMock()

    def mockUserPictureAsset = mockFor(UserPicture)
    userPicture = (UserPicture) mockUserPictureAsset.createMock()

    perfectUser = new User(name: userName, picture: userPicture, location: userLocation, gender: 'male',
        email: 'colmcarew2@gmail.com', phone: '0833762454', dob: 1243423432, registered: 435345344, password: 'wafflrockones',
        salt: 'lypI10wj', md5: 'bbdd6140e188e3bf68ae7ae67345df65', sha256: 'ec0705aec7393e2269d4593f248e649400d4879b2209f11bb2e012628115a4eb',
        sha1: '4572d25c99aa65bbf0368168f65d9770b7cacfe6', PPS: '3423432', username: 'ccarew')
  }

  def cleanup() {
  }

  def "A user will save if all information is provided"() {
    given:
    perfectUser.validate()
    when:
    perfectUser.save(failOnError: true)
    then:
    noExceptionThrown()
  }

  def "User will not save if it does not have all the information"() {
    given:
    User u = new User(name: userName, picture: userPicture)
    when:
    u.save(failOnError: true)
    then:
    ValidationException ex = thrown()
  }

  def "A user must be male or female"() {
    given:
    perfectUser.gender = 'something non existant'
    when:
    perfectUser.save(failOnError: true)
    then:
    ValidationException ex = thrown()
  }
}
