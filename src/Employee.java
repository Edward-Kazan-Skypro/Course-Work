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

    public static boolean checkInputData(String fullName, int salary, String department) {
        boolean checkData = false;
        boolean checkFullName = checkFullName(fullName);
        boolean checkSalary = checkSalary(salary);
        boolean checkDepartment = checkDepartment(department);

        if (checkFullName & checkSalary & checkDepartment) {
            checkData = true;
        }
        return checkData;
    }

    public static boolean checkFullName(String fullName) {
        boolean checkFullName = false;

        if (fullName.length() > 0) {
            checkFullName = true;
        } else {
            System.out.println("ФИО не указано. Проверьте вводимые данные!");
        }
        return checkFullName;
    }

    public static boolean checkSalary(int salary) {
        boolean checkSalary = false;
        if (salary <= 0) {
            System.out.println("Заработная плата меньше или равна нулю. Проверьте вводимые данные!");
        } else {
            checkSalary = true;
        }
        return checkSalary;
    }

    public static boolean checkDepartment(String department) {
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

    public void setFullName(String fullName){
        if (checkFullName(fullName)) this.fullName = fullName;
    }

    public void setSalary (int salary) {
        if (checkSalary(salary)) this.salary = salary;
    }

    public void setDepartment(String department) {
        if (checkDepartment(department)) this.department = department;

    }

    @Override
    public String toString() {
        return "Сотрудник: " +
                "ФИО - " + fullName +
                ", зарплата - " + salary +
                ", внутренний id - " + idEmployee;
    }
}