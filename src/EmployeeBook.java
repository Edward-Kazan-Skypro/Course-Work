public class EmployeeBook {

    //Количество записей о сотрудниках (10 сотрудников)
    private final Employee[] employees = new Employee[10];

    int counterOfEmployees = 0;
    int minSalary = 0;
    int maxSalary = 0;
    int indexEmployees = 0;

    int sumOfSalary = 0;

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //
    // Глобальные методы - добавление в массив, удаление из массива по ФИО и ID, просмотр всех записей в массиве,
    //расчет общих финансовых показателей (минимальная, максимальная, средняя и общая зарплата).
    //
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    //Метод - просмотр всех сотрудников со всеми данными по каждому сотруднику
    public void viewAllEmployees() {
        int counterOfEmployees = 0;
        System.out.println("Список всех сотрудников организации: ");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].toString());
                counterOfEmployees++;
            }
        }
        if (counterOfEmployees == 0) {
            System.out.println("Список сотрудников организации пуст.");
        }
    }

    //Метод - просмотр всех сотрудников с разбивкой по отделам
    public void viewEmployeesByDepartment() {
        System.out.println("Список сотрудников по отделам:");
        counterOfEmployees = 0;
        for (int j = 0; j < DataForEmployee.departments.length; j++) {
            System.out.println("Отдел: " + DataForEmployee.departments[j]);
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null) {
                    if (employees[i].getDepartment().equals(DataForEmployee.departments[j])) {
                        System.out.println(employees[i].toString());
                        counterOfEmployees++;
                    }
                }
            }
            if (counterOfEmployees == 0) System.out.println("В данном отделе нет сотрудников");
            counterOfEmployees = 0;
        }
    }

    //Метод - просмотр только ФИО всех сотрудников по всей организации
    public void viewFullNameList() {
        System.out.println("Список всех сотрудников (только ФИО):");
        counterOfEmployees = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getFullName());
                counterOfEmployees++;
            }
        }
        if (!(counterOfEmployees > 0)) {
            System.out.println("Список сотрудников организации пуст. Информация для отображения отсутствует.");
        }
    }

    //Метод - расчет суммы затрат на зарплаты всей организации в месяц
    public void sumOfSalary() {
        System.out.print("Сведения о сумме всех зарплат в организации: ");
        counterOfEmployees = 0;
        int sumOfSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sumOfSalary += employees[i].getSalary();
                counterOfEmployees++;
            }
        }
        if (counterOfEmployees > 0) {
            System.out.println("Сумма затрат на зарплату по всей организации = " + sumOfSalary + " рублей.");
        } else {
            System.out.println("Список сотрудников организации пуст. Информация для отображения отсутствует.");
        }
    }

    //Метод - расчет средней зарплаты всех сотрудников по всей организации
    public void averageSalary() {
        System.out.print("Сведения о средней зарплате в организации: ");
        counterOfEmployees = 0;
        int sumOfSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sumOfSalary += employees[i].getSalary();
                counterOfEmployees++;
            }
        }
        if (counterOfEmployees > 0) {
            System.out.println("Средняя зарплата в организации = " + sumOfSalary / counterOfEmployees + " рублей.");
        } else {
            System.out.println("Список сотрудников организации пуст. Информация для отображения отсутствует.");
        }
    }

    //Метод - расчет средней зарплаты по департаментам (в консоль выводятся все департаменты)
    public void averageAllSalaryByDepartment() {
        System.out.println("Сведения о средней зарплате по каждому отделу организации:");
        counterOfEmployees = 0;
        double sumOfSalary = 0;
        for (int j = 0; j < DataForEmployee.departments.length; j++) {
            System.out.println("Отдел: " + DataForEmployee.departments[j]);
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null) {
                    if (employees[i].getDepartment().equals(DataForEmployee.departments[j])) {
                        sumOfSalary += employees[i].getSalary();
                        counterOfEmployees++;
                    }
                }
            }
            if (sumOfSalary > 0) {
                System.out.println("Средняя зарплата сотрудников этого отдела = " + sumOfSalary / counterOfEmployees + " рублей.");
            } else {
                System.out.println("В данном отделе нет сотрудников");
            }
            counterOfEmployees = 0;
            sumOfSalary = 0;
        }
    }

    //Метод - поиск сотрудника с минимальной зарплатой по всей организации
    public void findMinimalSalary() {
        int minSalary = 0;
        int indexEmployees = 0;
        //Ищем первую непустую ячейку для присвоения minSalary какого-либо значения
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                minSalary = employees[i].getSalary();
                i = employees.length;
            }
        }

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() < minSalary) {
                    minSalary = employees[i].getSalary();
                    indexEmployees = i;
                }
            }
        }
        System.out.println("minSalary = " + minSalary);
        //Выводим на экран данные о сотруднике с минимальной зарплатой.
        //Или сообщаем о пустом списке сотрудников
        if (minSalary > 0) {
            System.out.print("Данные о сотруднике с минимальной зарплатой: ");
            System.out.println(employees[indexEmployees].toString());
        } else {
            System.out.println("Список сотрудников организации пуст.");
            System.out.println("Сведения о сотруднике с минимальной зарплатой не могут быть представлены.");
        }
    }

    //Метод - поиск сотрудника с максимальной зарплатой по всей организации
    public void findMaximalSalary() {
        int maxSalary = 0;
        int indexEmployees = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() > maxSalary) {
                    maxSalary = employees[i].getSalary();
                    indexEmployees = i;
                }
            }
        }
        if (maxSalary > 0) {
            System.out.print("Данные о сотруднике с максимальной зарплатой: ");
            System.out.println(employees[indexEmployees].toString());
        } else {
            System.out.println("Список сотрудников организации пуст.");
            System.out.println("Сведения о сотруднике с максимальной зарплатой не могут быть представлены.");
        }
    }

    //Метод - поиск сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль)
    public void findSalaryLessThan(int number) {
        counterOfEmployees = 0;
        System.out.println("Список сотрудников с зарплатой, меньше чем " + number + " рублей:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() < number) {
                    System.out.println("id сотрудника: " + employees[i].getIdEmployee() +
                            ", ФИО сотрудника: " + employees[i].getFullName() +
                            ", зарплата: " + employees[i].getSalary() + " рублей.");
                }
            }
            counterOfEmployees++;
            if (counterOfEmployees == 0) {
                System.out.println("Список сотрудников пуст. Информация для отображения отсутствует.");
            }
        }
    }

    //Метод - поиск сотрудников с зарплатой больше числа (вывести id, Ф. И. О. и зарплатой в консоль)
    public void findSalaryMoreThan(int number) {
        counterOfEmployees = 0;
        System.out.println("Список сотрудников с зарплатой, больше чем " + number + " рублей:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() > number) {
                    System.out.println("id сотрудника: " + employees[i].getIdEmployee() +
                            ", ФИО сотрудника: " + employees[i].getFullName() +
                            ", зарплата: " + employees[i].getSalary() + " рублей.");
                }
            }
            counterOfEmployees++;
        }
        if (counterOfEmployees == 0) {
            System.out.println("Список сотрудников пуст. Информация для отображения отсутствует.");
        }
    }

    //Метод - индексация зарплаты всех сотрудников на величину, задаваемую параметром percent (%)
    public void allSalaryRecalculation(int percent) {
        int newSalary;
        counterOfEmployees = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                newSalary = employees[i].getSalary() + employees[i].getSalary() * percent / 100;
                employees[i].setSalary(newSalary);
                counterOfEmployees++;
            }
        }
        if (counterOfEmployees == 0) {
            System.out.println("Список сотрудников пуст.");
            System.out.println("Индексация зарплаты не рассчитана.");
        } else {
            System.out.println("Индексация зарплат всех сотрудников на " + percent + "% произведена.");
        }
    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //
    // Методы, отображающие информацию по указанному отделу.
    //
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    //Метод - отображение списка сотрудников указанного отдела
    public void viewEmployeesByDepartment(String department) {
        System.out.println("Сведения о сотрудниках департамента: " + department);
        counterOfEmployees = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment().equals(department)) {
                    System.out.println(employees[i].toString());
                    counterOfEmployees++;
                }
            }
        }
        if (counterOfEmployees == 0) {
            System.out.println("Список сотрудников организации пуст.");
            System.out.println("Сведения не могут быть представлены.");
        }
    }

    //Метод - поиск сотрудника с минимальной зарплатой по заданному отделу
    public void findMinimalSalaryByDepartment(String department) {
        System.out.println("Сведения о сотруднике с минимальной зарплатой по департаменту: " + department);
        minSalary = 0;
        indexEmployees = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                minSalary = employees[i].getSalary();
                i = employees.length;
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment().equals(department)) {
                    if (employees[i].getSalary() < minSalary) {
                        minSalary = employees[i].getSalary();
                        indexEmployees = i;
                    }
                }
            }
        }
        //Выводим на экран данные о сотруднике с минимальной зарплатой.
        //Или сообщаем о пустом списке сотрудников
        if (minSalary > 0) {
            System.out.println(employees[indexEmployees].toString());
        } else {
            System.out.println("Список сотрудников организации пуст.");
            System.out.println("Сведения о сотруднике с минимальной зарплатой не могут быть представлены.");
        }
    }

    //Метод - поиск сотрудника с максимальной зарплатой по заданному отделу
    public void findMaximalSalaryByDepartment(String department) {
        System.out.println("Сведения о сотруднике с максимальной зарплатой по департаменту: " + department);
        maxSalary = 0;
        indexEmployees = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment().equals(department)) {
                    if (employees[i].getSalary() > maxSalary) {
                        maxSalary = employees[i].getSalary();
                        indexEmployees = i;
                    }
                }
            }
        }
        //Выводим на экран данные о сотруднике с максимальной зарплатой.
        //Или сообщаем о пустом списке сотрудников
        if (maxSalary != 0) {
            System.out.println(employees[indexEmployees].toString());
        } else {
            System.out.print("Список сотрудников организации пуст.");
            System.out.println("Сведения о сотруднике с максимальной зарплатой не могут быть представлены.");
        }
    }

    //Метод - расчет средней зарплаты по заданному отделу
    public void averageSalaryByDepartment(String department) {
        System.out.println("Сведения о средней зарплате по департаменту: " + department);
        counterOfEmployees = 0;
        double sumOfSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment().equals(department)) {
                    sumOfSalary += employees[i].getSalary();
                    counterOfEmployees++;
                }
            }
        }
        if (sumOfSalary > 0) {
            System.out.println("Средняя зарплата сотрудников этого отдела = " + sumOfSalary / counterOfEmployees + " рублей.");
        } else {
            System.out.println("В данном отделе нет сотрудников");
        }
    }

    //Метод - расчет зарплаты сотрудников по заданному отделу
    public void sumOfSalaryByDepartment(String department) {
        System.out.println("Сведения о сумме затрат на зарплату по департаменту: " + department);
        sumOfSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment().equals(department)) {
                    sumOfSalary += employees[i].getSalary();
                }
            }
        }
        if (sumOfSalary > 0) {
            System.out.println("Сумма затрат на зарплату по департаменту = " + sumOfSalary + " рублей.");
        } else {
            System.out.println("Сведения о сумме затрат на зарплату по департаменту не могут быть представлены.");
        }
    }

    //Метод - индексация зарплаты сотрудников отдела (надо указать) на величину, задаваемую параметром percent (%)
    public void salaryRecalculationByDepartment(String department, int percent) {
        int newSalary;
        counterOfEmployees = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment().equals(department)) {
                    newSalary = employees[i].getSalary() + employees[i].getSalary() * percent / 100;
                    employees[i].setSalary(newSalary);
                    counterOfEmployees++;
                }
            }
        }
        if (counterOfEmployees == 0) {
            System.out.println("Индексация зарплаты о отделу не рассчитана.");
        }
    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //
    // Методы, изменяющие данные по выбранному сотруднику - удаление (по ФИО и ID), добавление нового
    // и изменение (по ФИО) зарплаты и отдела
    //
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    //Метод - удаление записи о сотруднике по ID
    public void deleteEmployeeByID(int id) {
        boolean checkDeleteEmployee = false;
        System.out.println("Внимание! Будут удалены сведения по сотруднику с ID " + id);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getIdEmployee() == id) {
                    employees[i] = null;
                    i = employees.length;
                    checkDeleteEmployee = true;
                }
            }
        }
        if (checkDeleteEmployee) {
            System.out.println("Запись о сотруднике с ID " + id + " успешно удалена");
        } else {
            System.out.println("Запись о сотруднике с ID " + id + " не найдена!");
            System.out.println("Пожалуйста, уточните ID сотрудника.");
        }
    }

    //Метод - удаление записи о сотруднике по ФИО
    public void deleteEmployeeByFullName(String name) {
        boolean checkDeleteEmployee = false;
        System.out.println("Внимание! Будут удалены сведения по сотруднику с ФИО " + name);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getFullName().equals(name)) {
                    employees[i] = null;
                    i = employees.length;
                    checkDeleteEmployee = true;
                }
            }
        }
        if (checkDeleteEmployee) {
            System.out.println("Запись о сотруднике с ФИО " + name + " успешно удалена");
        } else {
            System.out.println("Запись о сотруднике с ФИО " + name + " не найдена!");
            System.out.println("Пожалуйста, уточните ФИО сотрудника.");
        }
    }

    //Метод - добавление сведений о новом сотруднике
    public void addNewEmployee(String fullName, int salary, String department) {

        boolean checkName = Employee.checkFullName(fullName);
        boolean checkSalary = Employee.checkSalary(salary);
        boolean checkDepartment = Employee.checkDepartment(department);
        if (checkName & checkSalary & checkDepartment) {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] == null) {
                    employees[i] = new Employee(fullName, salary, department);
                    System.out.println("Сведения по сотруднику добавлены!");
                    i = employees.length;
                }
            }
        }
    }

    //Метод - изменение сведений о сотруднике (сотрудника выбираем по ФИО)
    public void editEmployeeByName(String fullName, int salary, String department) {
        int oldSalary = 0;
        String oldDepartment = "";
        boolean checkEdit = false;
        System.out.println("Изменение данных о сотруднике: " + fullName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getFullName().equals(fullName) & Employee.checkDepartment(department)) {
                    oldSalary = employees[i].getSalary();
                    oldDepartment = employees[i].getDepartment();
                    employees[i].setSalary(salary);
                    employees[i].setDepartment(department);
                    checkEdit = true;
                }
            }
        }
        if (checkEdit) {
            System.out.println("Обновленные данные по сотруднику:");
            System.out.println("Размер зарплаты с " + oldSalary + " изменен на " + salary);
            System.out.println("Отдел с " + oldDepartment + " изменен на " + department);
        } else {
            System.out.println("Замена не удалась!");
            System.out.println("Сотрудник с ФИО " + fullName + " не найден.");
            System.out.println("Проверьте вводимые ФИО и название отдела.");
        }
    }
}