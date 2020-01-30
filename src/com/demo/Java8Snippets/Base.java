package com.demo.Java8Snippets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Base {
    public static void main(String[] args) {
        Employee employee1 = new Employee(100, "one");
        Employee employee2 = new Employee(200, "two");
        Employee employee3 = new Employee(300, "three");
        Employee employee4 = new Employee(400, "four");

        List<Employee> empList = Arrays.asList(employee1,employee2,employee3,employee4);

        //filter
        //Before Java 8
        List<Employee> output = new ArrayList<>();
        for (Employee emp : empList){
            if(emp.getSalary()>200){
                output.add(emp);
            }
        }
        System.out.println(output.size());//2
        //Java 8
        List< Employee> emp1 = empList.stream().filter(emp -> emp.getSalary()>200).collect(Collectors.toList());
        System.out.println(emp1.size());//2



        //Map
        //Before Java 8
        List<String> result = new ArrayList<>();
        for (Employee emp : empList) {
            result.add(emp.getName());
        }
        System.out.println(result); //one, two, three, four

        //Java 8
        List<String> collect = empList.stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println(collect); //one, two, three, four

    }


}

class Employee {

    public Employee(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }
    private int salary;
    private String name;

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}
