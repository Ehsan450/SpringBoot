package com.example.Employee.repository;

import com.example.Employee.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository {
    @Value("${database.url}")
    private String urlConnect;
    @Value("${database.username}")
    private String userId;
    @Value("${database.password}")
    private String password;

    public List<Employee> employeeInfo() {
        try (Connection connection = DriverManager.getConnection(this.urlConnect, this.userId, this.password)) {
            List<Employee> employees = new ArrayList<>();
            String query = "SELECT * FROM employee;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int salary = resultSet.getInt("salary");
                Date dateOfBirth=resultSet.getDate("dateOfBirth");
                Date joinningDate=resultSet.getDate("joinningDate");

                Employee employee = new Employee(id, firstName, lastName, salary,dateOfBirth,joinningDate);
                employees.add(employee);
            }
            return employees;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Employee> getById(int id) {
        try (Connection connection = DriverManager.getConnection(this.urlConnect, this.userId, this.password)) {
            //Employee employee=new Employee();
            String query = "Select * from employee where ID=" + id + ";";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println(resultSet);
            if (resultSet.next() == false)
                return Optional.empty();
            int employeeId = resultSet.getInt("ID");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int salary = resultSet.getInt("salary");
            Date dateOfBirth=resultSet.getDate("dateOfBirth");
            Date joinningDate=resultSet.getDate("joinningDate");

            Employee employee = new Employee(employeeId, firstName, lastName, salary,dateOfBirth , joinningDate);
            return Optional.of(employee);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public Employee save(Employee employee) {
        try (Connection connection = DriverManager.getConnection(this.urlConnect, this.userId, this.password)) {

            
            //Employee employee=new Employee();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee (id, first_name, last_name, salary, dateOfBirth, joinningDate) value " +
                    "(?, ?, ?, ?, ?, ?);");
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getFirst_name());
            preparedStatement.setString(3, employee.getLast_name());
            preparedStatement.setInt(4,employee.getSalary());
            preparedStatement.setDate(5, employee.getDateOfBirth());
            preparedStatement.setDate(6,employee.getJoinningDate());
            preparedStatement.execute();

            return employee;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
