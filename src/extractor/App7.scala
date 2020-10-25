package extractor;

object App7 extends App {
  println(Email.unapply(Email.apply("goldeneyezhang","163.com")) equals(Some("goldeneyezhang","163.com")))
  println(Domain.isTomInDot("tom@sun.com"))
  println(Domain.isTomInDot("peter@sun.com"))
  println(Domain.isTomInDot("peter@sun.org"))

  val s = "tom@support.epfl.ch"
  val ExpandedEmail(name,topdom,subdoms  @ _*) = s
  println(name)
  println(topdom)
  println(subdoms)
}
