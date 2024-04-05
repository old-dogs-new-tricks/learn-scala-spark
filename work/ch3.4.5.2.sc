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
    

