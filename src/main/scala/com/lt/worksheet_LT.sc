import java.rmi.activation.ActivationGroup_Stub

object worksheet_LT {
  /*
  * 高阶函数
  * 1、形参为函数
  * 2、返回值为函数
  *
  * 匿名函数
  * （形参列表）=> {函数体}
  *
  * */
  def greet() = (name:String) => {"hello" + name}
  greet(){"123"}
  def operate(f:(Int,Int) => Int) = {
    f(4,4)
  }
  def tr(x:Int,y:Int) = x + y
  operate(tr)


  /*
  * 柯里化函数
  * def curriedAdd(a:Int)(b:Int) = a + b
  * def addOne = curriedAdd(1)_
  * 表示curriedAdd的第一个参数为1，下划线_表示第二个参数为调用函数时的输入参数
  * addOne(2)
  * */
  def curriedAdd(a:Int)(b:Int) = a + b
  curriedAdd(2)(2)
  def addOne = curriedAdd(1)_
  addOne(2)

  /*
  * 递归函数
  *
  * */
  def factorial(n : Int) : Int =
    if (n <= 0 ) 1
    else n * factorial(n-1)

  /*
  * 尾递归函数
  * @annotation.tailrec标签表示尾递归
  * 尾递归是为了防止堆栈溢出
  * 递归不会新建堆栈，而是复用之前的堆栈
  *
  * */
  @annotation.tailrec
  def factorial(n:Int,m:Int):Int =
    if (n <= 0 ) m
    else factorial(n-1,m*n)


  def test1(x:Int,y:Int) : Int = x * x
  def test2(x: => Int,y: => Int): Int = x * x
  /*
  * CallByValue,参数传入时，先计算参数表达式
  * CallByName，参数传入时，不计算表达式，直到参数被调用时再计算
  *
  * test1是先计算3+4 => test1(7,8) => 7*7 => 49 CallByValue
  * test2是先不计算输入输入参数 => (3+4) * (3+4) => 49 CallByName
  * */
  test1(3+4,8)
  test2(3+4,8)
  def bar(x: Int,y: => Int):Int = 1
  def loop() : Int = loop

  bar(1,loop)




  /*val l = List("lt1","LTttttt2","LT3")

  for (
    s <- l
  ) println(s)

  for {
    s <- l
    if (s.length > 3)
  } println(s)

  val result_for = for {
   s <- l
    s1 = s.toUpperCase()
    if(s1 != "")
  } yield (s1)*/

  val result_try = try {
    Integer.parseInt("dog")
  }catch {
    case _ => 0
  } finally {
    println("always be printed")
  }

  val code = 3
  val  result_match = code match {
    case 1 => "one"
    case 2 => "two"
    case _ => "others"
  }

  object sumfunc {
    def sum(f:Int => Int)(a:Int)(b:Int):Int = {
      @annotation.tailrec
      def loop(n:Int,acc:Int):Int = {
        if(n > b) {
          println(s"n=${n},acc=${acc}")
          acc
        }else {
          println(s"n=${n},acc=${acc}")
          loop(n + 1,acc+f(n))
        }
      }
      loop(a,0)
    }
    sum(x => x)(1)(5)
  }

}