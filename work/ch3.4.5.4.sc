/*
 *  Before Case Class

class Person(val firstName: String, val lastName: String) {

  def name = firstName + " " + lastName
  def sortName = lastName + ", " + firstName
}

object Person {
  def apply(fullName: String): Person = {
    val parts = fullName.split(" ")
    new Person(firstName = parts(0), lastName = parts(1))
  }
}

*/

case class Person(firstName: String, lastName: String) {
  def name = firstName + " " + lastName
  def sortName = lastName + ", " + firstName
}

object Person {
  def apply(fullName: String): Person = {
    val parts = fullName.split(" ")
    new Person(firstName = parts(0), lastName = parts(1))
  }
}



