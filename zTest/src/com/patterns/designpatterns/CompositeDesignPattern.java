package com.patterns.designpatterns;

import java.util.ArrayList;
import java.util.List;

interface Employee {
    public void showEmployeesDetails();
}

class Developer implements Employee {

    private int employeeId;
    private String name;
    private String designation;

    public Developer(int employeeId, String name, String designation) {
        super();
        this.employeeId = employeeId;
        this.name = name;
        this.designation = designation;
    }

    @Override
    public void showEmployeesDetails() {
        System.out.println("Developer [employeeId=" + employeeId + ", name=" + name + ", designation=" + designation + "]");
    }
}

class Manager implements Employee {

    private int employeeId;
    private String name;
    private String designation;
    private int age;

    public Manager(int employeeId, String name, String designation, int age) {
        super();
        this.employeeId = employeeId;
        this.name = name;
        this.designation = designation;
        this.age = age;
    }

    @Override
    public void showEmployeesDetails() {
        System.out.println("Manager [employeeId=" + employeeId + ", name=" + name + ", designation=" + designation + ", age=" + age + "]");
    }
}

class CompositeCompanyDirectory implements Employee {

    List<Employee> employeeList = new ArrayList<>();

    @Override
    public void showEmployeesDetails() {
        for (Employee employee : employeeList) {
            employee.showEmployeesDetails();
        }
    }

    public void add(Employee emp) {
        employeeList.add(emp);
    }

    public void remove(Employee emp) {
        employeeList.remove(emp);
    }
}

public class CompositeDesignPattern {

    public static void main(String[] args) {

        Developer developer1 = new Developer(12, "Mahesh", "Developer");
        Developer developer2 = new Developer(1, "Suresh", "Developer");
        CompositeCompanyDirectory devCompanyDirectory = new CompositeCompanyDirectory();
        devCompanyDirectory.add(developer1);
        devCompanyDirectory.add(developer2);

        Manager manager1 = new Manager(1, "Prakash", "Manager", 50);
        Manager manager2 = new Manager(1, "Surya Prakash", "Manager", 55);
        CompositeCompanyDirectory manCompanyDirectory = new CompositeCompanyDirectory();
        manCompanyDirectory.add(manager1);
        manCompanyDirectory.add(manager2);

        CompositeCompanyDirectory groupDirectory = new CompositeCompanyDirectory();
        groupDirectory.add(devCompanyDirectory);
        groupDirectory.add(manCompanyDirectory);
        groupDirectory.showEmployeesDetails();
    }
}
