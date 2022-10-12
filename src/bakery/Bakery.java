package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private final List<Employee> employees;
    private final String name;
    private final int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Employee getOldestEmployee() {
        Employee oldest = null;
        int maxAge = Integer.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee.getAge() > maxAge) {
                maxAge = employee.getAge();
                oldest = employee;
            }
        }
        return oldest;
    }

    public Employee getEmployee(String name) {
        Employee employeeToGet = null;
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employeeToGet = employee;
            }
        }
        return employeeToGet;
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s", name)).append(System.lineSeparator());
        for (Employee employee : employees) {
            sb.append(employee).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
