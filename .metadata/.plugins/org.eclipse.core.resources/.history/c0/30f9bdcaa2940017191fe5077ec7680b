object week6 {
class Poly(val terms0: Map[Int, Double]) {

	val terms = terms0 withDefaultValue 0.0
	
	def this(bindings: (Int, Double)*) = this(bindings.toMap)
	
	//def + (other: Poly): Poly = new Poly(this.terms ++ (other.terms map adjust))
	
	def + (other: Poly): Poly = new Poly((other.terms foldLeft terms)(addTerm))
	
	def adjust(term: (Int, Double)): (Int, Double) = {
		val (exp, coeff) = term
		exp -> (coeff + terms(exp))
	}
	
	def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
		val (exp, coeff) = term
		val newTerm: (Int, Double) = (exp, coeff + terms(exp))
		terms ++ Map(newTerm)
	}
}
val p1: Poly = new Poly(5->5, 3->3, 1->1)         //> p1  : week6.Poly = week6$Poly@7a5d012c
val p2: Poly = new Poly(5->10, 3->6, 1->2)        //> p2  : week6.Poly = week6$Poly@13fee20c
(p1 + p2).terms                                   //> res0: scala.collection.immutable.Map[Int,Double] = Map(5 -> 15.0, 3 -> 9.0, 
                                                  //| 1 -> 3.0)
}