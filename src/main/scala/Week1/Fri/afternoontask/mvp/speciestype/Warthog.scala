package Week1.Fri.afternoontask.mvp.speciestype

import Week1.Fri.afternoontask.mvp.species.Mammal
import Week1.Fri.afternoontask.mvp.traits.{DietType, Species}

class Warthog (name: String, age: Int, furColour: String, hasTail: Boolean, val hasTusks: Boolean, val dietType: DietType) extends Mammal (name, age, furColour, hasTail) with Species {
  override val speciesName: String = "Phacochoerus africanus"
  override val conservationStatus: Boolean = false
  override val avgLifespanRange: String = "10-15 years"
  override val numOfYoungRange: String = "1-4"
}
