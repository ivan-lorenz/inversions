import org.scalatest.FlatSpec

class InversionsTest extends FlatSpec {

  behavior of "Inversions"

  it should "should compute inversions for a case" in {
    assert(Inversions.getNumberOfInversions(Array(2,3,9,2,9), Array.empty[Int],0, 5) == 2)
  }

  it should "should compute inversions for b case" in {
    assert(Inversions.getNumberOfInversions(Array(9, 8, 7, 3, 2, 1), Array.empty[Int],0, 6) == 15)
  }

}
