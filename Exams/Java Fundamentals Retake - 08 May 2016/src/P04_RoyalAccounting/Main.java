package P04_RoyalAccounting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String regexPattern = "^([a-zA-Z]+)\\;(\\-?\\d+)\\;(\\-?\\d+\\.?\\d*)\\;([a-zA-Z]+)$";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Employee>> teams = new HashMap<>();

        String line;
        while (!"Pishi kuf i da si hodim".equals(line = reader.readLine())) {
            String[] tokens = regexMatcher(line);

            if (inputIsNullOrEmpty(tokens)) {
                continue;
            }

            String employeeName = tokens[0];
            Long workHoursPerDay = Long.parseLong(tokens[1]);
            Double dailyPayment = Double.parseDouble(tokens[2]);
            String teamName = tokens[3];

            Employee employee = new Employee(employeeName, workHoursPerDay, dailyPayment);
            if (!teams.containsKey(teamName)) {
                List<Employee> employees = new ArrayList<>();
                employees.add(employee);
                teams.put(teamName, employees);
            } else {
                List<Employee> employees = teams.get(teamName);

                if (!checkIfEmplContainsName(employees, employeeName)) {
                    employees.add(employee);
                }
            }

        }

        Comparator<Map.Entry<String, List<Employee>>> orderByEmployeesMontlySalary = (e1, e2) -> {
            List<Employee> employees1 = e1.getValue();
            List<Employee> employees2 = e2.getValue();

            double sum1 = employees1.stream().mapToDouble(Employee::getMontlyIncome).sum();
            double sum2 = employees2.stream().mapToDouble(Employee::getMontlyIncome).sum();

            return Double.compare(sum2, sum1);
        };


        teams.entrySet().stream()
                .sorted(orderByEmployeesMontlySalary)
                .forEach(entity -> {
                    StringBuilder sb = new StringBuilder("Team - ").append(entity.getKey()).append(System.lineSeparator());

                    List<Employee> sortedEmps = entity.getValue();
                    sortedEmps.sort((x1, x2) -> {
                        long workHrs1 = x1.getWorkHours();
                        long workHrs2 = x2.getWorkHours();

                        int comp1 = Long.compare(workHrs2, workHrs1);
                        if (comp1 != 0) {
                            return comp1;
                        }

                        Double dailyIncome1 = x1.getDailyIncome();
                        Double dailyIncome2 = x2.getDailyIncome();

                        int comp2 = Double.compare(dailyIncome2, dailyIncome1);
                        if (comp2 != 0) {
                            return comp2;
                        }

                        String name1 = x1.getName();
                        String name2 = x2.getName();

                        return name1.compareTo(name2);
                    });

                    DecimalFormat df = new DecimalFormat("0.000000");
                    for (int i = 0; i < sortedEmps.size(); i++) {
                        String name = sortedEmps.get(i).getName();
                        Long workHours = sortedEmps.get(i).getWorkHours();
                        Double dailyIncome = sortedEmps.get(i).getDailyIncome();
                        sb.append(String.format("$$$%s - %d - %s", name, workHours, df.format(dailyIncome))).append(System.lineSeparator());
                    }

                    System.out.print(sb);
                });
    }

    private static boolean checkIfEmplContainsName(List<Employee> employees, String employeeName) {
        for (Employee employee : employees) {
            if (employee.getName().equals(employeeName)) {
                return true;
            }
        }
        return false;
    }


    private static boolean inputIsNullOrEmpty(String[] tokens) {
        return tokens[0] == null || tokens[1] == null || tokens[2] == null || tokens[3] == null ||
                tokens[0].isEmpty() || tokens[1].isEmpty() || tokens[2].isEmpty() || tokens[3].isEmpty();
    }

    private static String[] regexMatcher(String line) {
        String[] input = new String[4];

        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            if (matcher.groupCount() != 4) {
                return input;
            }

            String employeeName = matcher.group(1).trim();
            String workHoursPerDay = matcher.group(2).trim();
            String dailyPayment = matcher.group(3).trim();
            String teamName = matcher.group(4).trim();

            input[0] = employeeName;
            input[1] = workHoursPerDay;
            input[2] = dailyPayment;
            input[3] = teamName;
        }

        return input;
    }
}

class Employee {
    private String name;
    private Long workHours;
    private Double dailyPayment;

    private Double dailyIncome;
    private Double montlyIncome;

    Employee(String name, Long workHours, Double dailyPayment) {
        this.name = name;
        this.workHours = workHours;
        this.dailyPayment = dailyPayment;
        this.dailyIncome = calcDailyIncome();
        this.montlyIncome = calcMontlyIncome();
    }

    private Double calcDailyIncome() {
        return (this.dailyPayment * this.workHours) / 24;
    }

    private Double calcMontlyIncome() {
        return this.calcDailyIncome() * 30;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }

    public Double getMontlyIncome() {
        return montlyIncome;
    }

    public Long getWorkHours() {
        return workHours;
    }

    public String getName() {
        return name;
    }
}


