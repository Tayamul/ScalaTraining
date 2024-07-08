package Week1.Fri.afternoontask.mvp.speciestype

import Week1.Fri.afternoontask.mvp.species.Bird
import Week1.Fri.afternoontask.mvp.traits.{DietType, Flyable, Species}

class Owl (name: String, age: Int, beakLength: Double, featherColour: String, val hootsPerNight: Int, val dietType: DietType) extends Bird (name, age, beakLength, featherColour) with Species with Flyable {

  override val speciesName: String = "Strigiformes"
  override val conservationStatus: Boolean = false
  override val avgLifespanRange: String = "10-20 years"
  override val numOfYoungRange: String = "1-5"
  override val canFly: Boolean = true
  override val wingspan: Int = 30
}
