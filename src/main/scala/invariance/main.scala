package invariance

// https://docs.scala-lang.org/tour/variances.html

class Container[+A](val value: A)

abstract class Animal {
  def name: String
}
case class Cat(name: String) extends Animal

object Main extends App {
  val content1 = Cat("Felix")
  val container1 = new Container(content1)
  val container2: Container[Animal] = container1

  println(container2.value.name)
}

// class Container[+A](value: A) {
//   private var _value: A = value
//   def getValue: A = _value
//   def setValue(value: A): Unit = {
//     _value = value
//   }
// }
//
// abstract class Animal {
//   def name: String
// }
// case class Cat(name: String) extends Animal
// case class Dog(name: String) extends Animal
//
// abstract class SmallAnimal extends Animal
// case class Mouse(name: String) extends SmallAnimal
//
//
// object Main extends App {
//   val catContainer: Container[Cat] = new Container(Cat("Felix"))
//   val animalContainer: Container[Animal] = catContainer
//   animalContainer.setValue(Dog("Spot"))
//   val cat: Cat = catContainer.getValue
//
//   println(cat.name)
// }
