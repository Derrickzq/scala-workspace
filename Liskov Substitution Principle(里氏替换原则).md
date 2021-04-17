# Liskov Substitution Principle(里氏替换原则)

In mathematics, a `Square` is a `Rectangle`. Indeed it is a specialization of a rectangle. The "is a" makes you want to model this with inheritance. However if in code you made `Square` derive from `Rectangle`, then a `Square` should be usable anywhere you expect a `Rectangle`. This makes for some strange behavior.

Imagine you had `SetWidth` and `SetHeight` methods on your `Rectangle` base class; this seems perfectly logical. However if your `Rectangle` reference pointed to a `Square`, then `SetWidth` and `SetHeight` doesn't make sense because setting one would change the other to match it. In this case `Square` fails the Liskov Substitution Test with `Rectangle` and the abstraction of having `Square` inherit from `Rectangle` is a bad one.

```scala
type A = IntSet => NonEmpty
type B = NonEmpty => IntSet

```

* According to the Liskov Substitution Principle:

**如何规范地遵从里氏替换原则：**

**1 子类必须完全实现父类的抽象方法，但不能覆盖父类的非抽象方法**

**2 子类可以实现自己特有的方法**

**3 当子类覆盖或实现父类的方法时，方法的前置条件（即方法的形参）要比父类方法的输入参数更宽松。**

**4 当子类的方法实现父类的抽象方法时，方法的后置条件（即方法的返回值）要比父类更严格。**

**5 子类的实例可以替代任何父类的实例，但反之不成立**