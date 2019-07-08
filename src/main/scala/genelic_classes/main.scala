package genelic_classes

// https://docs.scala-lang.org/tour/generic-classes.html

class Stack[A] {
  private var elements: List[A] = Nil

  def push (x: A) {
    elements = x :: elements
  }

  def peek: A = elements.head

  def pop(): A = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }
}

object Main extends App {
  val stack = new Stack[Int]
  stack.push(1)
  stack.push(2)
  System.out.println(stack.pop)
  System.out.println(stack.pop)
}
