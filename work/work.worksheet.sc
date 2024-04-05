
// Exercise - Cats
// :paste ch3.4.5.1.sc
case class Cat (name: String = "Pussy", colour: String = "Black", food: String = "Tuna") {
  def meow = "Meow"
  def data = name + " | " + colour + " | " + food
}

val ozy = new Cat(name = "Oswald", food = "Milk")
val heny = new Cat(name = "Henderson", food = "Chips", colour = "Ginger")
val tin = new Cat(name = "Quentin", food = "Curry", colour = "Tabby and white")

ozy.data
heny.data
tin.data


case class Director (
  firstName: String, 
  lastName: String, 
  yearOfBirth: Int) {
  def name: String  = s"$firstName $lastName"
}

object Director {
  def older( a: Director, b: Director ): Director = {
    if (a.yearOfBirth < b.yearOfBirth) a else b
  }
}

case class Film (
  name: String, 
  yearOfRelease: Int, 
  imdbRating: Double,
  director: Director) {
  def directorsAge :Int = yearOfRelease - director.yearOfBirth
  def isDirectedBy(dir: Director): Boolean = {
    if (dir == director) true else false
  }
}

object Film { 
  def highestRating( a: Film, b: Film): Double = 
    if (a.imdbRating > b.imdbRating) a.imdbRating else b.imdbRating

  def oldestDirectorAtTheTime( a: Film, b: Film): Director = 
    if (a.directorsAge > b.directorsAge) a.director else b.director
}
    

val eastwood = Director(firstName = "Clint", lastName = "Eastwood", 1930)
val mcTiernan = Director("John", "McTiernan", 1951)
val nolan = Director("Christopher", "Nolan", 1970)
val someBody = Director("Just", "Some Body", 1990)

val memento = Film("Memento", 2000, 8.5, nolan)
val darkKnight = Film("Dark Knight", 2008, 9.0, nolan)
val inception = Film("Inception", 2010, 8.8, nolan)
val highPlainsDrifter = Film("High Plains Drifter", 1973, 7.7, eastwood)
val outlawJoseyWales = Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
val unforgiven = Film("Unforgiven", 1992, 8.3, eastwood)
val granTorino = Film("Gran Torino", 2008, 8.2, eastwood)
val invictus = Film("Invictus", 2009, 7.4, eastwood)
val predator = Film("Predator", 1987, 7.9, mcTiernan)
val dieHard = Film("Die Hard", 1988, 8.3, mcTiernan)
val huntForRedOctober = Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
val thomasCrownAffair = Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)


Director.older(eastwood, nolan).name

println("> Film.highestRating(darkKnight, outlawJoseyWales)")
Film.highestRating(darkKnight, outlawJoseyWales)

println("> Film.oldestDirectorAtTheTime(dieHard, darkKnight).name")
Film.oldestDirectorAtTheTime(dieHard, darkKnight).name
