object nQueens {
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
}                                                 //> nQueens: (n: Int)Set[List[Int]]
	def show(queens:List[Int]) = {
		val lines =
			for(col <- queens.reverse)
			yield Vector.fill(queens.length)("*").updated(col, "X").mkString
			"\n" + (lines mkString "\n")
	}                                         //> show: (queens: List[Int])String
	
	nQueens(4) map show                       //> res0: scala.collection.immutable.Set[String] = Set("
                                                  //| *X**
                                                  //| ***X
                                                  //| X***
                                                  //| **X*", "
                                                  //| **X*
                                                  //| X***
                                                  //| ***X
                                                  //| *X**")
}