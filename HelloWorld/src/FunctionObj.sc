//n 和 d称作类参数（class parameter）， scala会构建一个主构造方法
//可变类和不可变类 chap18
// override
// 检查前置条件 precondition---required
class Rational(n: Int, d: Int) {
  require(d !=0) //不对，会抛出IllegalArgumentException
  val denom = d;
  val numer = n;
  def this(n: Int) = this(n, 1) //辅助构造方法
  override def toString: String = s"$n/$d"
  /*def + (that: Rational): Rational = new Rational(this.n * that.d + this.d * that.n, this.d * that.d)
  * 上述的方法，不重新定义类参数n 和 d是不行的，that并非指向add调用的那个对象，*/
  def + (that: Rational): Rational = {
    val a = numer * that.denom + denom * that.numer;
    val b = denom * that.denom
    val g = gcd(a, b)
    new Rational(a / g, b / g)
  }
  // 这里的this都可以取消不用
  def lessThan (that: Rational): Boolean = numer * that.denom < that.numer * denom
  // this.lessThan(that)的this可以省略，后面一个必须有返回值，不能省略
  def max (that: Rational): Rational = if(lessThan(that)) that else this
  private def gcd(a: Int, b: Int): Int = if(b==0) a else gcd(b, a % b)
}
//可变类和不可变类 chap18
val x = new Rational(1, 2)
val y = new Rational(5, 4)
// val z = new Rational(3, 0)
x + y

//自引用：部分的this是可以省略的，有的不行
x lessThan y
x max y
val q = new Rational(3)


//除了类和特质（使用大驼峰），其余都是用小驼峰法
//方法重载：比如这里的’+‘ 就对于Int和Rational都是适用的，所以存在重载的问题
val x: Int = 1;
implicit def int2Rational(x: Int) = new Rational(x) // implicit conversion
val k = x + new Rational(2,3)
