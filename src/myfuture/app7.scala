package myfuture

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object app7 extends App {
  val fut = Future {
    Thread.sleep(1000);
    21 + 21
  }
  val result = fut.map(x => x + 1)
  println(result.value);
  Thread.sleep(1000);
  println(result.value)
}
