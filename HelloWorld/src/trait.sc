trait Philosophical {
  def philosophize() = {
    println("BALALALSLSL")
  }
}
//trait不能像类一样传入参数

//另一个类和特质的区别在于：类当中的super是静态绑定的
class Frog extends Philosophical {
  override def toString: String = "green"
}

//瘦接口和富接口：Scala实现富接口的代价更小
//以矩阵对象为例：
class Point(val x: Int, val y: Int)
trait Rectangle {
  val topLeft: Point
  val bottonRight: Point
  def left = topLeft.x
  def right = bottonRight.x
  def width = right - left
}
abstract class Component extends Rectangle {
  //other methods
}

//ordered特质
