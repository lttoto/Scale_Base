object func_examples {
  def hello(name:String):String = {
    s"Hello,${name}"
  }
  hello("LT")

  def hello2(name:String) = {
    s"Hello,${name}"
  }
  hello2("LT")

  def add(x:Int,y:Int) = x + y

  add(1,2)
}