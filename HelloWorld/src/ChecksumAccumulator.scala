import scala.collection.mutable
/*如何使用scala中的static, scala 中使用singleton来表达*/
/**/
object ChecksumAccumlator {
  private val cache = mutable.Map.empty[String, Int] // create a empty mutable map
  def calculate(s: String):Int =
    if (cache.contains(s))
      cache(s)
    else{
      val acc = new ChecksumAccumlator //用一个新的ChecksumAccumulator实例初始化
      for (c <- s)
        acc.add(c.toByte)//将每一个字符转化成byte
      val cs = acc.checkSum()
      cache += (s -> cs) //传入字符为键，算出的校验和为值，被加入cache这一映射中
      cs //保证这一else语句的最后的输出值是cs
    }
}

class ChecksumAccumlator{
  private var sum = 0
  def add (b: Byte) = sum += b
  def checkSum() = ~(sum & 0xFF) +1
}
/*
* 定义单例对象并不会定义类型，名为ChecksumAccumlator的类型是由这个单例对象的半生类来定义的
* 但是单例对象可以扩展自某个超类，还可以混入trait，可以通过这些类型来调用它的方法。
* chapter 13 会介绍这方面的使用*/


