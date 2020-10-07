class Food {

}

abstract class Animal {
  type SuitableFood <: Food

  def eat(food: SuitableFood)
}

class Grass extends Food

class Cow extends Animal {

  type SuitableFood = Grass

  override def eat(food: Grass) = {

  }
}

object Food extends App {
  val cow = new Cow()
  val grass = new cow.SuitableFood
  cow eat grass
}

class Pasture {
  var animals: List[Animal {type SuitableFood = Grass}] = Nil
  // ...
}
