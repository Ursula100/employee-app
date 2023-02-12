package Main.kt

var employee =  Employee("Joe", "Soap", 'm', 6143, 67543.21, 38.5, 5.2, 1450.50, 54.33)

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
        | _____________________________________________________________________________________________________________
        |                                     
        |  Employee Name: ${getFullName()}                         Employee ID: ${employee.employee_Id}
        | _____________________________________________________________________________________________________________
        | 
        |  PAYMENT DETAILS 			                         DEDUCTIONS DETAILS 
        | 
        |  Salary: ${getMonthlySalary()} 				                     PAYE: ${getMonthlyPAYE()} 
        |  Bonus: ${monthly_Bonus()} 					                 PRSI: ${getMonthlyPRSI()} 
        |                                                     Cycle To Work: ${employee.cws_Monthly_Deduction}
        | ______________________________________________________________________________________________________________		                     
        |  Gross: ${getGrossMonthlyPay()} 		                        Total Deductions: ${getTotalMonthlyDeductions()}
        | ______________________________________________________________________________________________________________
        |  NET PAY: ${getNetMonthlyPay()}
    """.trimMargin()

    return payslip
}

fun getFullName() = when (employee.gender){
    'm', 'M' -> "Mr. ${employee.firstName} ${employee.surname}"
    'f', 'F' -> "Ms.  ${employee.firstName} ${employee.surname}"
    else ->  "${employee.firstName} ${employee.surname}"
}



fun round(number: Double): Double {
    return "%.2f".format(number).toDouble()
}

fun getMonthlySalary() : Double = round(employee.gross_Salary/12)
fun monthly_Bonus() : Double = round(employee.annual_Bonus/12)
fun getMonthlyPAYE() : Double = round(getMonthlySalary() * employee.payePercentage/100)
fun getMonthlyPRSI() : Double = round(getMonthlySalary()* employee.prsiPercentage/100)
fun getGrossMonthlyPay() : Double = round(getMonthlySalary() + monthly_Bonus())
fun getTotalMonthlyDeductions() : Double = round(employee.cws_Monthly_Deduction + getMonthlyPAYE() + getMonthlyPRSI())
fun getNetMonthlyPay() : Double = round(getGrossMonthlyPay() - getTotalMonthlyDeductions())


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



