package com.example.Employee.controller;


import com.example.Employee.Employee;
import com.example.Employee.service.EmployeeMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeMethods employeeMethods;

    @Autowired
    public EmployeeController(EmployeeMethods employeeMethods) {
        this.employeeMethods = employeeMethods;
    }

    /*  @GetMapping
      public ResponseEntity<List<Employee>> getAllEmployee() {
          return new ResponseEntity<>(this.employeeMethods.showAllEmployee(), HttpStatusCode.valueOf(200));
      }*/
    @GetMapping("/")
    public ModelAndView showAllEmployee(Model model) {
        model.addAttribute("employees", employeeMethods.showAllEmployee());
        return new ModelAndView("employees");
    }

    @GetMapping("/{id}")
    public ModelAndView employeeDetail(@PathVariable("id") int id, Model model) {
        Optional<Employee> employee = employeeMethods.employeeInfo(id);

        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());

        } else {
            model.addAttribute("empty", "User not FOUND");


        }

        return new ModelAndView("employee");

    }

    @GetMapping("/add")
    public ModelAndView viewData(Model model){
        model.addAttribute("employee", new Employee() );
        return new ModelAndView("employee-creation-form");

    }

    @PostMapping("/process")
    public ModelAndView addEmployee(@ModelAttribute("employee") Employee employee) {
        Employee employee1 = employeeMethods.addEmployee(employee);
        return new ModelAndView(new RedirectView("/employee/" + employee1.getId()));

    }


}







