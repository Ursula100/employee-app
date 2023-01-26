package Main.kt

import java.text.DecimalFormat

val firstName = "Joe";
val surname = "Soap";
val gender = "m";
val employee_Id = "6143"
val gross_Salary = 67_543.21;
val paye_Percentage = 38.5
val prsi_Percentage = 5.2;
val annual_Bonus = 1_450.50;
val cws_Monthly_Deduction = 54.33;

val df = DecimalFormat("#.##")

fun monthly(number : Double) =  number/12
fun fromPercentage(percentage: Double) : Double{
    return (percentage * (monthlySalary/100))
}
val monthlySalary : Double = monthly(gross_Salary)
val monthly_Bonus : Double = monthly(annual_Bonus)
val paye = fromPercentage(paye_Percentage)
val prsi = fromPercentage(paye_Percentage)
val gross = monthlySalary + monthly_Bonus
val deduction = cws_Monthly_Deduction + paye + prsi


fun main() {
    println("\t\t Monthly Pay Slip \n\n")
    println("Employee Name: $firstName $surname($gender) \t\t Employee ID: $employee_Id \n\n")
    println("PAYMENT DETAILS \t\t\t  DEDUCTIONS DETAILS \n")
    println("Salary: $monthlySalary \t\t PAYE: $paye \n")
    println("Bonus: $monthly_Bonus \t\t\t PRSI: $prsi \n")
    println("\t\t\t\t Cycle To Work: $cws_Monthly_Deduction \n\n")
    println("Gross: $gross \t\t Total Deductions: $deduction \n\n")
    println("\t\t NET PAY: ${gross - deduction}")
}


