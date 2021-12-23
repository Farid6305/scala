/* This task has no tests. It is an exercise for you to write different class structures.
 * 
 * a) Создать класс Animal, который имеет следующие поля:
 *      - name: String (название)
 *      - species: String (вид)
 *      - food: String
 * 
 *    Синтаксис: class MyClass(val publicField: Int, privateField: String) {
 *              // остальные поля и методы
 *            }
 * 
 * b) Создайте объект-компаньон для класса Animal и добавьте следующие сущности как поля:
 *      - cat, mammal, meat
 *      - parrot, bird, vegetables
 *      - goldfish, fish, plants
 * 
 *    Синтаксис: object MyClass {
 *              // статические поля и методы
 *            }
 * 
 * c) Добавьте следующие методы в Animals:
 *      def eats(food: String): Boolean
 *    
 *     который проверяет ест ли животное определенную пищу
 */
object Classes {
  class Animals(name: String, species: String, food: String) {
    def eats(food: String): Boolean = this.food == food
  }

  object Animals {
    val cat = new Animals("cat", "mammal", "meat")
    val parrot = new Animals("parrot", "bird", "vegetables")
    val goldfish = new Animals("goldfish", "fish", "plants")

    def knownAnimal(name: String): Boolean = name match {
      case "cat" => true
      case "parrot" => true
      case "goldfish" => true
      case _ => false
    }

    def apply(name: String): Option[Animal] = name match {
      case "cat" => Some(Mammals(name, Meat()))
      case "parrot" => Some(Birds(name, Vegetables()))
      case "goldfish" => Some(Fishes(name, Plants()))
      case _ => None()
    }
  }

  /*
 * d) Переопределите ваш класс Animal как трейт и создайте объекты класса-образца для Mammals, Birds и Fishs.
 *    Вам все еще нужно поле `species`?
 */

  trait Animal {
    val name: String
    val food: Food

    def eats(food: Food): Boolean = this.food == food
  }

  case class Mammals(name: String, food: Food) extends Animal
  case class Birds(name: String, food: Food) extends Animal
  case class Fishes(name: String, food: Food) extends Animal

  /* e) Добавьте следующие функции в объект-компаньон Animal:
 *      def knownAnimal(name: String): Boolean  // true если это имя одного из трех животных из (b)
 *      def apply(name: String): Option[Animal] // возвращает одно из трех животных в соответствии с именем (Some) или ничего (None), см. ниже
 * 
 * f) Создайте трейт Food со следующими классами-образцами:
 *      - Meat
 *      - Vegetables
 *      - Plants
 *   и добавьте это в определение Animal. Так же добавьте объект-компаньон с методом apply():
 *      def apply(food: String): Option[Food]
 */

  trait Food

  case class Meat() extends Food
  case class Vegetables() extends Food
  case class Plants() extends Food

  object Food {
    def apply(food: String): Option[Food] = {
      food match {
        case "meat" => Some(Meat())
        case "vegetables" => Some(Vegetables())
        case "plants" => Some(Plants())
        case _ => None()
      }
    }
  }

  sealed trait Option[A] {
    def isEmpty: Boolean
  }
  case class Some[A](a: A) extends Option[A] {
    val isEmpty = false
  }
  case class None[A]() extends Option[A] {
    val isEmpty = true
  }

  def main(args: Array[String]): Unit = {
    println("Ест ли кот мясо? " + Animals.cat.eats("meat"))
    println("Ест ли кот овощи? " + Animals.cat.eats("vegetables"))
    println("Есть ли у нас попугай? " + Animals.knownAnimal("parrot"))
    println("Есть ли у нас кролик? " + Animals.knownAnimal("rabbit"))
    println("Используем apply: " + Animals.apply("goldfish").isEmpty)
    println("Используем apply: " + Animals.apply("dog").isEmpty)
    println("Используем apply: " + Food.apply("plants").isEmpty)
    println("Используем apply: " + Food.apply("fruits").isEmpty)
  }
}