

//  Хвостовая рекурсия
def iterationsTail(number: Int, degree: Int, result: Int = 1):Int = {
  if (degree > 0)             // если степень больше нуля
    iterationsTail(number, degree - 1, number * result) // дикрементим степень, высчитываем текущее значение и вызываем функцию еще раз
  else
    result // если степень равно нулю, возвращаем результат
}


// Нехвостовая рекурсия
def iterations(number: Int, degree: Int): Int = {
    if (degree > 0)                             // если степень больше нуля
      number * iterations(number, degree - 1)   // число умножаем на результат рекурсивного вызова функции с уменьшенной степенью
    else
      1                                         // если степень равно нулю, возвращаем единицу
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
// Это не самый лучший вариант рекурсии, так как мы должны хранить scope каждого вызова функции для того,
// чтобы потом все соеденить в выражение и вычислить результат.
println(iterations(-4, 3))
/*
-4 * -4 * -4 * 1
-64
 */

println(iterationsTail(0, 10))
/*
0
 */

println(iterations(0, 10))
/*
0
 */


println(iterationsTail(2, 10))
/*
1024
 */

println(iterations(2, 10))
/*
2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 1
1024
 */


println(iterationsTail(2, 0))
/*
1
 */

println(iterations(2, 0))
/*
1
 */


println(iterationsTail(1, 10^10000))
/*
1
 */

println(iterations(1, 10^10000))
/*
1
 */