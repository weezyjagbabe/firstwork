/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author graybeard86
 */
public class Employee  {

    private String empID;
    private String name;
    private int age;
    private double salary;
    
//    @Override
//    public int compare(Employee emp1, Employee emp2) {
//        return (int) (emp1.getSalary() - emp2.getSalary());
//    }
    
    public Employee(String empID, String name, int age, double salary){
        this.empID = empID;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "empID=" + empID + ", name=" + name + ", age=" + age + ", salary=" + salary + '}';
    }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Employee me; 
        int select=0;
        ArrayList<Employee> arrlist = new ArrayList<Employee>();
        while(select!= 5){
        System.out.println("Please select an Option");
        System.out.println(".............................................");
        System.out.println("*********************************************");
        System.out.println("(1) Add Employee");
        System.out.println("(2) Delete Employee");
        System.out.println("(3) Show all Employees");
        System.out.println("(4) Sort all Employees in ascending order of salary");
        System.out.println("(5) Quit Application");
        System.out.println(".............................................");
        System.out.println("*********************************************");
        Scanner scan = new Scanner(System.in);
        System.out.print("Input Choice:");
        while (!scan.hasNextInt()) {
        System.out.println("That's not a valid choice!");
        System.out.print("Input Choice:");
        scan.next(); 
         }
        select = scan.nextInt();
         
        switch (select){
            case 1:
                int entry = 0;
                int count = 0;
                do{
                System.out.print("Please input employee id of new employee eg. (AB000):");
                String empID = scan.next();
                System.out.print("Please input employee's name eg. (James):");
                String name = scan.next();
                System.out.print("Please input employee's age eg. (18):");
                int age = scan.nextInt();
                System.out.print("Please input employee's salary eg. (0.00):");
                double salary = scan.nextDouble();
                me = new Employee(empID,name,age,salary);
                arrlist.add(me);
                count++;
                System.out.println(".............................................");
                System.out.println(count+" Employee(s) added successfully");
                System.out.println(".............................................");
                System.out.println("Do you want to add another employee???");
                System.out.println("(0) NO");
                System.out.println("(1) YES");
                System.out.print("Input 0 or 1: ");
                entry = scan.nextInt();
                }while(entry == 1);
                System.out.println();
                System.out.println();
                break;
                
            case 2:
                System.out.print("Please input employee ID to delete employee eg. (AB000):");
                String empid = scan.next();
                Iterator<Employee> em = arrlist.iterator();
		int countD = 0;
		while(em.hasNext())
		{
			if(empid.equals(em.next().empID)){
                            em.remove();
                            countD++;
                        }
                        
                        
		}
                System.out.println(countD +" Employee(s) deleted successfully");
                System.out.println(".............................................");
                System.out.println("*********************************************");
                System.out.println();
                System.out.println();
                break;
            case 3:
                Iterator<Employee> ditr = arrlist.iterator();
                System.out.println();
                System.out.println();
                System.out.println("Complete Employee List");
                System.out.println(".............................................");
                System.out.println("*********************************************");
		
		while(ditr.hasNext())
		{
			System.out.println(ditr.next());
                        

		}
                System.out.println(".............................................");
                System.out.println("*********************************************");
                 System.out.println();
                System.out.println();
                break;
            case 4:
                Iterator<Employee> dit = arrlist.iterator();
                List<Employee> listEmployees = new ArrayList<Employee>();
		
		while(dit.hasNext())
		{
			listEmployees.add(dit.next());
                        
		}
                Collections.sort(listEmployees, new EmployeeSalaryComparator());
                System.out.println();
                System.out.println();
                System.out.println("Sorted in ascending order of salary");
                System.out.println(".............................................");
                System.out.println("*********************************************");
                Iterator<Employee> must =listEmployees.iterator();
                while(must.hasNext())
                {
                    System.out.println(must.next());
                }
                System.out.println(".............................................");
                System.out.println("*********************************************");
                System.out.println();
                System.out.println();
                break;
            case 5:
                System.out.println();
                System.out.println();
                System.out.println("Exitted Successfully!!!");
                break;
//            default:
//                System.out.println("You have entered an invalid option ");
		
                
                
                }
           
        }
       
    }
    
}
