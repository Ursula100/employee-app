package Main.kt

val firstName = "Joe";
val surname = "Soap";
val gender = "m";
val employee_Id = "6143"
val gross_Salary = 67_543.21;
val paye = 38.5
val prsi = 5.2;
val annual_Bonus = 1_450.50;
val cws_Monthly_Deduction = 54.33;


fun round(number: Double): String {
    return "%.2f".format(number)
}

fun getMonthlySalary() : Double = gross_Salary/12
fun monthly_Bonus() : Double = annual_Bonus/12
fun getMonthlyPAYE() : Double = getMonthlySalary() *paye/100
fun getMonthlyPRSI() : Double = getMonthlySalary()*prsi/100
fun getGrossMonthlyPay() : Double = getMonthlySalary() + monthly_Bonus()
fun getTotalMonthlyDeductions() : Double = cws_Monthly_Deduction + getMonthlyPAYE() + getMonthlyPRSI()
fun getNetMonthlyPay() : Double = getGrossMonthlyPay() - getTotalMonthlyDeductions()



fun main() {
    print(getPaySlip())

    var input : Int
    do {
        input = menu()
        when(input) {
            1 -> println("Monthly Salary: ${getMonthlySalary()}")
            2 -> println("Monthly PRSI: ${getMonthlyPRSI()}")
            3 ->println("Monthly PAYE: ${getMonthlyPAYE()}")
            4 -> println("Monthly Gross Pay: ${getGrossMonthlyPay()}")
            5 -> println("Monthly Total Deductions: ${getTotalMonthlyDeductions()}")
            6 -> println("Monthly Net Pay: ${getNetMonthlyPay()}")
            7 -> println(getPaySlip())
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
                }
                println()
            } while (input != -1)
}

fun getPaySlip() : String {
    val payslip = """            
        |                                     Monthly Pay Slip
        |                                     
        |  Employee Name: ${getFullName()}                         Employee ID: $employee_Id 
        | 
        |  PAYMENT DETAILS 			                            DEDUCTIONS DETAILS 
        | 
        |  Salary: ${round(getMonthlySalary())} 				                     PAYE: ${round(getMonthlyPAYE())} 
        |  Bonus: ${round(monthly_Bonus())} 					                 PRSI: ${round(getMonthlyPRSI())} 
        | 				           Cycle To Work: ${round(cws_Monthly_Deduction)} 
        | 				                     
        |  Gross: ${round(getGrossMonthlyPay())} 		                        Total Deductions: ${round(getTotalMonthlyDeductions())}
        |  
        |  NET PAY: ${round(getNetMonthlyPay())}
    """.trimMargin()

    return payslip
}

fun getFullName() : String {
    var name : String = when (gender) {
        "m" -> "Mr $firstName $surname"
        "f" -> "Ms $firstName $surname"
        else -> "$firstName $surname"
    }
    return name
}

fun menu() : Int {
    print("""
         Employee Menu for ${getFullName()}
           1. Monthly Salary
           2. Monthly PRSI
           3. Monthly PAYE
           4. Monthly Gross Pay
           5. Monthly Total Deductions
           6. Monthly Net Pay
           7. Full Payslip
          -1. Exit
         Enter Option : """)
    return readLine()!!.toInt()
}

