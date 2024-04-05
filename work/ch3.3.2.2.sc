class Director (val firstName: String, val lastName: String, val yearOfBirth: Int) {
  def name: String  = s"$firstName $lastName"

  def copy(
    firstName: String = this.firstName,
    lastName: String = this.lastName,
    yearOfBirth: Int = this.yearOfBirth
  ): Director =
    new Director(firstName, lastName, yearOfBirth)
}

object Director {
  def apply(firstName: String, lastName: String, yearOfBirth: Int): Director = 
    new Director(yearOfBirth = yearOfBirth, lastName = lastName, firstName = firstName)

  def older( a: Director, b: Director ): Director = {
    if (a.yearOfBirth < b.yearOfBirth) a else b
  }
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


object Film { 
  def apply (name: String, yearOfRelease: Int, imdbRating: Double, director: Director): Film = 
    new Film(name=name, yearOfRelease=yearOfRelease, imdbRating=imdbRating, director=director)

  def highestRating( a: Film, b: Film): Double = 
    if (a.imdbRating > b.imdbRating) a.imdbRating else b.imdbRating

  def oldestDirectorAtTheTime( a: Film, b: Film): Director = 
    if (a.directorsAge > b.directorsAge) a.director else b.director
}
    

