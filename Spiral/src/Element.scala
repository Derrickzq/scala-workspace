//import java.lang.reflect.Array

object Element {
  // define the ArrayElement, LineElement, and UniformElement
  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)

  def elem(line: String): Element =
    new lineElement(line)

  def elem(ch: Char, width: Int, height: Int): Element =
    new UniformElement(ch, width, height)
}

import Element.elem

abstract class Element {

  def contents: Array[String]

  def width: Int =
    if (height == 0) 0 else contents(0).length

  def height: Int = contents.length

  //  def above(that: Element): Element =
  //    elem(this.contents ++ that.contents)
  //
  //  def beside(that: Element): Element =
  //    elem(
  //      for (
  //        (line1, line2) <- this.contents zip that.contents
  //      ) yield line1 + line2
  //    )
  def above(that: Element): Element =
    elem(this.contents ++ that.contents)

  def beside(that: Element): Element =
    elem(
      for (
        (line1, line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )

  override def toString = contents mkString "\n"
}

class ArrayElement(cont: Array[String]) extends Element {
  val contents = cont
}

class lineElement(s: String) extends Element {
  override val contents: Array[String] = Array(s)

  override def width: Int = s.length

  override def height: Int = 1
}

class UniformElement(ch: Char,
                     override val width: Int,
                     override val height: Int) extends Element {
  private def line = ch.toString * width

  override def contents = Array.fill(height)(line)
}