package employeeAccountingAndBookkeeping.employeeAccountingBookkeeping.service;

import employeeAccountingAndBookkeeping.employeeAccountingBookkeeping.expection.EmployeeAlreadyAddedException;
import employeeAccountingAndBookkeeping.employeeAccountingBookkeeping.expection.EmployeeNotFoundException;
import employeeAccountingAndBookkeeping.employeeAccountingBookkeeping.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee add(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);

        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee find(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);

        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }
}
