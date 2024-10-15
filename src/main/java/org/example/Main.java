package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {

    private static Map<Integer, Employee> employeeMap;

    private static List<Employee> duplicatedEmployees;

    public static void main(String[] args) {

        System.out.println(WordCounter.calculatedWord());

    }

    public static List<Employee> findDuplicates(List<Employee> employees){
        employeeMap = new HashMap<>();
        duplicatedEmployees = new LinkedList<>();
        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee == null){
                System.out.println("null record");
                continue;
            }
            if (employeeMap.containsKey(employee.getId())){
                duplicatedEmployees.add(employee);

            }else{
                employeeMap.put(employee.getId(),employee);
            }
        }
        return duplicatedEmployees;

    }


    public static Map<Integer,Employee> findUniques(List<Employee> employees){
        employeeMap = new HashMap<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee == null){
                System.out.println("null record");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())){
                employeeMap.put(employee.getId(),employee);

            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees){

        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer ,Employee> tekler = findUniques(employees);

        List<Employee> sadeceTekler = new LinkedList<>(tekler.values());

        sadeceTekler.removeAll(duplicates);

        return sadeceTekler;



    }




}