/*
* String： java.lang
* 数值类型 & 整数类型： scala
* 字面量：0x或者0X开头表示16进制，Double后面会加D，Float后面会加F或者f
* 字符字面量（character literal）可以表达为'\u0041'是字符串'A'等等
* 符号字面量（symbol literal）：以'ident表示，ident是由任何字母和数字组成的标识符，字面量会被map成scala.Symbol
* */

def updateRecordByName(r: Symbol, value: Any) = {
  //指标建立--初始化标准数据缺失
}
val name = "reader"
println(s"Hello, $name!")//是一个被处理的字符串字面量， s插值器会对内嵌的每个表达式求值，对求值结果调用toString，并替换字面量中的表达式；
println(s"NO\\\\ESCAPE!")
println(raw"NO\\\\\ESCAPE!") // raw和f插值器差不错，但是不识别字符转义序列
f"${math.Pi}%.10f"

//操作符即方法： 1+1 实际上就是1.+(2); 输出是一致的，下面将以indexOf为例：
val s = "Hello World!"
s.indexOf("o", 5) //"o": string you want to find; 5: the index from which you start your search;
s indexOf ("o", 5)
//刚才的indexOf是中缀操作符，下面介绍前缀操作符和后缀操作符
val s = 2.0
- s //前缀
s.unary_- //后缀

//算术操作 pass

//关系和逻辑操作 pass

//操作符优先级和结合性