package recipe1

abstract class Browser {
  val database: Database

  def recipesUsing(food: Food) =
    database.allReceipes.filter(recipe => recipe.ingredients.contains(food))

  def displayCategory(category: database.FoodCategory) = {
    println(category)
  }
}
