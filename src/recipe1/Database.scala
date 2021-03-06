package recipe1

abstract class Database extends FoodCategories {
  def allFoods: List[Food]

  def allRecipes: List[Recipe]

  def foodNamed(name: String) =
    allFoods.find(f => f.name == name)

  //case class FoodCategory(name: String, foods: List[Food])

  //def allCategories: List[FoodCategory]
}
