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
};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(671); 
val p1: Poly = new Poly(5->5, 3->3, 1->1);System.out.println("""p1  : week6.Poly = """ + $show(p1 ));$skip(43); 
val p2: Poly = new Poly(5->10, 3->6, 1->2);System.out.println("""p2  : week6.Poly = """ + $show(p2 ));$skip(16); val res$0 = 
(p1 + p2).terms;System.out.println("""res0: scala.collection.immutable.Map[Int,Double] = """ + $show(res$0))}
}
