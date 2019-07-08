package example

object Hello extends App {
  val message: String = System.getProperty("hello.message", "Hello")
  System.out.println(message)
}