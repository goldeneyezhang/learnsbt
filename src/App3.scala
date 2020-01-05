import ele.{ArrayElement, Element, LineElement, UniformElement}

object App3 {
  def main(args: Array[String]): Unit = {
    val e1: Element = new ArrayElement(Array("hello", "world"))
    val ae: ArrayElement = new LineElement("hello")
    val e2: Element = ae
    val e3: Element = new UniformElement('x', 2, 3)
  }
}