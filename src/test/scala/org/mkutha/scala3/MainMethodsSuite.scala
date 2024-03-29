package org.mkuthan.scala3

import java.io.ByteArrayOutputStream

class MainMethodsSuite extends munit.FunSuite {

  test("Happy New Year") {
    val out = new ByteArrayOutputStream()
    Console.withOut(out) {
      happyNewYear()
    }
    assertNoDiff(out.toString(), "Happy New Year")
  }

  def checkHappyBirthday(message: String, age: Int, name: String)(implicit loc: munit.Location): Unit =
    test(message) {
      val out = new ByteArrayOutputStream()
      Console.withOut(out) {
        happyBirthday(age, name)
      }
      assertNoDiff(out.toString(), message)
    }

  checkHappyBirthday("Happy 1st birthday, Adam", 1, "Adam")
  checkHappyBirthday("Happy 2nd birthday, John", 2, "John")
  checkHappyBirthday("Happy 11th birthday, Jack", 11, "Jack")
  checkHappyBirthday("Happy 45th birthday, Martin", 45, "Martin")

  test("Happy 3rd birthday, Kate and Ann and Bob") {
    val out = new ByteArrayOutputStream()
    Console.withOut(out) {
      happyBirthday(3, "Kate", "Ann", "Bob")
    }
    assertNoDiff(out.toString(), "Happy 3rd birthday, Kate and Ann and Bob")
  }
}
