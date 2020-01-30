package com.demo.Java8Snippets;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Base {
    public static void main(String[] args) {
        Employee employee1 = new Employee(100, "one");
        Employee employee2 = new Employee(200, "two");
        Employee employee3 = new Employee(300, "three");
        Employee employee4 = new Employee(400, "four");

        List<Employee> empList = Arrays.asList(employee1, employee2, employee3, employee4);

        //filter
        //Before Java 8
        List<Employee> output = new ArrayList<>();
        for (Employee emp : empList) {
            if (emp.getSalary() > 200) {
                output.add(emp);
            }
        }
        System.out.println(output.size());//2
        //Java 8
        List<Employee> emp1 = empList.stream().filter(emp -> emp.getSalary() > 200).collect(Collectors.toList());
        empList.stream().filter(emp -> emp.getSalary() > 200).collect(Collectors.toList());
        System.out.println(emp1.size());//2


        //Iterating a Map
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "odd");
        map.put(2, "even");
        map.put(3, "odd");
        map.put(4, "even");

        // Before Java 8
        List<String> listOfVal = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if ("even".equals(entry.getValue())) {
                listOfVal.add(entry.getValue());
            }
        }
        System.out.println("Before Java 8 : " + listOfVal);

        //Map -> Stream -> Filter -> String
        List<String> listOfEvenValues = map.entrySet().stream()
                .filter(m -> "even".equals(m.getValue()))
                .map(m -> m.getValue())
                .collect(Collectors.toList());

        System.out.println("With Java 8 : " + listOfEvenValues);

        Map<Integer, String> odd = map.entrySet()
                .stream()
                .filter(m -> m.getValue().equalsIgnoreCase("odd"))
                .collect(Collectors.toMap(m -> m.getKey(), m -> m.getValue()));


        //Map method
        //Before Java 8
        List<String> result = new ArrayList<>();
        for (Employee emp : empList) {
            result.add(emp.getName());
        }
        System.out.println(result); //one, two, three, four

        //Java 8
        List<String> collect = empList.stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println(collect); //one, two, three, four


        //FlatMap
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        //Before Java 8
        List<Integer> combinedList = new ArrayList<>(list1);
        combinedList.addAll(list2);
        System.out.println("Combined List" + combinedList);

        //Java 8
        List<Integer> list = Stream.of(list1, list2)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
        System.out.println("Combined List" + list);

        //For each
        map.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));

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
