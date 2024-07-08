package Week1.Fri.afternoontask.mvp.traits

sealed trait DietType

object DietType {
  case object Herbivore extends DietType

  case object Omnivore extends DietType

  case object Carnivore extends DietType
}