package Week1.Fri.afternoontask.mvp.kingdom

class Animal (val name: String, age: Int) {
  def ageInHumanYears(multiplier: Double): Double = age * multiplier
  def speak(voice: String): String = voice
}