/** Animal Sanctuary */

class Animal (val name: String, val age: Double)

trait Species {
  val speciesName: String
  val conservationStatus: String
  val avgLifespanRange: (Double, Double)
  val numOfYoungRange: (Int, Int)
}

trait Flyable {
  val canFly: Boolean = true
  val wingspan: Double
}

class Mammal (name: String, age: Double) extends Animal (name, age) with Species {
  val furColour: String = "blue"
  val hasTail: Boolean = true
  override val speciesName: String = "Mammal"
  override val conservationStatus: String =  "Least Concern"
  override val avgLifespanRange: (Double, Double) = (10, 20)
  override val numOfYoungRange: (Int, Int) = (1, 3)
}

class Warthog extends Mammal ("Warthog", 5) {
  override val furColour: String = "white"
  override val hasTail: Boolean = false
  val hasTusks: Boolean = true
  override val speciesName: String = "Phacochoerus"
  override val conservationStatus: String =  "Least Concern"
  override val avgLifespanRange: (Double, Double) = (15, 20)
  override val numOfYoungRange: (Int, Int) = (1, 4)
}

class Bird (name: String, age: Double) extends Animal (name, age) with Species with Flyable {
  val beakLength: Double = 1.80
  val featherColour: String = "green"
  override val wingspan: Double = 1.2
  override val speciesName: String = "Bird"
  override val conservationStatus: String = "Least Concern"
  override val avgLifespanRange: (Double, Double) = (5, 15)
  override val numOfYoungRange: (Int, Int) = (1, 4)
}

class Owl extends Bird ("Howl", 1.5) {
  override val beakLength: Double = 0.6
  override val featherColour: String = "brown"
  val hootsPerNight: Int = 16
  override val wingspan: Double = 1.5
  override val speciesName: String = "Strigiformes"
  override val conservationStatus: String = "Least Concern"
  override val avgLifespanRange: (Double, Double) = (10, 25)
  override val numOfYoungRange: (Int, Int) = (1, 3)
}

class Insect (name: String, age: Double) extends Animal (name, age) with Species {
  val numOfLimbs: Int = 4
  override val speciesName: String = "Insect"
  override val conservationStatus: String = "Least Concern"
  override val avgLifespanRange: (Double, Double) = (0.1, 2)
  override val numOfYoungRange: (Int, Int) = (10, 100)
}

class Dragonfly extends Insect ("Dragon", 1.3) with Flyable {
  override val numOfLimbs: Int = 2
  val wingPairs: Int = 2
  override val wingspan: Double = 0.3
  override val speciesName: String = "Anisoptera"
  override val conservationStatus: String = "Least Concern"
  override val avgLifespanRange: (Double, Double) = (0.5, 1.5)
  override val numOfYoungRange: (Int, Int) = (100, 300)
}
