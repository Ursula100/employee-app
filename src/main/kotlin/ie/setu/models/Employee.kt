package ie.setu.models

class Employee(var firstName : String, var surname : String, var gender : Char, var employee_Id : Int, var gross_Salary : Double, var payePercentage : Double, var prsiPercentage : Double, var annual_Bonus : Double, var cws_Monthly_Deduction :Double) {
    fun getPaySlip(): String {

        return """            
        |                                     Monthly Pay Slip
        | _____________________________________________________________________________________________________________
        |                                     
        |  Employee Name: ${getFullName()}                         Employee ID: $employee_Id
        | _____________________________________________________________________________________________________________
        | 
        |  PAYMENT DETAILS 			                         DEDUCTIONS DETAILS 
        | 
        |  Salary: ${getMonthlySalary()} 				                     PAYE: ${getMonthlyPAYE()} 
        |  Bonus: ${monthly_Bonus()} 					                  PRSI: ${getMonthlyPRSI()} 
        |                                                     Cycle To Work: $cws_Monthly_Deduction
        | ______________________________________________________________________________________________________________		                     
        |  Gross: ${getGrossMonthlyPay()} 		                        Total Deductions: ${getTotalMonthlyDeductions()}
        | ______________________________________________________________________________________________________________
        |  NET PAY: ${getNetMonthlyPay()}
    """.trimMargin()
    }

    fun getFullName() = when (gender){
        'm', 'M' -> "Mr. ${firstName} ${surname}"
        'f', 'F' -> "Ms.  ${firstName} ${surname}"
        else ->  "${firstName} ${surname}"
    }



    fun round(number: Double): Double {
        return "%.2f".format(number).toDouble()
    }

    fun getMonthlySalary() : Double = round(gross_Salary/12)
    fun monthly_Bonus() : Double = round(annual_Bonus/12)
    fun getMonthlyPAYE() : Double = round(getMonthlySalary() * payePercentage/100)
    fun getMonthlyPRSI() : Double = round(getMonthlySalary()* prsiPercentage/100)
    fun getGrossMonthlyPay() : Double = round(getMonthlySalary() + monthly_Bonus())
    fun getTotalMonthlyDeductions() : Double = round(cws_Monthly_Deduction + getMonthlyPAYE() + getMonthlyPRSI())
    fun getNetMonthlyPay() : Double = round(getGrossMonthlyPay() - getTotalMonthlyDeductions())
}