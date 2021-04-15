abstract class Element {
  def contents: Array[String]
  // 这里content并不需要加上abstract关键字，作为方法，它并没有被实现，即等号右端没有东西；
  //声明和定义，这里element这个类声明了content这个抽象方法，但是没有定义具体的方法
  def height: Int = contents.length
  def width: Int = if (height==0) 0 else contents(0).length
  def above(that: Element): Element =
    new ArrayElement(this.contents ++ that.contents) // 将两个数组拼接在一起
//  def beside(that: Element): Element = {
//    val contents = new Array[String](this.contents.length)
//    for (i <- 0 until this.contents.length)
//      contents(i) = this.contents + that.contents(i)
//  利用zip 进行拼接
  def beside(that: Element): Element = {
    new ArrayElement(
      for (
        (line1, line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )
  }

  override def toString: String = contents.mkString("\n")
}

class ArrayElement(conts: Array[String]) extends Element {
  override def contents: Array[String] = conts
}

//val a: Element = new ArrayElement(Array[String]("Hello", "world"))
val a: Element
val a.contents = Array[String]("Hello", "world")
// val b: Element = new ArrayElement(Array[String]("My", "bad", "boy"))
a
