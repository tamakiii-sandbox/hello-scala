package variances

// https://docs.scala-lang.org/tour/variances.html

class Foo[+A] // A covariant class
class Bar[-A] // A contravariant class
class Baz[A]  // An invariant class

abstract class Animal {
    def name: String
}

case class Cat(name: String) extends Animal
case class Dog(name: String) extends Animal

object Main extends App {
    def printAnimalNames(animals: List[Animal]): Unit = {
        animals.foreach { animal =>
            println(animal.name)
        }
    }

    val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
    val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

    printAnimalNames(cats)
    printAnimalNames(dogs)
}

