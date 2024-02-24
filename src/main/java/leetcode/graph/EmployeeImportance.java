package leetcode.graph;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeImportance {

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

    }

    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 5;
        e1.subordinates = Arrays.stream(new int[]{2,3}).boxed().collect(Collectors.toList());

        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;
        e2.subordinates = new ArrayList<>();

        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = 3;
        e3.subordinates = new ArrayList<>();

        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);

        int importance = getImportance(list,1);
        System.out.println(importance);

    }

    public static int getImportance(List<Employee> employees, int id) {

        int total = getTotalImportanceWithLookUp(employees, id, 0);
        return total;
    }

    private static int getTotalImportanceWithLookUp(List<Employee> employees, int id, int i) {
        Map<Integer, Employee> lookupMap = new HashMap<>();
        for(Employee employee: employees){
            lookupMap.put(employee.id, employee);
        }

        Employee targetEmployee = lookupMap.get(id);
        int total = targetEmployee.importance;
        for(Integer currentId: targetEmployee.subordinates){
            total += lookupMap.get(currentId).importance;
        }

        return total;
    }

    private static int getTotalImportance(List<Employee> employees, int id, int sum){
        Employee targetEmployee = getEmployeeWithID(employees, id);

        for(Integer nextId: targetEmployee.subordinates){
            sum = getTotalImportance(employees, nextId, sum);
        }
        return targetEmployee.importance + sum;
    }

    private static Employee getEmployeeWithID(List<Employee> employees, int id){
        for(Employee employee: employees){
            if(employee.id == id){
                return employee;
            }
        }
        return null;
    }

}
