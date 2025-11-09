import java.util.Scanner;
import java.util.spi.CalendarDataProvider;

class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InvalidPriceException extends Exception {
    public InvalidPriceException(String message) {
        super(message);
    }
}

class Solution {

    // Sum of Digits
    public static int sum(int num) {
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    // Multiplication Table
    public static void multiplication(int num){
        for(int i=1;i<=10;i++){
            System.out.print(num * i + " ");
        }
    }

    // Factorial Calculator
    public static int factorial(int num){
        int fact = 1;
        for(int i=num;i<=1;i++){
            fact *= num;
        }
        return fact;
    }

    // Reverse a Number
    public static int reverseNo(int num){
        int revNo = 0;
        while(num > 0){
            int temp = num % 10;
            revNo = revNo * 10 + temp;
            num /= 10;
        }

        return revNo;
    }

    //Simple Calculator
    static class Calculator{
        int a;
        int b;

        Calculator(int a, int b){
            this.a = a;
            this.b = b;
        }

        public static int add(int a, int b){
            return a+b;
        }

        public static int sub(int a, int b){
            return a-b;
        }

        public static long mul(int a, int b){
            return (long) a*b;
        }

        public static float div(int a, int b){
            return (float) a/b;
        }
    }

    //Student Report
    static class Student{
        String name;
        int mathMark;
        int chemMark;
        int engMark;

        Student(String name, int mathMark, int chemMark, int engMark){
            this.name = name;
            this.mathMark = mathMark;
            this.chemMark = chemMark;
            this.engMark = engMark;
        }

        public static int total(int mathMark, int chemMark, int engMark){
            return mathMark+chemMark+engMark;
        }

        public static float avgMark(int mathMark, int chemMark, int engMark) {
            return (float) (mathMark + chemMark + engMark) / 3;
        }
    }

    // Bank Account
    static class BankAccount{
        long accNo;
        String holderName;
        long balance;

        BankAccount(long accNo, String holderName, long balance){
            this.accNo = accNo;
            this.holderName = holderName;
            this.balance = balance;
        }
    }

    // Parameterized Constructor
    static class Book{
        String title;
        String author;
        int price;

        Book(String title, String author, int price){
            this.title = title;
            this.author = author;
            this.price = price;
        }
    }

    // Constructor Overloading
    static class Car{
        String modelName;
        int price;

        Car(String modelName){
            this.modelName = modelName;
        }

        Car(String modelName, int price){
            this.modelName = modelName;
            this.price = price;
        }
    }

    // Division with Exception
    public static void divWithExp(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numerator: ");
        int a = sc.nextInt();
        System.out.print("Enter denominator: ");
        int b = sc.nextInt();

        try{
            int result = a/b;
            System.out.println(result);
        }
       catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Division Completed");
        }
    }

    // Nested try-catch
    public static void print(int[] arr){
        try{
            for(int i=0;i<=arr.length;i++){
                System.out.println(arr[i]);
            }
            try{
                int a = 10;
                int b = 0;

            }catch(ArithmeticException e){
                System.out.println(e.getMessage());
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    // Exception Propagation (Method Chain)
    public static void m1(){
        try{
            System.out.println("m1 is called");
            m2();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void m2(){
        System.out.println("m2 is called");
        m3();
    }

    public static void m3(){
        int x = 10/0;
        System.out.println(x);
    }

    // Custom Exception: Invalid Email Exception
    public static void validateEmail(String email) throws InvalidEmailException{
        if(!email.contains("@")){
            throw new InvalidEmailException("Invalid email must contain '@'");
        }
        else{
            System.out.println(email);
        }
    }

    // Customer POJO
    static class Customer{
        int id;
        String name;
        String email;

        Customer(int id, String name, String email){
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getEmail() { return email; }

        // toString
        @Override
        public String toString() {
            return "Customer ID: " + id + ", Name: " + name + ", Email: " + email;
        }
    }

    // Mini Banking Application
    static class BankAccount2{
        static int totalAccount;
        private double balance;

        public void deposit(double amount) throws InvalidAmountException{
            if(amount == 0){
                throw new InvalidAmountException("amount must be greater than 0");
            }
            balance += amount;
        }

        public void withDraw(double amount) throws InsufficientFundsException{
            if(amount > balance){
                throw new InsufficientFundsException("Insufficient fund");
            }
            balance -= amount;
        }

        public void getBalance(){
            System.out.println(balance);
        }
    }

    // Employee Management System
    static class Employee{
        protected int id;
        protected String name;
        protected double baseSalary;

        Employee(int id, String name, double baseSalary) {
            this.id = id;
            this.name = name;
            this.baseSalary = baseSalary;
        }

        public double calculateSalary(){
            return baseSalary;
        }
    }

    static class FullTimeEmployee extends Employee{
        final double bonus;

        public FullTimeEmployee(int id, String name, double baseSalary, double bonus) {
            super(id, name, baseSalary);
            this.bonus = bonus;
        }

        // Override salary calculation
        @Override
        public double calculateSalary() {
            return baseSalary + bonus;
        }
    }

    static class PartTimeEmployee extends Employee{
        private int hoursWorked;
        private double hourlyRate;

        PartTimeEmployee(int id, String name, double hourlyRate, int hoursWorked) {
            super(id, name, 0); // baseSalary not needed here
            this.hourlyRate = hourlyRate;
            this.hoursWorked = hoursWorked;
        }

        // Override salary calculation
        @Override
        public double calculateSalary() {
            return hourlyRate * hoursWorked;
        }
    }


    // Product Catalog (with Encapsulation & Exceptions)
    static class Product{
        private int id;
        private String name;
        private int price;

        Product(int id, String name, int price) throws InvalidPriceException{
            this.id = id;
            this.name = name;
            setPrice(price);
        }

        public void setPrice(int price) throws InvalidPriceException{
            if(price < 0){
                throw new InvalidPriceException("Price cannot be negative");
            }

            this.price = price;
        }
    }


    public static void main(String[] args){
        System.out.println("Solutions of Java");

    }
}
