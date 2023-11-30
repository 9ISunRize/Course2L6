package employeeAccountingAndBookkeeping.employeeAccountingBookkeeping.controller;

import employeeAccountingAndBookkeeping.employeeAccountingBookkeeping.model.Employee;
import employeeAccountingAndBookkeeping.employeeAccountingBookkeeping.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employees" )
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam String firstName, @RequestParam String secondName) {
        return employeeService.add(firstName,secondName);
    }
    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String secondName) {
        return employeeService.remove(firstName,secondName);
    }
    @GetMapping(path = "/find")
    public Employee find(@RequestParam String firstName, @RequestParam String secondName) {
        return employeeService.find(firstName,secondName);
    }
    @GetMapping
    public Collection <Employee> findAll() {
        return employeeService.findAll();
    }
}
