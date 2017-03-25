import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}

object InversionsCheck extends Properties("Inversions"){

  val genNumbers: Gen[Int] = Gen.choose(1, 1000)
  val listOfNumbers: Gen[Array[Int]] =
    for {
      size <- Gen.choose(1,100)
      elems <- Gen.containerOfN[Array, Int](size, genNumbers)
    } yield elems

  property("both solutions shoul be equivalent") =
    forAll(listOfNumbers){list  =>
      val expectedresult = Inversions.getNumberOfInversionsNaive(list, Array.empty[Int], 0,list.length)
      val result = Inversions.getNumberOfInversions(list, Array.empty[Int], 0,list.length)
      val assertion = result == expectedresult
      if (!assertion)
        System.out.println(s"ERROR for list : ${list.mkString(",")} with expected result =  $expectedresult and result = $result")
      assertion
    }

}
