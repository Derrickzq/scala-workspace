//定义样例类
abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String,
                 left: Expr, right: Expr) extends Expr


val v = Var("x")
val op = BinOp("+", Number(1), v)
v.name
op.left

op

op.right == Var("x")

op.copy(operator = "-")
op


val e: Expr = Var("e")
UnOp("-",  UnOp("-", e))

// 假设我们想简化前面的运算，有什么方法呢？
def simplifyTop(expr: Expr): Expr = expr match {
  case UnOp("-",  UnOp("-", e)) => e
  case BinOp("+", e, Number(0)) => e
  case BinOp("*", e, Number(1)) => e
  case _ => expr
}
// match 表达式对应Java的switch， 只不过match的关键字出现在选择器的表达式后面

simplifyTop(UnOp("-",  UnOp("-", e)))

//变量模式：匹配任何对象，scala讲对应的变量绑定成匹配上的对象，在绑定后，就可以用这个变量来对于对象作进一步的处理；、
expr match {
  case 0 => "zero"
  case somethingElse => "not zero" + somethingElse
}
