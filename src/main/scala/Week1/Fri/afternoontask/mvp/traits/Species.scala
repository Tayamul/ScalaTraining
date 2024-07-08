package Week1.Fri.afternoontask.mvp.traits

trait Species {
  val speciesName: String
  val conservationStatus: Boolean
  val avgLifespanRange: String
  val numOfYoungRange: String

  def isEndangered (conservationStatus: Boolean): String = if (conservationStatus) "Endangered Animal." else "Not Endangered."
}
