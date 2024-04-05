class Timestamp(val seconds: Long)

object Timestamp {
  def apply(hours: Int, minutes: Int, seconds: Int): Timestamp =
    new Timestamp(hours*60*60 + minutes*60 + seconds)
}

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

