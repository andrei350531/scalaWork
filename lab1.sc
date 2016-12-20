/*
Написать	функцию	возведениячисла	n	встепень	m	ввиде простой	и хвостовой	рекурсии,	сравнить	результ
 */


//  Хвостовая рекурсия
def iterationsTail(number: Int, degree: Int, result: Int = 1):Int = {
  if (degree > 0) {
    // если степень больше нуля
    println("Call: iterationsTail("+ number +", "+ (degree - 1) + ", "+ (number * result) +")")
    iterationsTail(number, degree - 1, number * result) // дикрементим степень, высчитываем текущее значение и вызываем функцию еще раз
  }
  else {
    println("Return result: " + result)
    result // если степень равно нулю, возвращаем результат
  }
}


// Нехвостовая рекурсия
def iterations(number: Int, degree: Int): Int = {
    if (degree > 0) {    // если степень больше нуля
      // число умножаем на результат рекурсивного вызова функции с уменьшенной степенью
      print(number + " * ")
      number * iterations(number, degree - 1)
    }
    else {
      // если степень равно нулю, возвращаем единицу
      println("1")
      1
    }
}

// В случае хвостовой рекурсии результат операции вычисляется на каждом вызове
println(iterationsTail(-4, 3))
/*
Call: iterationsTail(-4, 2, -4)
Call: iterationsTail(-4, 1, 16)
Call: iterationsTail(-4, 0, -64)
Return result: -64
 */


// В случае нехвостовой рекурсии сначала формируется все выражение и в конце вычисляется результат
// Это не самый лучший вариант рекурсии, так как мы должны хранить scope каждого вызова функции для того чтобы потом все соеденить в выражение и вычислить результат
println(iterations(-4, 3))
/*
-4 * -4 * -4 * 1
-64
 */

println(iterationsTail(0, 10))
/*
Call: iterationsTail(0, 9, 0)
Call: iterationsTail(0, 8, 0)
Call: iterationsTail(0, 7, 0)
Call: iterationsTail(0, 6, 0)
Call: iterationsTail(0, 5, 0)
Call: iterationsTail(0, 4, 0)
Call: iterationsTail(0, 3, 0)
Call: iterationsTail(0, 2, 0)
Call: iterationsTail(0, 1, 0)
Call: iterationsTail(0, 0, 0)
Return result: 0
 */

println(iterations(0, 10))
/*
0 * 0 * 0 * 0 * 0 * 0 * 0 * 0 * 0 * 0 * 1
0
 */


println(iterationsTail(2, 10))
/*
Call: iterationsTail(2, 9, 2)
Call: iterationsTail(2, 8, 4)
Call: iterationsTail(2, 7, 8)
Call: iterationsTail(2, 6, 16)
Call: iterationsTail(2, 5, 32)
Call: iterationsTail(2, 4, 64)
Call: iterationsTail(2, 3, 128)
Call: iterationsTail(2, 2, 256)
Call: iterationsTail(2, 1, 512)
Call: iterationsTail(2, 0, 1024)
Return result: 1024
 */

println(iterations(2, 10))
/*
2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 1
1024
 */


println(iterationsTail(2, 0))
/*
Return result: 1
 */

println(iterations(2, 0))
/*
1
 */