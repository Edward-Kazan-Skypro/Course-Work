import java.util.Objects;

public class Employee {

    private String fullName;
    private int salary;
    private int idEmployee;
    private String department;
    static int idCount = 1;

    public Employee(String fullName, int salary, String department) {
        if (checkInputData(fullName, salary, department)) {
            this.fullName = fullName;
            this.salary = salary;
            this.department = department;
            idEmployee = idCount++;
        }
    }

    public String getFullName() {
        return fullName;
    }

    public int getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public boolean checkInputData(String fullName, int salary, String department) {
        boolean checkData = false;
        boolean checkFullName = setFullName(fullName);
        boolean checkSalary = setSalary(salary);
        boolean checkDepartment = setDepartment(department);

        if (checkFullName & checkSalary & checkDepartment) {
            checkData = true;
        }
        return checkData;
    }

    public boolean setFullName(String fullName) {
        boolean checkFullName = false;

        if (fullName.length() > 0) {
            checkFullName = true;
        } else {
            System.out.println("ФИО не указано. Проверьте вводимые данные!");
        }
        return checkFullName;
    }

    public boolean setSalary(int salary) {
        boolean checkSalary = false;
        if (salary <= 0) {
            System.out.println("Заработная плата меньше или равна нулю. Проверьте вводимые данные!");
        } else {
            checkSalary = true;
        }
        return checkSalary;
    }

    public boolean setDepartment(String department) {
        boolean checkDepartment = false;
        for (int i = 0; i < DataForEmployee.departments.length; i++) {
            if (DataForEmployee.departments[i].equals(department)) {
                checkDepartment = true;
            }
        }
        if (!checkDepartment)
            System.out.println("Департамента - " + department + " - нет в организации." +
                    " Проверьте название департамента!");
        return checkDepartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getSalary() == employee.getSalary() &&
                idEmployee == employee.idEmployee &&
                Objects.equals(getFullName(),
                        employee.getFullName()) &&
                Objects.equals(getDepartment(),
                        employee.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullName(), getSalary(), idEmployee, getDepartment());
    }

    @Override
    public String toString() {
        return "Сотрудник: " +
                "ФИО - " + fullName +
                ", зарплата - " + salary +
                ", внутренний id - " + idEmployee;
    }
}