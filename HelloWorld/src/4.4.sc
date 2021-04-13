import ChecksumAccumlator.calculate
object summer {
  def main (args: Array[String]) = {
    for (arg <- args)
      print(arg + ": " + calculate(arg))
  }
}

