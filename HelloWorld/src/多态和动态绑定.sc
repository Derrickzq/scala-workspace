// 多态和动态绑定
abstract class Element {
  def demo = {
    println("Element's implementation invoked!")
  }
}

class ArrayElement extends Element {
  override def demo: Unit = {
    println("ArrayElement's implementation invoked!")
  }
}

class LineElement extends ArrayElement {
  override def demo: Unit = {
    println("LineElement's implementation invoked!")
  }
}

class UniformElement extends Element

def invokeDemo(e:Element) = {
  e.demo
}

invokeDemo(new ArrayElement)
invokeDemo(new LineElement)
invokeDemo(new UniformElement)