import java.io.File
import javax.management.Query

object FileMatcher {
  private def fileHere = (new File(".")).listFiles

  //file ends with some regex
  def filesEnding(query: String) =
    for (file <- fileHere if file.getName.endsWith(query))
      yield file

  //file contains some regex
  def filesContains(query: String) =
    for (file <- fileHere if file.getName.contains(query))
      yield file

  def filesMatch(query: String) =
    for (file <- fileHere if file.getName.matches(query))
      yield file
  //上面的三个方法非常的相似，scala有什么方法可以将他们合起来呢：比如多一个参数为method
  //合并的方法
  def fileMatching(query: String,
      matcher: (String, String) => Boolean) = {
    for (file <-fileHere; if matcher(file.getName, query))
      yield file
  }

}
