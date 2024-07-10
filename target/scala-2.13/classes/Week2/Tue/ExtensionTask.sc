case class Employee (name: String, age: Int, isEmployee: Boolean)

val employee1: Employee = Employee(name = "Andy", age = 31 , isEmployee = true)
val employee2: Employee = Employee(name = "Brad", age = 26 , isEmployee = true)
val employee3: Employee = Employee(name = "Blake", age = 35 , isEmployee = false)

val updatedEmployee1: Employee = employee1.copy(age = 32)
val updatedEmployee2: Employee = employee2.copy(name = "Bradley")
val updatedEmployee3: Employee = employee3.copy(isEmployee = true)

val updatedEmployeeToString1: String = updatedEmployee1.toString
val updatedEmployeeToString2: String = updatedEmployee2.toString
val updatedEmployeeToString3: String = updatedEmployee3.toString

updatedEmployeeToString1.equals(updatedEmployeeToString2)
updatedEmployeeToString1.equals(updatedEmployeeToString3)
updatedEmployeeToString3.equals(updatedEmployeeToString2)

