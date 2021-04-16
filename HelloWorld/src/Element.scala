import Element.elem

object Element {

  def elem(content: Array[String]): Element = new ArrayElement(content)

  def elem(ch: Char, width: Int, height: Int) = new UniformElement(ch, width, height)

  def elem(line: String) = new LineElement(line)

  abstract class Element{
    def contents: Array[String]

    // 这里content并不需要加上abstract关键字，作为方法，它并没有被实现，即等号右端没有东西；
    //声明和定义，这里element这个类声明了content这个抽象方法，但是没有定义具体的方法
    def height: Int = contents.length

    def width: Int = if (height == 0) 0 else contents(0).length

    def above(that: Element): Element = {
      val this1 = this widen that.width
      val this2 = that widen this.width
      elem(this1.contents ++ this2.contents)
    }

    def beside(that: Element): Element = {
      val this1 = this heighten that.height
      val this2 = that heighten this.height
      elem(
        for (
          (line1, line2) <- this1.contents zip this2.contents
        ) yield line1 + line2
      )
    }

    def widen(w: Int): Element =
      if (w <= width) this
      else {
        val left = elem(' ', (w - width) / 2, height)
        val right = elem(' ', w - width - left.width, height)
        left beside this beside right
      }

    def heighten(h: Int): Element =
      if (h <= height) this
      else {
        val top = elem(' ', width, (h - height) / 2)
        val below = elem(' ', width, h - height - top.height)
        top above this above below
      }

    override def toString: String = contents mkString "\n"
  }
  private class ArrayElement(const: Array[String]) extends Element {
    override def contents: Array[String] = const
  }

  private class LineElement(s: String) extends ArrayElement(Array(s)) {
    override def width: Int = s.length

    override def height: Int = 1
  }

  private class UniformElement(ch: Char,
                               override val width: Int,
                               override val height: Int) extends Element {
    private val line = ch.toString * width

    override def contents: Array[String] = Array.fill(height)(line)
  }
}
