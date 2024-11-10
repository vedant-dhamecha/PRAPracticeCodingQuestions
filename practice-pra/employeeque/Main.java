import java.util.*;

class Project {
    private String projectName;
    private int rating;

    public Project(String projectName, int rating) {
        this.projectName = projectName;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}

class Employee {
    private int employeeId;
    private String employeeName;
    private String companyName;
    private int projectCount;
    private List<Project> projectList;

    public Employee(int employeeId, String employeeName, String companyName, int projectCount, List<Project> projectList) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.companyName = companyName;
        this.projectCount = projectCount;
        this.projectList = projectList;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    // Task 1: Get unique ratings for a given employee ID
    public static Set<Integer> getUniqueRatings(List<Employee> employees, int searchEmployeeId) {
        for (Employee emp : employees) {
            if (emp.getEmployeeId() == searchEmployeeId) {
                Set<Integer> uniqueRatings = new HashSet<>();
                for (Project proj : emp.getProjectList()) {
                    uniqueRatings.add(proj.getRating());
                }
                return uniqueRatings;
            }
        }
        System.out.println("No Employee Found");
        return Collections.emptySet();
    }

    // Task 2: Get employees with average rating above a given threshold
    public static List<String> getEmployeesAboveThreshold(List<Employee> employees, int threshold) {
        List<String> result = new ArrayList<>();
        for (Employee emp : employees) {
            int totalRating = 0;
            for (Project proj : emp.getProjectList()) {
                totalRating += proj.getRating();
            }
            double averageRating = emp.projectList.size() > 0 ? (double) totalRating / emp.projectList.size() : 0;
            if (averageRating > threshold) {
                result.add(emp.getEmployeeName());
            }
        }
        if (result.isEmpty()) {
            System.out.println("No Employee Found");
        }
        return result;
    }
}

// Sample input and output handling
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numEmployees = sc.nextInt();
        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < numEmployees; i++) {
            int employeeId = sc.nextInt();
            String employeeName = sc.next();
            String companyName = sc.next();
            int projectCount = sc.nextInt();
            List<Project> projectList = new ArrayList<>();

            for (int j = 0; j < projectCount; j++) {
                String projectName = sc.next();
                int rating = sc.nextInt();
                projectList.add(new Project(projectName, rating));
            }

            employeeList.add(new Employee(employeeId, employeeName, companyName, projectCount, projectList));
        }

        // Task 1: Print unique ratings for a given employee ID
        int searchEmployeeId = sc.nextInt();
        Set<Integer> uniqueRatings = Employee.getUniqueRatings(employeeList, searchEmployeeId);
        for (int rating : uniqueRatings) {
            System.out.println(rating);
        }

        // Task 2: Print names of employees with average rating above a given threshold
        int threshold = sc.nextInt();
        List<String> employeesAboveThreshold = Employee.getEmployeesAboveThreshold(employeeList, threshold);
        for (String name : employeesAboveThreshold) {
            System.out.println(name);
        }
        sc.close();
    }
}
