package ie.setu.controllers

import ie.setu.models.Employee

var lastId = 0

internal fun getId(): Int {
    return lastId++
}

class EmployeeAPI {

    private val employees = ArrayList<Employee>()

    fun findAll(): List<Employee> {
        return employees
    }

    fun findOne(id: Int): Employee? {
        return employees.find { p -> p.employee_Id == id }
    }

    fun create(employee: Employee) {
        employee.employee_Id = getId()
        employees.add(employee)
    }

}
