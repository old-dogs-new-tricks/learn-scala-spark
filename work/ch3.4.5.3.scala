
class Adder(amount: Int) {
  def add(in: Int): Int = in + amount
}

case class Counter (n: Int = 0) {
  def count = n

/* obviated by "case class"
  def inc: Counter = inc()
  def dec: Counter = dec()
*/

  def inc = copy(n = n+1)
  def inc(i: Int = 1): Counter = new Counter(n+i)

  def dec = copy(n = n-1)
  def dec(d: Int = 1): Counter = new Counter(n-d)

  def adjust(add: Adder): Counter = {
    new Counter(add.add(this.n))
  }
}



