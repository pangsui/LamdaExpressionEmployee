package com.company;

import org.w3c.dom.events.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Employee pangsui = new Employee("Pangsui Usifu",30);
        Employee lingeh = new Employee("Lingeh Lukman", 29);
        Employee abubakar = new Employee("Abubakar Siddiq",35);
        Employee thalut = new Employee("Thalut Presido",28);
        Employee mahmud = new Employee("Mahmud Rashid",31);
        Employee hassan = new Employee("Mbiba Hassanou",33);
        Employee desmond = new Employee("Desmond Couch",21);
        Employee sherif = new Employee("Sherif Muhammed",19);

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(thalut);
        employees.add(pangsui);
        employees.add(lingeh);
        employees.add(mahmud);
        employees.add(abubakar);
        employees.add(sherif);
        employees.add(desmond);
        employees.add(hassan);

        printEmployeeByAge(employees,"Employee greater than 30",employee -> employee.getAge()>30);
        printEmployeeByAge(employees,"Employee less than or equal to thirty",employee -> employee.getAge()<=30);
        printEmployeeByAge(employees, "Employees less than 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });
        IntPredicate greaterthan15 = i -> i >= 25;
        IntPredicate lessThan100 = i -> i<100;
        int a = 23;
      boolean ans =  greaterthan15.test(12+a);
        System.out.println(ans);
        System.out.println(greaterthan15.and(lessThan100).test(50));

        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for (int i=0; i<10;i++){
            System.out.println(randomSupplier.get());
        }

        System.out.println("==================================================================");
       employees.forEach(employee -> {
           String lastName = employee.getName().substring(employee.getName().indexOf(' ') +1);
           System.out.println("lastName "+lastName);
       });
    }
    public static void printEmployeeByAge(List<Employee> employees, String ageText, Predicate<Employee> predicate){
        System.out.println(ageText);
        System.out.println("=================================");
        for (Employee employee:employees){
            if(predicate.test(employee)){
                System.out.println(employee.getName());
            }
        }
    }
}
