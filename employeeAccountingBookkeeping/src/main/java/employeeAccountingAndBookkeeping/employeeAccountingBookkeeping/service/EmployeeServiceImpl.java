package employeeAccountingAndBookkeeping.employeeAccountingBookkeeping.service;

import employeeAccountingAndBookkeeping.employeeAccountingBookkeeping.expection.EmployeeAlreadyAddedException;
import employeeAccountingAndBookkeeping.employeeAccountingBookkeeping.expection.EmployeeNotFoundException;
import employeeAccountingAndBookkeeping.employeeAccountingBookkeeping.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    @Override
    public Employee add(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);

        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);

        if (employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees;
    }
}
