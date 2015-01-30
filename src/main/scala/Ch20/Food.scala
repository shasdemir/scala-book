package Ch20

/**
 * Created by sukruhasdemir on 28/01/15.
 */
class Food
abstract class Animal {
    type SuitableFood <: Food
    def eat(food: SuitableFood)
    def makeFood(): SuitableFood
}


class Fish extends Food


class Grass extends Food
class Cow extends Animal {
    type SuitableFood = Grass
    override def eat(food: Grass) {}
    override def makeFood() = new Grass
}


class DogFood extends Food
class Dog extends Animal {
    type SuitableFood = DogFood
    override def eat(food: DogFood) {}
    override def makeFood() = new DogFood
}


class Pasture {
    var animals = List[Animal { type SuitableFood = Grass }] = Nil
}