package Week1.Fri.afternoontask.mvp.speciestype

import Week1.Fri.afternoontask.mvp.species.Insect
import Week1.Fri.afternoontask.mvp.traits.{DietType, Flyable, Species}

class Dragonfly (name: String, age: Int, numOfLimbs: Int, val wingPairs: Int, val dietType: DietType) extends Insect (name, age, numOfLimbs) with Species with Flyable {
  override val speciesName: String =  "Odanta"
  override val conservationStatus: Boolean = false
  override val avgLifespanRange: String = "6 months - 2 years"
  override val numOfYoungRange: String = "up to 1000"
  override val canFly: Boolean = true
  override val wingspan: Int = 5
}
