

// применяем Pattern Matching к листу
def flatten[T](list: List[T]): List[T] = list match {
  case Nil => Nil
  case head :: list => head match {           // матчимся на лист листов и применяем к нему Pattern Matching
    // если HEAD - лист, вызваем рекурсивно функцию flatten на HEAD и на оставшийся лист, затем выполняем конкотенацию полученных листов
    case head: List[T] => flatten(head) ::: flatten(list)
    // если HEAD - число
    case head: T => head :: flatten(list)     // создаем лист из числа и в tail кладем вызов flatten на оставишийся лист
  }
}

println(flatten(Nil))
/*
List()
*/

println(flatten(List(1,	2, List(3, 4,	5, List(), 7))))
/*
List(1, 2, 3, 4, 5, 7)
*/

println(flatten(List(1,	2, List(3, 4,	5, List()))))
/*
List(1, 2, 3, 4, 5)
*/

println(flatten(List(1,	2, List(3))))
/*
List(1, 2, 3)
 */

println(flatten(List()))
/*
List()
 */

println(flatten(List(1,	2, List(3, 4,	5, List(List(6,	7, List(8, 9, List(10))))))))
/*
List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
 */
