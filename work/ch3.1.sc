
class Person(val firstName: String, val lastName: String) {

  def name = firstName + " " + lastName
  def sortName = lastName + ", " + firstName

}

object alien {
  def greet(p: Person) = 
    "Greetings, " + p.name
}

class Cat (val name: String = "Pussy", val colour: String = "Black", val food: String = "Tuna") {
  def meow = "Meow"

  def data = name + " | " + colour + " | " + food
}

val ozy = new Cat(name = "Oswald", food = "Milk")
ozy.data

val heny = new Cat(name = "Henderson", food = "Chips", colour = "Ginger")
heny.data

val tin = new Cat(name = "Quentin", food = "Curry", colour = "Tabby and white")
tin.data

class ChipShop {
  def willServe( cust: Cat ): String = {
    println("Hello, " + cust.name)
    if (cust.food == "Chips") "Welcome" else "Scram"
  }
}

val shop = new ChipShop

shop willServe ozy
shop willServe heny
shop willServe tin

class Director (val firstName: String, val lastName: String, val yearOfBirth: Int) {
  def name: String  = s"$firstName $lastName"

  def copy(
    firstName: String = this.firstName,
    lastName: String = this.lastName,
    yearOfBirth: Int = this.yearOfBirth
  ): Director =
    new Director(firstName, lastName, yearOfBirth)
}

class Film (val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director) {
  def directorsAge :Int = yearOfRelease - director.yearOfBirth
  def isDirectedBy(dir: Director): Boolean = {
    if (dir == director) true else false
  }

  def copy(
    name: String = this.name,
    yearOfRelease: Int = this.yearOfRelease,
    imdbRating: Double = this.imdbRating
  ): Film = 
    new Film(name, yearOfRelease, imdbRating, director)
}

val eastwood = new Director("Clint", "Eastwood", 1930)
val mcTiernan = new Director("John", "McTiernan", 1951)
val nolan = new Director("Christopher", "Nolan", 1970)
val someBody = new Director("Just", "Some Body", 1990)

val memento = new Film("Memento", 2000, 8.5, nolan)
val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
val inception = new Film("Inception", 2010, 8.8, nolan)
val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
val invictus = new Film("Invictus", 2009, 7.4, eastwood)
val predator = new Film("Predator", 1987, 7.9, mcTiernan)
val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

class Adder(amount: Int) {
  def add(in: Int): Int = in + amount
}

class Counter (val n: Int = 0) {
  def count = n
  
  def inc: Counter = inc()
  def inc(i: Int = 1): Counter = new Counter(n+i)

  def dec: Counter = dec()
  def dec(d: Int = 1): Counter = new Counter(n-d)

  def adjust(add: Adder): Counter = {
    new Counter(add.add(this.n))
  }
}

new Counter(10).inc.dec.inc.inc.count

new Counter(10).inc.inc(10).count


