abstract class Element {
  def contents: Array[String]
  // 这里content并不需要加上abstract关键字，作为方法，它并没有被实现，即等号右端没有东西；
  //声明和定义，这里element这个类声明了content这个抽象方法，但是没有定义具体的方法
  def height: Int = contents.length
  def width: Int = if (height==0) 0 else contents(0).length
}

abstract class Element {
  def contents: Array[String]
  // 这里content并不需要加上abstract关键字，作为方法，它并没有被实现，即等号右端没有东西；
  //声明和定义，这里element这个类声明了content这个抽象方法，但是没有定义具体的方法
  val height = contents.length
  val width = if (height==0) 0 else contents(0).length
}
// 两种方法的区别在于：字段访问可能比方法调用略快，因为字段值val在类初始化时就被预先计算好，而不是在每次方法调用时重新计算
// 同时，val需要每个Element对象为其分配额外的内存空间；选择哪种方法取决于类的用法，而用法师可以随着时间变化的。
// 鼓励没有副作用的参数定义为无参算法，省去（）的方法

/*扩展类：*/

// val d = new Element
// 现在会报错，因为“Class 'Element' is abstract; cannot be instantiated”，无法实例化，需要创建一个创建一个扩展自Element的子类，并实现contents这一方法
class ArrayElement(conts: Array[String]) extends Element {
  def contents: Array[String] = conts
}
// extend的作用：继承（inherit）所有非私有的Element的成员， ArrayElement成为Element的子类型（subType）
// 如果没有extend，默认为scala.AnyRef的子类，与java中扩展自java.lang.object类似

// inherit： 继承超类的所有成员，除了超类的私有成员，和子类会override的
val e: Element = new ArrayElement(Array["Hello", "World"])
// Element格式的e也可以由ArrayElement来定义
// 组合： ArrayElement和Array[String]之间存在的组合关系（composition）


//重写方法和字段：
/*Java的四个命名空间分别是：字段、方法、类例和包
* 而Scala的两个命名空间分别是: 值（字段、方法、包和单例对象）和类型（类和特质名）*/

//定义参数化字段

/*
* 谨慎使用继承，因为脆弱基类的原因，会在修改超类的错误更改了子类的代码
* 继承应当满足 is-a的关系，比如ArrayElement is a element.*/