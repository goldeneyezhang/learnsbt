package learntrait

abstract class IntQueue {
  def get(): Int

  def put(x: Int)

}

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]()

  def get() = buf.remove(0)

  def put(x: Int) = {
    buf += x
  }
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) = {
    super.put(2 * x)
  }
}

// 此处是叠加
class MyQueue extends BasicIntQueue with Doubling {

}

object test1 {
  def main(args: Array[String]): Unit = {
    val queue = new MyQueue();
    queue.put(10)
    System.out.println(queue.get());
  }
}
