/*
  На языке скала написать функцию flatten для списка.
  Функция должна быль линейной сложности. Показать,
  что сложность вычислений пропорциональна суммарной длине
*/

def runFlatten[T](list: List[T]): List[T] = {
  // счетчик нужен для подсчета итераций,
  // без него функция была бы намного красивее и меньше :)
  var counter: Int = 0
  def increment() = counter += 1

  // функция flatten
  def flatten[T](list: List[T]): List[T] = list match { // применяем Pattern Matching к листу
    case Nil => {                               // если находим Nil, его и возвращаем
      increment()
      Nil
    }
    case head :: list => head match {           // матчимся на лист листов и применяем к нему Pattern Matching
      case head: List[T] => {                   // если HEAD - лист
        increment()
        flatten(head) ::: flatten(list)         // вызваем рекурсивно функцию flatten на HEAD и на оставшийся лист, затем выполняем конкотенацию полученных листов
      }
      case head: T => {                         // если HEAD - число
        increment()
        head :: flatten(list)                   // то создаем лист из числа и в tail кладем вызов flatten на оставишийся лист
      }
    }
  }

  val resultList: List[T] = flatten(list)
  val len: Int = resultList.length
  println("List length: " + len)
  println("Steps count: " + counter)
  if (len != 0)
    println("Linear time: O(" + (counter / len) + "n)")
  resultList
}


println(runFlatten(List(1,	2, List(3, 4,	5, List()))))
/*
List length: 5
Steps count: 10
Linear time: O(2n)
List(1, 2, 3, 4, 5)
*/

println(runFlatten(List(1,	2, List(3, 4,	5, List(), 7, List(8)))))
/*
List length: 7
Steps count: 14
Linear time: O(2n)
List(1, 2, 3, 4, 5, 7, 8)
*/
println(runFlatten(List(1,	2, List(3))))
/*
List length: 3
Steps count: 6
Linear time: O(2n)
List(1, 2, 3)
 */
println(runFlatten(List()))
/*
List length: 0
Steps count: 1
List()
 */
println(runFlatten(List(1,	2, List(3, 4,	5, List(List(6,	7, List(8, 9, List(10))))))))
/*
List length: 10
Steps count: 21
Linear time: O(2n)
List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
 */
