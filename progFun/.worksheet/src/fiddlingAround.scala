object fiddlingAround {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(67); 
  println("Welcome to the Scala worksheet");$skip(186); 
  def msort[T](xs: List[T])(lt: (T,T) => Boolean): List[T] = {
	val n = xs.length/2
	if(n == 0) xs
	else{
		val(fst, snd) = xs splitAt n
		merge(msort(fst)(lt), msort(snd)(lt))(lt)
	}
};System.out.println("""msort: [T](xs: List[T])(lt: (T, T) => Boolean)List[T]""");$skip(251); 

def merge[T](xs:List[T], ys: List[T])(lt: (T,T) => Boolean): List[T] = (xs, ys) match {
	case (Nil, ys) => ys
	case (xs, Nil) => xs
	case (xs, ys) => if(lt(xs.head, ys.head)) xs.head :: merge(xs.tail, ys)(lt) else ys.head :: merge(xs, ys.tail)(lt)
};System.out.println("""merge: [T](xs: List[T], ys: List[T])(lt: (T, T) => Boolean)List[T]""");$skip(49); val res$0 = 

msort(List(9,8,7,6,5,4,3,2,1))((x, y) => x < y);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(171); 

def pack[T](xs: List[T]): List[List[T]] = xs match {
case Nil => Nil
case x::xs1 => {
								val (l_1, l_2) = xs span (y => y == x)
								l_1 :: pack(l_2)
								}
};System.out.println("""pack: [T](xs: List[T])List[List[T]]""");$skip(46); val res$1 = 
pack(List("a", "a", "a", "b", "c", "c", "a"));System.out.println("""res1: List[List[String]] = """ + $show(res$1));$skip(127); 
def encode[T](xs: List[T]): List[(T, Int)] = xs match {
case Nil => Nil
case x::xs1 => pack(xs) map(x => (x.head, x.length))
};System.out.println("""encode: [T](xs: List[T])List[(T, Int)]""");$skip(48); val res$2 = 
encode(List("a", "a", "a", "b", "c", "c", "a"));System.out.println("""res2: List[(String, Int)] = """ + $show(res$2));$skip(91); 

def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]())( f(_)::_ );System.out.println("""mapFun: [T, U](xs: List[T], f: T => U)List[U]""");$skip(37); 


val fun: (Int => Int) = x => 2 * x;System.out.println("""fun  : Int => Int = """ + $show(fun ));$skip(27); val res$3 = 
mapFun(List(1,2,3,4), fun);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(80); 

def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0)((elem,acc) => acc + 1);System.out.println("""lengthFun: [T](xs: List[T])Int""");$skip(35); val res$4 = 
  
 lengthFun(List(1,2,3,4,5,6,7));System.out.println("""res4: Int = """ + $show(res$4));$skip(33); 
 
 val s: String = "Hello World";System.out.println("""s  : String = """ + $show(s ));$skip(26); val res$5 = 
 s filter(c => c.isUpper);System.out.println("""res5: String = """ + $show(res$5));$skip(26); val res$6 = 
 s exists(c => c.isUpper);System.out.println("""res6: Boolean = """ + $show(res$6));$skip(26); val res$7 = 
 s forall(c => c.isUpper);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(33); 
 
 val pairs = List(1,2,3) zip s;System.out.println("""pairs  : List[(Int, Char)] = """ + $show(pairs ));$skip(13); val res$8 = 
 pairs.unzip;System.out.println("""res8: (List[Int], List[Char]) = """ + $show(res$8));$skip(30); val res$9 = 
 s flatMap(c => List('.', c));System.out.println("""res9: String = """ + $show(res$9));$skip(51); val res$10 = 
 (1 to 3) flatMap(x => (1 to 4) map ( y => (x,y)));System.out.println("""res10: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$10));$skip(96); 
def isPrime(n: Int): Boolean = (2 to n-1) map ( x => (x, n)) forall {case (x, y) => y % x != 0};System.out.println("""isPrime: (n: Int)Boolean""");$skip(84); 
def for_loop(n: Int) = (1 until n).map(i => {(1 until i).map(j => (i, j))}).flatten;System.out.println("""for_loop: (n: Int)scala.collection.immutable.IndexedSeq[(Int, Int)]""");$skip(12); val res$11 = 
for_loop(7);System.out.println("""res11: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$11));$skip(126); 
def for_loop_flatMap(n: Int) = (1 until n).flatMap(i => {(1 until i).map(j => (i, j))}).filter{case (x, y) => isPrime(x + y)};System.out.println("""for_loop_flatMap: (n: Int)scala.collection.immutable.IndexedSeq[(Int, Int)]""");$skip(20); val res$12 = 
for_loop_flatMap(7);System.out.println("""res12: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$12));$skip(127); 
def scalarProduct(xs: List[Double], ys: List[Double]): Double = {
	(for((x, y) <- xs zip ys ) yield (x * y)) reduceLeft(_+_)
};System.out.println("""scalarProduct: (xs: List[Double], ys: List[Double])Double""")}
                                                  
}
