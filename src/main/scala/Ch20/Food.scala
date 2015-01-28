package Ch20

/**
 * Created by sukruhasdemir on 28/01/15.
 */
class Food
abstract class Animal {
    type SuitableFood <: Food
    def eat(food: SuitableFood)
}


class Grass extends Food
class Cow extends Animal {
    type SuitableFood = Grass
    override def eat(food: Grass) {}
}