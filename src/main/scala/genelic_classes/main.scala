package genelic_classes

// https://docs.scala-lang.org/tour/generic-classes.html

class Stack[A] {
  private var elements: List[A] = Nil

  def push (x: A) {
    elements = x :: elements
  }

  def peek: A = elements.head

  def pop: A = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }
}

// class Fruit {
//   def name: String = ""
// }
trait Fruit {
  def name: String
}
class Apple extends Fruit {
  def name: String = "apple"
  // override def name: String = "apple"
}
class Banana extends Fruit {
  def name: String = "banana"
  // override def name: String = "banana"
}

object Main extends App {
  val stack = new Stack[Int]
  stack.push(1)
  stack.push(2)
  System.out.println(stack.pop)
  System.out.println(stack.pop)

  val fruits = new Stack[Fruit]
  var apple = new Apple
  var banana = new Banana
  fruits.push(new Apple)
  fruits.push(new Banana)
  System.out.println(fruits.pop.name)
  System.out.println(fruits.pop.name)
}
