package chapter6

class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator can't be 0(zero)")

  private val g: Int = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1)

  def this() = this(1, 1)

  def add(that: Rational): Rational =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def +(that: Rational): Rational = add(that)

  def +(that: Int): Rational = add(new Rational(that, 1))

  def substract(that: Rational): Rational =
    new Rational(numer * that.denom - that.numer * denom, denom * that.denom)

  def -(that: Rational): Rational = substract(that)

  def -(that: Int): Rational = substract(new Rational(that, 1))

  def lessThan(that: Rational): Boolean =
    this.numer * that.denom < that.numer * this.denom

  def <(that: Rational): Boolean = lessThan(that)

  def <(that: Int): Boolean = lessThan(new Rational(that, 1))

  def greaterThan(that: Rational): Boolean =
    !lessThan(that)

  def >(that: Rational): Boolean = greaterThan(that)

  def >(that: Int): Boolean = greaterThan(new Rational(that, 1))

  def max(that: Rational): Rational =
    if (this.lessThan(that)) that else this

  def max(that: Int): Rational = max(new Rational(that, 1))

  def multiply(that: Rational): Rational =
    new Rational(this.numer * that.numer, this.denom * this.denom)

  def *(that: Rational): Rational = multiply(that)

  def *(that: Int): Rational = multiply(new Rational(that, 1))

  def divide(that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)

  def /(that: Rational): Rational = divide(that)

  def /(that: Int): Rational = divide(new Rational(that, 1))

  override def toString: String = numer + "/" + denom

  @scala.annotation.tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}