import scala.sys.process.processInternal.File

/*对于所有的for语句来说，for语句的返回结果始终会是单元值()*/
//过滤方法：可以不用完整地过滤集合，而可以把它过滤成子集
val a = List(1, 2, 3, 4, 5)
for (i <- a if i >3)
  println(i)

//也可以添加多种筛选
for (i <- a
     if i > 3
     if i < 5)
  println(i)

//嵌套迭代
val filesHere = ""

def fileLine(file: java.io.File) =
  scala.io.Source.fromFile(file).getLines().toArray
def grep(pattern: String) =
  for (
    file <- filesHere
    if file.getName.endsWith(".scala");
    line <- fileLine(file)
    if line.trim.matches(pattern)
  )println(s"$file:${line.trim}")//这里line.trim运行了两次

grep(".*gcd.*")

//改进方法：中途赋值，变量绑定
def grep2(pattern: String) =
  for {
    file <- filesHere
    if file.getName.endsWith(".scala")
    line <- fileLine(file)
    trimmed = line.trim
    if trimmed.matches(pattern)
  }println(s"$file:$trimmed")

grep2(".*gcd.*")
// 这里还需要注意，如果我们用小括号，那么需要注意分号，但是如果使用花括号，就不用
// for yield 语句使用：
def scalaFile =
  for (
    file <- filesHere
    if file.getName.endsWith(".scala")
  ) yield file

for (file <- filesHere if file.getName.endsWith(".scala")) {
  yield file
} //这种写法都是错误的