val n: Int = ???
val half =
  if (n % 2 == 0 )
    n / 2
  else
    throw new RuntimeException("n must be even")

//try and catch语句：
import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

/*在下面的case中，如果抛出异常1，则运行第一个=>后面的语句，否则第二个*/
try{
  val f = new FileReader("input.txt")
}catch {
  case ex: FileNotFoundException => println("找不到文件的情况说明")
  case ex: IOException => println("处理其他I/O错误")
}

//finally语句：保证无论是否抛出异常，final语句中的代码都一定会被执行；
val file = new FileReader("input.txt")
try {
  //调用语句实现处理文件
} finally {
  file.close() //确保关闭文件
}
// 贷出模式（loan pattern）会在9.4节中更多的表述

//考虑以下两行代码：
def f():Int = try return 1 finally return 2 // 有强行的return语句，返回2
def g():Int = try 1 finally 2 //无强行的return语句，返回1，只返回try模块下的显式运算值

//match语句：
val args = "sssssssssssssss"
val firstArg = if (args.length > 0) args(0) else ""
firstArg match {
  case "salt" => println("?")
  case "chips" => println("??")
  case _ => println("hah")
}
//每一次的match都会返回值，这是与java所不同的；


/*scala中没有break and continue*/

//变量作用域：
