package recipe1

trait FoodCategories {

  case class FoodCategory(name: String, foods: List[Food])

  def allCategories: List[FoodCategory]
}
