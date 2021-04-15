var assertionsEnabled = true
def byNameAssert(predicate: => Boolean) =
  if (assertionsEnabled && !predicate)
    throw new AssertionError

def boolAssert(predicate: Boolean) =
  if (assertionsEnabled && !predicate)
    throw new AssertionError

def myAssert(predicate: () => Boolean) =
  if (assertionsEnabled && !predicate())
    throw new AssertionError

myAssert(()=> 5>3)
byNameAssert(5>3)
// byNameAssert(()=> 5>3) 是不应该这样写的，因为传名 类型而言，空的参数列表，即（），是去掉的，这样的类型只能用于参数声明，并不存在传名变量或者传名字段
boolAssert(5>3)

