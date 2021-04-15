/*while 和 do while不建议适用，都最好使用函数式的表达方式*/
val a = List(1, 2, 3)
for (elem <- a) //每一次的迭代，一个新elem的val都会被初始化成一个元素的值
  println(elem)
/*
* range: 1 to 5或者 1 until 5<不包含上届5>
* */