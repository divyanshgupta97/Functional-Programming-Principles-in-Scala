object nQueens {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(602); 
def nQueens(n: Int): Set[List[Int]] = {

	def isSafe(col: Int, queens: List[Int]): Boolean = {
		val lastRow = queens.length
		val pairList: List[(Int, Int)] = queens zip (lastRow to 0 by -1)
		pairList.forall{case(colNum, rowNum) => {
														val diff = math.abs(colNum - col)
														(diff != 0) && (diff != (lastRow + 1 - rowNum))
												}
										}
	}
		
	def placeQueens(k: Int): Set[List[Int]] =
		if(k == 0) Set(List())
		else
			for{
				queens <- placeQueens(k - 1)
				col <- 0 until n
				if isSafe(col, queens)
			} yield col::queens
	 
	placeQueens(n)
};System.out.println("""nQueens: (n: Int)Set[List[Int]]""");$skip(179); 
	def show(queens:List[Int]) = {
		val lines =
			for(col <- queens.reverse)
			yield Vector.fill(queens.length)("*").updated(col, "X").mkString
			"\n" + (lines mkString "\n")
	};System.out.println("""show: (queens: List[Int])String""");$skip(23); val res$0 = 
	
	nQueens(4) map show;System.out.println("""res0: scala.collection.immutable.Set[String] = """ + $show(res$0))}
}
