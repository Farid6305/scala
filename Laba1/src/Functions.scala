/** Напишите отдельные функции, решающие поставленную задачу.
  * 
  * Синтаксис:
  *   // метод
  *   def myFunction(param0: Int, param1: String): Double = // тело
  * 
  *   // значение
  *   val myFunction: (Int, String) => Double (param0, param1) => // тело
  */
object Functions {

  /* a) Напишите функцию, которая рассчитывает площадь окружности
   *    r^2 * Math.PI
   */
  def areaCircle(r: Double): Double = r * r * Math.PI


  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testCircle(r: Double): Double = areaCircle(r)
  


  /* b) Напишите карированную функцию которая рассчитывает площадь прямоугольника a * b.
   */
  def areaRectangle(a: Double)(b: Double): Double = a * b

  // примените вашу функцию из пункта (b) здесь, не изменяя сигнатуру
  def testRectangleCurried(a: Double, b: Double): Double = areaRectangle(a)(b)


  // c) Напишите не карированную функцию для расчета площади прямоугольника.
  def areaRectangle2(a: Double, b: Double): Double = a*b


  // примените вашу функцию из пункта (c) здесь, не изменяя сигнатуру
  def testRectangleUc(a: Double, b: Double): Double = areaRectangle2(a, b)

  def main(args: Array[String]): Unit = {
    println(testCircle(3.5))
    println(testRectangleCurried(5.5, 4.2))
    println(testRectangleUc(10.5, 6))
  }
}
