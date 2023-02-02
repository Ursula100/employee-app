package Main.kt

val firstName = "Joe";
val surname = "Soap";
val gender = "m";
val employee_Id = "6143"
val gross_Salary = 67_543.21;
val paye_Percentage = 38.5
val prsi_Percentage = 5.2;
val annual_Bonus = 1_450.50;
val cws_Monthly_Deduction = 54.33;


fun monthly(number : Double) =  number/12
fun fromPercentage(percentage: Double) : Double{
    return (percentage * (monthlySalary/100))
}
fun round(number: Double): String {
    return "%.2f".format(number)
}

val monthlySalary : Double = monthly(gross_Salary)
val monthly_Bonus : Double = monthly(annual_Bonus)
val paye = fromPercentage(paye_Percentage)
val prsi = fromPercentage(paye_Percentage)
val gross = monthlySalary + monthly_Bonus
val deduction = cws_Monthly_Deduction + paye + prsi


fun main() {
    val payslip = """            
        |                                     Monthly Pay Slip
        |                                     
        |  Employee Name: $firstName $surname(${gender.uppercase()})         Employee ID: $employee_Id 
        | 
        |  PAYMENT DETAILS 			                                         DEDUCTIONS DETAILS 
        | 
        |  Salary: ${round(monthlySalary)} 				                     PAYE: ${round(paye)} 
        |  Bonus: ${round(monthly_Bonus)} 					                 PRSI: ${round(prsi)} 
        | 				                   Cycle To Work: ${round(cws_Monthly_Deduction)} 
        | 				                     
        |  Gross: ${round(gross)} 		                                     Total Deductions: ${round(deduction)}
        |  
        |  NET PAY: ${round(gross - deduction)}
    """.trimMargin()

    printPaySlip(payslip)
}

fun printPaySlip(employee: Any){
    print(employee)
}


