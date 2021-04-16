import Element.elem

abstract class Element {
  def contents: Array[String]

  // 这里content并不需要加上abstract关键字，作为方法，它并没有被实现，即等号右端没有东西；
  //声明和定义，这里element这个类声明了content这个抽象方法，但是没有定义具体的方法
  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

  def above(that: Element): Element = {
    val this1 =
  }

  def beside(that: Element): Element = {
    new ArrayElement(
      for (
        (line1, line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )
  }
  override def toString: String = contents.mkString("\n")
}


class ArrayElement(const: Array[String]) extends Element {
  override def contents: Array[String] = const
}

class LineElement(s:String) extends ArrayElement(Array(s)) {
  override def width: Int = s.length
  override def height: Int = 1
}
class UniformElement(ch:Char,
                     override val width: Int,
                     override val height: Int) extends Element {
  private val line = ch.toString * width

  override def contents: Array[String] = Array.fill(height)(line)
}