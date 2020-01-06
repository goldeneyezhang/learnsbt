import ele.Element.elem
import ele.{ArrayElement, Element, LineElement, UniformElement}
import ele.Spiral.{space, spiral}
object App3 {
  def main(args: Array[String]): Unit = {
    val e1: Element = new ArrayElement(Array("hello", "world"))
    //val ae: ArrayElement = new LineElement("hello")
    //val e2: Element = ae
    val e3: Element = new UniformElement('x', 2, 3)
    val ele1 = Element.elem(Array("hello,")) above Element.elem(Array("world!")) beside Element.elem(Array("hi,", "linda"))
    println(ele1)

    val nSides = 6
    println(spiral(nSides, 0))

  }
}
