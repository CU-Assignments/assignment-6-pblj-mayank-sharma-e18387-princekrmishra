import java.util.*;

public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, 50000),
            new Employee("Bob", 25, 60000),
            new Employee("Charlie", 28, 45000)
        );

        System.out.println("Sorted by Name:");
        employees.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);

        System.out.println("\nSorted by Age:");
        employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).forEach(System.out::println);

        System.out.println("\nSorted by Salary:");
        employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).forEach(System.out::println);
    }
}
