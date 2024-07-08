package Week1.Fri.afternoontask.mvp

import Week1.Fri.afternoontask.mvp.kingdom.Animal
import Week1.Fri.afternoontask.mvp.speciestype.Warthog
import Week1.Fri.afternoontask.mvp.traits.DietType

object Sanctuary extends App {
  val birminghamSanctuary: List[Animal] = List(
    new Warthog("Pumba", 6, "brown", true, true, DietType.Herbivore)
  )

  val warthog = new Warthog("Leo", 6, "brown", true, true, DietType.Herbivore)
  println(s"Age in human years: warthog.ageInHumanYears(2)")
  println(s"Sound ${warthog.name} the Warthog makes: ${warthog.speak("hoo hooo hooo")}")
  println(s"Endangered status: ${warthog.isEndangered(warthog.conservationStatus)}")
}