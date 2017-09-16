object fiddlingAround {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def msort[T](xs: List[T])(lt: (T,T) => Boolean): List[T] = {
	val n = xs.length/2
	if(n == 0) xs
	else{
		val(fst, snd) = xs splitAt n
		merge(msort(fst)(lt), msort(snd)(lt))(lt)
	}
}                                                 //> msort: [T](xs: List[T])(lt: (T, T) => Boolean)List[T]

def merge[T](xs:List[T], ys: List[T])(lt: (T,T) => Boolean): List[T] = (xs, ys) match {
	case (Nil, ys) => ys
	case (xs, Nil) => xs
	case (xs, ys) => if(lt(xs.head, ys.head)) xs.head :: merge(xs.tail, ys)(lt) else ys.head :: merge(xs, ys.tail)(lt)
}                                                 //> merge: [T](xs: List[T], ys: List[T])(lt: (T, T) => Boolean)List[T]

msort(List(9,8,7,6,5,4,3,2,1))((x, y) => x < y)   //> res0: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

def pack[T](xs: List[T]): List[List[T]] = xs match {
case Nil => Nil
case x::xs1 => {
								val (l_1, l_2) = xs span (y => y == x)
								l_1 :: pack(l_2)
								}
}                                                 //> pack: [T](xs: List[T])List[List[T]]
pack(List("a", "a", "a", "b", "c", "c", "a"))     //> res1: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a))
                                                  //| 
def encode[T](xs: List[T]): List[(T, Int)] = xs match {
case Nil => Nil
case x::xs1 => pack(xs) map(x => (x.head, x.length))
}                                                 //> encode: [T](xs: List[T])List[(T, Int)]
encode(List("a", "a", "a", "b", "c", "c", "a"))   //> res2: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))

def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]())( f(_)::_ )             //> mapFun: [T, U](xs: List[T], f: T => U)List[U]


val fun: (Int => Int) = x => 2 * x                //> fun  : Int => Int = fiddlingAround$$$Lambda$15/1419810764@36f6e879
mapFun(List(1,2,3,4), fun)                        //> res3: List[Int] = List(2, 4, 6, 8)

def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0)((elem,acc) => acc + 1)         //> lengthFun: [T](xs: List[T])Int
  
 lengthFun(List(1,2,3,4,5,6,7))                   //> res4: Int = 7
 
 val s: String = "Hello World"                    //> s  : String = Hello World
 s filter(c => c.isUpper)                         //> res5: String = HW
 s exists(c => c.isUpper)                         //> res6: Boolean = true
 s forall(c => c.isUpper)                         //> res7: Boolean = false
 
 val pairs = List(1,2,3) zip s                    //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
 pairs.unzip                                      //> res8: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))
 s flatMap(c => List('.', c))                     //> res9: String = .H.e.l.l.o. .W.o.r.l.d
 (1 to 3) flatMap(x => (1 to 4) map ( y => (x,y)))//> res10: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (1
                                                  //| ,2), (1,3), (1,4), (2,1), (2,2), (2,3), (2,4), (3,1), (3,2), (3,3), (3,4))
def isPrime(n: Int): Boolean = (2 to n-1) map ( x => (x, n)) forall {case (x, y) => y % x != 0}
                                                  //> isPrime: (n: Int)Boolean
def for_loop(n: Int) = (1 until n).map(i => {(1 until i).map(j => (i, j))}).flatten
                                                  //> for_loop: (n: Int)scala.collection.immutable.IndexedSeq[(Int, Int)]
for_loop(7)                                       //> res11: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3
                                                  //| ,1), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), 
                                                  //| (6,3), (6,4), (6,5))
def for_loop_flatMap(n: Int) = (1 until n).flatMap(i => {(1 until i).map(j => (i, j))}).filter{case (x, y) => isPrime(x + y)}
                                                  //> for_loop_flatMap: (n: Int)scala.collection.immutable.IndexedSeq[(Int, Int)]
                                                  //| 
for_loop_flatMap(7)                               //> res12: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3
                                                  //| ,2), (4,1), (4,3), (5,2), (6,1), (6,5))
def scalarProduct(xs: List[Double], ys: List[Double]): Double = {
	(for((x, y) <- xs zip ys ) yield (x * y)) reduceLeft(_+_)
}                                                 //> scalarProduct: (xs: List[Double], ys: List[Double])Double
                                                  
}