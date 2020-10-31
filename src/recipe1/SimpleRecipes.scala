package recipe1

trait SimpleRecipes {
  this: SimpleFoods =>

  object FruitSalad extends Recipe(
    "fruit salad", List(Apple, Pear), "Mix it all together"
  )

  def allRecipes = List(FruitSalad)
}
