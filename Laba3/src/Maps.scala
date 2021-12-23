
/** Напишите вашу реализацию в тестовые функции.
  * 
  * https://docs.scala-lang.org/overviews/collections/maps.html
  */
object Maps {

  case class User(name: String, age: Int)

  /* a) В данной Seq[User] сгруппируйте пользователей по имени (`groupBy`) и вычислите средний возраст: `name -> averageAge`
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  def testGroupUsers(users: Seq[User]): Map[String, Int] =
    users.groupBy(_.name).
      map(x => (x._1, x._2.foldLeft(0)((a, b) => a + b.age / x._2.length)))

  /* b) Дана `Map[String, User]` состоящая из имен пользователей `User`, сколько имен пользователей, содержащихся в Map, содержат подстроку "Adam"?
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  def testNumberFrodos(map: Map[String, User]): Int = map.count(x => x._2.name.contains("Adam"))

  /* c) Удалите всех пользователей возраст которых менее 35 лет.
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  def testUnderaged(map: Map[String, User]): Map[String, User] = map.filter(x => x._2.age >= 35)



  def main(args: Array[String]): Unit = {

    val user1 = User("Vladislav", 37)
    val user2 = User("Biyarslan", 20)
    val user3 = User("Adam", 40)
    val user4 = User("Natasha", 19)
    val user5 = User("Adam", 30)
    val user6 = User("Vladislav", 21)
    val user7 = User("Natasha", 53)

    val users: Seq[User] = Seq(user1, user2, user3, user4, user5, user6, user7)
    val usersMap: Map[String, User] = Map("1" -> user1, "2" -> user2, "3" -> user3, "4" -> user4, "5" -> user5)

    println("GroupUsers:")
    println("Входные данные:\nSeq(User(\"Vladislav\", 37), User(\"Biyarslan\", 20), User(\"Adam\", 40), " +
      "User(\"Natasha\", 19), User(\"Adam\", 30), User(\"Vladislav\", 21), User(\"Natasha\", 53))")
    println("Результат: " + testGroupUsers(users))

    println("\nNumberFrodos:")
    println("Входные данные:\nMap(\"1\" -> User(\"Vladislav\", 37), \"2\" -> User(\"Biyarslan\", 20), " +
      "\"3\" -> User(\"Adam\", 40), \"4\" -> User(\"Natasha\", 19), \"5\" -> User(\"Adam\", 30))")
    println("Результат: " + testNumberFrodos(usersMap))

    println("\nUnderaged:")
    println("Входные данные:\nMap(\"1\" -> User(\"Vladislav\", 37), \"2\" -> User(\"Biyarslan\", 20), " +
      "\"3\" -> User(\"Adam\", 40), \"4\" -> User(\"Natasha\", 19), \"5\" -> User(\"Adam\", 30))")
    println("Результат: " + testUnderaged(usersMap))
  }
}
