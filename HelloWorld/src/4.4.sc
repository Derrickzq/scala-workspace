import ChecksumAccumlator.calculate
object summer {
  def main (args: Array[String]) = {
    for (arg <- args)
      print(arg + ": " + calculate(arg))
  }
  /*scala实际都隐式地引入了关于java.lang和scala的包的成员
  * scala和java的区别在于java要求公共的类放入和类同名的文件中； 例如需要将class SpeedRacer放到SpeedRacer.java文件中
  * scala是几乎不要求的，*/
}
/*
* 那么，这两种启动项目的方式有什么不同呢？

App是scala语言内置的一个特质，使用它，则把对应object内部的整体作为scala main的一部分，有延迟启动的特性。同时，命令行参数args也作为App特质的一部分，可以被开发者直接使用。而main函数则是scala的默认启动方式。*/

object FailWinterSpringSummer extends App {
  for (season <- List("fall", "winter", "spring"))
    println(season + ": " + calculate(season))
}

