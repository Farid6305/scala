/** Напишите решение в виде функции.
  * 
  * Синтаксис:
  *   val a: Int = ???
  * 
  *   a match {
  *     case 0 => true
  *     case _ => false
  *   }
  */
object PatternMatching {

  sealed trait Hand
  case object Rock    extends Hand
  case object Paper   extends Hand
  case object Scissor extends Hand

  sealed trait Result
  case object Win  extends Result
  case object Lose extends Result
  case object Draw extends Result

  sealed trait Food
  case object Meat       extends Food
  case object Vegetables extends Food
  case object Plants     extends Food

  sealed trait Animal {

    val name: String
    val food: Food
  }
  case class Mammal(name: String, food: Food, weight: Int) extends Animal
  case class Fish(name: String, food: Food)                extends Animal
  case class Bird(name: String, food: Food)                extends Animal



  /* a) Напишите функцию, которая ставит в соответствие числу строку слудеющим образом:
   * Если:
   *     1 => "it is one"
   *     2 => "it is two"
   *     3 => "it is three"
   *     иначе => "what's that"
   */
  def intToString(a: Int): String = {
    a match {
      case 1 => "it is one"
      case 2 => "it is two"
      case 3 => "it is three"
      case _ => "what's that"
    }
  }


  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testIntToString(value: Int): String = intToString(value)

  /* b) Напишите функцию которая возвращает true если переменная `value` принимает значение:
   *     "max" или "Max
   *     "moritz" или "Moritz"
   */
  def isMaxMoritz(value: String): Boolean = {
    value match {
      case "max" => true
      case "Max" => true
      case "moritz" => true
      case "Moritz" => true
      case _ => false
    }
  }


  // примените функции из пункта (b) здесь, не изменяя сигнатуру
  def testIsMaxAndMoritz(value: String): Boolean = isMaxMoritz(value)

  // c) Напишите функцию проверки является ли `value` четным
  def isEven(value: Int): Boolean = value % 2 == 0


  // примените функции из пункта (c) здесь, не изменяя сигнатуру
  def testIsEven(value: Int): Boolean = isEven(value)


  
  /* d) Напишите функцию, моделирующую игру в Камень ножницы бумага 
   *     1. камень побеждает ножницы
   *     2. ножницы побеждают бумагу
   *     3. бумага побеждает камень
   *    Выиграет ли игрок `a`?
   */
  def winsA(a: Hand, b: Hand): Result = {
    (a, b) match {
      case (Rock, Scissor) | (Paper, Rock) | (Scissor, Paper) => Win
      case (Scissor, Rock) | (Rock, Paper) | (Paper, Scissor) => Lose
      case (Scissor, Scissor) | (Rock, Rock) | (Paper, Paper) => Draw
    }
  }


  // примените вашу функцию из пункта (d) здесь, не изменяя сигнатуру
  def testWinsA(a: Hand, b: Hand): Result = winsA(a, b)



  // Примечание: используйте определение Animals

  // e) Верните вес (weight: Int) объекта Mammal, иначе верните -1.
  def mammalWeight(animal: Animal): Int = animal match {
    case a: Mammal => a.weight
    case _ => -1
  }



  // примените функцию из пункта (e) здесь, не изменяйте сигнатуру
  def testExtractMammalWeight(animal: Animal): Int = mammalWeight(animal)


  // f) Измените поле еда объектов классов Fishes и Birds на Plants, класс Mammels оставьте неизмененным.
  def updateFood(animal: Animal): Animal = animal match {
    case Fish(_,_) => Fish(animal.name, Plants)
    case Bird(_,_) => Bird(animal.name, Plants)
    case _ => animal
  }


  // примените функцию из пункта (f) здесь, не изменяйте сигнатуру
  def testUpdateFood(animal: Animal): Animal = updateFood(animal)

  def main(args: Array[String]): Unit = {
    println(testIntToString(2))
    println(testIntToString(23))
    println(testIsMaxAndMoritz("max"))
    println(testIsMaxAndMoritz("Moritz"))
    println(testIsMaxAndMoritz("Morimax"))
    println(testIsEven(60))
    println(testIsEven(41))
    println(testWinsA(Rock, Paper))
    println(testWinsA(Scissor, Paper))
    println(testWinsA(Scissor, Scissor))

    val wolf = Mammal("wolf", Meat, 50)
    val goldfish = Fish("fish", Plants)
    println(testExtractMammalWeight(wolf))
    println(testExtractMammalWeight(goldfish))

    val pigeon = Bird("pigeon", Vegetables)
    println(pigeon.food)
    println(testUpdateFood(pigeon).food)
  }
}
