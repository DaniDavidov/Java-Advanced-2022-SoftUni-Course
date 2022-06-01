package T06DefiningClassesExercises.E02CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Employee>> departments = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];

            Employee employee;
            switch (data.length) {
                case 6:
                    String email = data[4];
                    int age = Integer.parseInt(data[5]);
                     employee = new Employee(name, salary, position, department, email, age);
                    break;
                case 5:
                    if (data[4].contains("@")) {
                        email = data[4];
                        employee = new Employee(name, salary, position, department, email);
                    } else {
                        age = Integer.parseInt(data[4]);
                        employee = new Employee(name, salary, position, department, age);
                    }
                    break;
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + data.length);
            }
            departments.putIfAbsent(department, new ArrayList<>());
            departments.get(department).add(employee);
        }

        String maxAverageSalaryDepartment = departments.entrySet().stream()
                .max(Comparator.comparingDouble(department -> getAverageSalary(department.getValue())))
                .get()
                .getKey();

        System.out.println("Highest Average Salary: " + maxAverageSalaryDepartment);
        departments.get(maxAverageSalaryDepartment).stream()
                .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));
    }

    private static double getAverageSalary(List<Employee> employees) {
        double salary = 0;
        for (Employee employee : employees) {
            salary += employee.getSalary();
        }
        return salary / employees.size();
    }

}
