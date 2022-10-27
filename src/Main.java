public class Main {
    public static void main(String[] args) {
        System.out.println();

        EmployeeBook employeeBook = new EmployeeBook();


        //Заполняем массив данными из списков, указанных в классе DataForEmployee
        //ФИО, название департамента и зарплата выбираются случайным образом
        for (int i = 0; i < 10; i++) {
            employeeBook.addEmployeeToEmployeeBook(new Employee(DataForEmployee.selectFullName(),
                    DataForEmployee.selectSalary(),
                    DataForEmployee.selectDepartment()));
        }
        //Вызов метода - просмотр всех сотрудников организации с ФИО, зарплатой и ID
        employeeBook.viewAllEmployees(employeeBook.getEmployees());
        System.out.println();

        //Вызов метода - удаление сведенийо сотруднике по ID
        employeeBook.deleteEmployeeByID(5);
        System.out.println();

        //Посмотрим обновленный список сотрудников
        employeeBook.viewAllEmployees(employeeBook.getEmployees());

        //Добавим одного сотрудника с фиктивным ФИО для последующего удаления
        Employee emp_1 = new Employee("ABC", 10, "Бухгалтерия");
        employeeBook.addEmployeeToEmployeeBook(emp_1);
        System.out.println();

        //Посмотрим обновленный список сотрудников
        employeeBook.viewAllEmployees(employeeBook.getEmployees());
        System.out.println();

        //Вызов метода - удаление сведений о сотруднике по ФИО
        employeeBook.deleteEmployeeByFullName("ABC");
        System.out.println();

        //Посмотрим обновленный список сотрудников
        employeeBook.viewAllEmployees(employeeBook.getEmployees());
        System.out.println();

        //Вызов метода - просмотр сотрудников с группировкой по отделам
        employeeBook.viewEmployeesByDepartment();
        System.out.println();

        //Вызов метода - поиск сотрудника с минимальной зарплатой
        employeeBook.findMinimalSalary();
        System.out.println();

        //Вызов метода - поиск сотрудника с максимальной зарплатой
        employeeBook.findMaximalSalary();
        System.out.println();

        //Вызов метода - просмотр суммы зарплат по всем сотрудникам в организации
        employeeBook.sumOfSalary();
        System.out.println();

        //Вызов метода - просмотр средней зарплаты по всем сотрудникам в организации
        employeeBook.averageSalary();
        System.out.println();

        //Вызов метода - просмотр сведений о средней зарплате по департаменту
        employeeBook.averageSalaryByDepartment();
        System.out.println();

        //Вызов метода - просмотр только ФИО сотрудников организации
        employeeBook.viewFullNameList();
        System.out.println();

        //Вызов метода - поиск сотрудников с зарплатой, меньше чем указанная при вызове метода
        employeeBook.findSalaryLessThan(100000);
        System.out.println();

        //Вызов метода - поиск сотрудников с зарплатой, больше чем указанная при вызове метода
        employeeBook.findSalaryMoreThan(100000);

        //Вызов метода - индексация зарплаты всем сотрудникам на определенный %
        employeeBook.salaryRecalculation(5);

        //Посмотрим обновленный список сотрудников
        employeeBook.viewAllEmployees(employeeBook.getEmployees());
    }
}