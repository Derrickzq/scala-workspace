import scala.io.Source
object LongLines {
  def processFile (filename: String, width: Int) = {
    val source = Source.fromFile(filename)
    for (line <-source.getLines())
      processLine(filename, width, line)
  }
  private def processLine(filename: String, width: Int, line: String) = {
    if (line.length > width)
      println(filename + ":" + line.trim)
  }
}

//闭包：closure
def makeIncreaser(more: Int) = (x: Int) => x + more
val incl1 = makeIncreaser(1)
val incl99 = makeIncreaser(99)
//这里唯一的自由变量more捕捉到之后，就形成了一个闭包

// 重复参数使用*，带名字的参数，可以在定义名字之后，颠倒其入参的顺序；缺省参数值
// 尾递归： constant stack=> 应用自己才有优化，中间不能有任何的继承，例如 page163的例子