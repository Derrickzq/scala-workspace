// 继承结构图见209，最上层是Any,
// bottom types(Null and Nothing)
/*Nothing is a subtype of Int;
* Null, comparatively is not subtype of any values.*/


def divide(x: Int, y: Int): Int =
  if (y!=0) x / y
  else sys.error("can not divide by zero!")