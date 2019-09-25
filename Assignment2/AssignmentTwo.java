public class AssignmentTwo {

    /*
        This method should return the sum of salaries of employees having salary greater than 5000
        Note: Employee array is passed, not employee
     */
    public double salaryGreaterThanFiveThousand(Employee[] employees) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee.getSalary() > 5000) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }


    /*
        This method should print either "Fizz", "Buzz" or "FizzBuzz"
        "Fizz" - if id of employee is divisible by 3
        "Buzz" - if id of employee is divisible by 5
        "FizzBuzz" - if id of employee is divisible by both 3 and 5
     */
    public void fizzBuzz(Employee employee) {
        String print = "";
        if (employee.getId() % 3 == 0)
            print += "Fizz";
        if (employee.getId() % 5 == 0)
            print += "Buzz";
        System.out.println(print);
    }


    /*
        This method should calculate tax for an employee in dollars
        If salary of employee is less than or equal to 2500, tax should be 10%
        If salary of employee is greater than 2500 but less than or equal to 5000, tax should be 25%
        If salary of employee is greater than 5000, tax should be 35%
    */
    public double calculateTax(Employee employee) {
        double tax = 0;
        double salary = employee.getSalary();
        if (salary <= 2500) {
            tax = 0.1 * employee.getSalary();
        }
        if (5000 >= salary && salary > 2500) {
            tax = 0.1 * 2500 + 0.25 * (employee.getSalary() - 2500);
        }
        if (salary >= 5000) {
            tax = (employee.getSalary() - 5000) * 0.35 + 0.1 * 2500 + 0.25 * 2500;
        }
        return tax;
    }


    /*
        We are given two employee objects.
        Implement this method to swap salaries of employees
    */
    public void swap(Employee firstEmployee, Employee secondEmployee) {
        double salary = firstEmployee.getSalary();
        firstEmployee.setSalary(secondEmployee.getSalary());
        secondEmployee.setSalary(salary);
    }


    /*
        Return number of employees whose age is greater than 50
        Note: Employee array is passed, not employee
     */
    public int employeesAgeGreaterThan50(Employee[] employees) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getAge() > 50) {
                count++;
            }
        }
        return count;
    }


    /*
        Implement this method to reverse firstName of employee.
        Ex. Before: employee.getFirstName() -> "John"
        After : employee.getFirstName() -> "nhoJ"
     */
    public void reverseFirstName(Employee employee) {
        employee.setFirstName(new StringBuilder(employee.getFirstName()).reverse().toString());
    }


    /*
        Print "true" if employee's first name contain one or more digits
        Print "false" if employee's first name doesn't contain any digit
        Ex: employee.getFirstName() -> "ha8l" == true
        employee.getFirstName() -> "hail" == false
     */
    public void isContainDigit(Employee employee) {
        for (char ch : employee.getFirstName().toCharArray()) {
            //
            if (ch >= 'A' && ch <= 'Z')
                if (Character.isDigit(ch))
                    System.out.println("true");
        }
        System.out.println("false");
    }


    /*
       Write a method to raise an employee's salary to three times of his/her original salary.
       Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
       DO NOT change the input in this method.
       Try to add a new method in Employee class: public void raiseSalary(double byPercent)
       Call this new method.
    */
    public void tripleSalary(Employee employee) {
        employee.raiseSalary(300);
    }


    //Additional question for extra credit
    /*
        Implement this method to convert String[] to employees array.
        Ex: String[] employees = new String[]{"1,John,24,7500", "2,Hail,28,7899.90"};
        This String array of length 2 contains 2 employees in form of string, where
        id = 1
        firstName=John
        age=24
        salary=7500
        convert each string to employee object.
        Hint: Use String methods. Refer : https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
     */
    public Employee[] createEmployees(String[] employeesStr) {
        Employee[] employees = new Employee[employeesStr.length];
        for (int i = 0; i < employeesStr.length; i++) {
            employees[i] = transform(employeesStr[i]);
        }
        return employees;
    }

    // "1,John,24,7500"
    private Employee transform(String str) {
        String[] res = str.split(",");
        Employee employee = new Employee(Integer.parseInt(res[0]),
                res[1],
                Integer.parseInt(res[2]),
                Double.parseDouble(res[3]));
        return employee;
    }
}

