public class EmployeeBook {

    //Количество записей о сотрудниках (10 сотрудников)
    private final Employee[] employees = new Employee[10];

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //
    // Глобальные методы - добавление в массив, удаление из массива по ФИО и ID, просмотр всех записей в массиве,
    //расчет общих финансовых показателей (минимальная, максимальная, средняя и общая зарплата).
    //
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    //Метод - добавление записи о сотруднике в список сотрудников (в массив)
    public void addEmployeeToEmployeeBook(Employee employee) {
        int sumOfMarkers = 0;
        int positionIndexForWrite;
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            sumOfMarkers += MassiveManager.markers[i];
        }
        if (sumOfMarkers >= MassiveManager.markers.length) {
            System.out.println("Внимание ! Список сотрудников заполнен");
            System.out.println("Данные о новом сотруднике: " + employee.toString() + " не внесены.");
            System.out.println("Пожалуйста, выберите и удалите запись о уже внесенном сотруднике!");
        } else {
            positionIndexForWrite = MassiveManager.findFreeIndex();
            employees[positionIndexForWrite] = employee;
            MassiveManager.markers[positionIndexForWrite] = 1;
        }
    }

    //Метод - просмотр всех сотрудников со всеми данными по каждому сотруднику
    public void viewAllEmployees() {
        int counter = 0;
        System.out.println("Список всех сотрудников организации: ");
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
                System.out.println(employees[i].toString());
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("Список сотрудников организации пуст.");
        }
    }

    //Метод - просмотр всех сотрудников с разбивкой по отделам
    public void viewEmployeesByDepartment() {
        System.out.println("Список сотрудников по отделам:");
        int counterOfEmployees = 0;
        for (int j = 0; j < DataForEmployee.departments.length; j++) {
            System.out.println("Отдел: " + DataForEmployee.departments[j]);

            for (int i = 0; i < MassiveManager.markers.length; i++) {
                if (MassiveManager.markers[i] > 0) {
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
        int counterOfEmployees = 0;
        System.out.println("Список всех сотрудников (только ФИО):");
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
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
        int counterOfEmployees = 0;
        int sumOfSalary = 0;
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
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
        int counterOfEmployees = 0;
        int sumOfSalary = 0;
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
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
        int counterOfEmployees = 0;
        double sumOfSalary = 0;
        for (int j = 0; j < DataForEmployee.departments.length; j++) {
            System.out.println("Отдел: " + DataForEmployee.departments[j]);

            for (int i = 0; i < MassiveManager.markers.length; i++) {
                if (MassiveManager.markers[i] > 0) {

                    if (employees[i].getDepartment().equals(DataForEmployee.departments[j])) {
                        sumOfSalary += employees[i].getSalary();
                        counterOfEmployees++;
                    }
                }
            }
            if (counterOfEmployees == 0) {
                System.out.println("В данном отделе нет сотрудников");
            } else {
                System.out.println("Средняя зарплата сотрудников этого отдела = " + sumOfSalary / counterOfEmployees + " рублей.");
            }
            counterOfEmployees = 0;
        }
    }

    //Метод - поиск сотрудника с минимальной зарплатой по всей организации
    public void findMinimalSalary() {
        int minSalary = 0;
        int indexEmployees = 0;
        //Ищем любую заполненную ячейку в массиве.
        //Сохраняем размер зарплаты для дальнейшего использования
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
                minSalary = employees[i].getSalary();
            }
        }
        //Проходим по массиву, просматриваем только заполненные ячейки.
        //Находим минимальное значение и сохраняем индекс ячейки, из которой взяли это значение
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
                if (employees[i].getSalary() < minSalary) {
                    minSalary = employees[i].getSalary();
                    indexEmployees = i;
                }
            }
        }
        //Выводим на экран данные о сотруднике с минимальной зарплатой.
        //Или сообщаем о пустом списке сотрудников
        if (indexEmployees != 0) {
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
        //Ищем любую заполненную ячейку в массиве
        //Сохраняем размер зарплаты для дальнейшего использования
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
                maxSalary = employees[i].getSalary();
            }
        }
        //Проходим по массиву, просматриваем только заполненные ячейки.
        //Находим максимальное значение и сохраняем индекс ячейки, из которой взяли это значение
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
                if (employees[i].getSalary() > maxSalary) {
                    maxSalary = employees[i].getSalary();
                    indexEmployees = i;
                }
            }
        }
        //Выводим на экран данные о сотруднике с максимальной зарплатой.
        //Или сообщаем о пустом списке сотрудников
        if (maxSalary != 0) {
            System.out.print("Данные о сотруднике с максимальной зарплатой: ");
            System.out.println(employees[indexEmployees].toString());
        } else {
            System.out.println("Список сотрудников организации пуст.");
            System.out.println("Сведения о сотруднике с максимальной зарплатой не могут быть представлены.");
        }
    }

    //Метод - поиск сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль)
    public void findSalaryLessThan(int number) {
        int counterOfEmployees = 0;
        System.out.println("Список сотрудников с зарплатой, меньше чем " + number + " рублей:");

        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
                if (employees[i].getSalary() < number) {
                    System.out.println("id сотрудника: " + employees[i].getIdEmployee() +
                            ", ФИО сотрудника: " + employees[i].getFullName() +
                            ", зарплата: " + employees[i].getSalary() + " рублей.");
                }
                counterOfEmployees++;
            }
        }
        if (counterOfEmployees == 0) {
            System.out.println("Список сотрудников пуст. Информация для отображения отсутствует.");
        }
    }

    //Метод - поиск сотрудников с зарплатой больше числа (вывести id, Ф. И. О. и зарплатой в консоль)
    public void findSalaryMoreThan(int number) {
        int counterOfEmployees = 0;
        System.out.println("Список сотрудников с зарплатой, больше чем " + number + " рублей");

        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
                if (employees[i].getSalary() > number) {
                    System.out.println("id сотрудника: " + employees[i].getIdEmployee() +
                            ", ФИО сотрудника: " + employees[i].getFullName() +
                            ", зарплата: " + employees[i].getSalary() + " рублей.");
                }
                counterOfEmployees++;
            }
        }
        if (counterOfEmployees == 0) {
            System.out.println("Список сотрудников пуст. Информация для отображения отсутствует.");
        }
    }

    //Метод - индексация зарплаты всех сотрудников на величину, задаваемую параметром percent (%)
    public void allSalaryRecalculation(int percent) {
        int newSalary;
        int counterOfEmployees = 0;
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
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
        int counterOfEmployees = 0;
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if ((MassiveManager.markers[i] > 0) & (employees[i].getDepartment().equals(department))) {
                System.out.println(employees[i].toString());
                counterOfEmployees++;
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
        int minSalary = 0;
        int indexEmployees = 0;
        //Ищем любую заполненную ячейку в массиве.
        //Сохраняем размер зарплаты для дальнейшего использования
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
                minSalary = employees[i].getSalary();
            }
        }
        //Проходим по массиву, просматриваем только заполненные ячейки.
        //И проверяем данные по заданному названию департамента.
        //Находим минимальное значение и сохраняем индекс ячейки, из которой взяли это значение
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
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
        if (minSalary != 0) {
            System.out.println(employees[indexEmployees].toString());
        } else {
            System.out.println("Список сотрудников организации пуст.");
            System.out.println("Сведения о сотруднике с минимальной зарплатой не могут быть представлены.");
        }
    }

    //Метод - поиск сотрудника с максимальной зарплатой по заданному отделу
    public void findMaximalSalaryByDepartment(String department) {
        System.out.println("Сведения о сотруднике с максимальной зарплатой по департаменту: " + department);
        int maxSalary = 0;
        int indexEmployees = 0;
        //Ищем любую заполненную ячейку в массиве.
        //Сохраняем размер зарплаты для дальнейшего использования
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
                maxSalary = employees[i].getSalary();
            }
        }
        //Проходим по массиву, просматриваем только заполненные ячейки.
        //И проверяем данные по заданному названию департамента.
        //Находим максимальное значение и сохраняем индекс ячейки, из которой взяли это значение
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
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
        int counterOfEmployees = 0;
        double sumOfSalary = 0;
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if ((MassiveManager.markers[i] > 0) & (employees[i].getDepartment().equals(department))) {
                sumOfSalary += employees[i].getSalary();
                counterOfEmployees++;
            }
        }

        if (counterOfEmployees == 0) {
            System.out.println("В данном отделе нет сотрудников");
        } else {
            System.out.println("Средняя зарплата сотрудников этого отдела = " + sumOfSalary / counterOfEmployees + " рублей.");
        }
    }

    //Метод - расчет зарплаты сотрудников по заданному отделу
    public void sumOfSalaryByDepartment(String department) {
        System.out.println("Сведения о сумме затрат на зарплату по департаменту: " + department);
        int sumOfSalary = 0;
        int indexEmployees = 0;
        //Проходим по массиву, просматриваем только заполненные ячейки.
        //И проверяем данные по заданному названию департамента.
        //Находим минимальное значение и сохраняем индекс ячейки, из которой взяли это значение
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if ((MassiveManager.markers[i] > 0) & (employees[i].getDepartment().equals(department))) {
                sumOfSalary += employees[i].getSalary();
                indexEmployees = i;
            }
        }
        //Выводим на экран данные о сотруднике с максимальной зарплатой.
        //Или сообщаем о пустом списке сотрудников
        if (indexEmployees != 0) {
            System.out.println("Сумма затрат на зарплату по департаменту = " + sumOfSalary + " рублей.");
        } else {
            System.out.println("Список сотрудников организации пуст.");
            System.out.println("Сведения о сумме затрат на зарплату по департаменту не могут быть представлены.");
        }
    }

    //Метод - индексация зарплаты сотрудников отдела (надо указать) на величину, задаваемую параметром percent (%)
    public void salaryRecalculationByDepartment(String department, int percent) {
        int newSalary;
        int counterOfEmployees = 0;
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if ((MassiveManager.markers[i] > 0) & (employees[i].getDepartment().equals(department))) {
                newSalary = employees[i].getSalary() + employees[i].getSalary() * percent / 100;
                employees[i].setSalary(newSalary);
                counterOfEmployees++;
            }
        }
        if (counterOfEmployees == 0) {
            //System.out.println("Список сотрудников пуст.");
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
        System.out.println("Внимание! Будут удалены сведения по сотруднику с ID " + id);
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
                if (employees[i].getIdEmployee() == id) {
                    employees[i] = null;
                    MassiveManager.markers[i] = 0;
                    System.out.println("Запись о сотруднике с ID " + id + " успешно удалена");
                }
            } else {
                System.out.println("Запись о сотруднике с ID " + id + " не найдена!");
                System.out.println("Пожалуйста, уточните ID сотрудника.");
            }
        }
    }

    //Метод - удаление записи о сотруднике по ФИО
    public void deleteEmployeeByFullName(String name) {
        System.out.println("Внимание! Будут удалены сведения по сотруднику с ФИО " + name);
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
                if (employees[i].getFullName().equals(name)) {
                    MassiveManager.markers[i] = 0;
                    System.out.println("Запись о сотруднике с ФИО " + name + " успешно удалена");
                }
            } else {
                System.out.println("Запись о сотруднике с ФИО " + name + " не найдена!");
                System.out.println("Пожалуйста, уточните ФИО сотрудника.");
            }
        }
    }

    //Метод - добавление сведений о новом сотруднике
    public void addNewEmployee(String fullName, int salary, String department) {
        int indexForWrite = 0;
        boolean free = false;
        //Ищем пустую ячейку (номер индекса в массиве markers) для записи
        //Если пустых ячеек нет, то выводится сообщение о невозможности добавить сведения
        System.out.println("Внимание! Идет проверка по добавлению новых сведений по сотруднику:");
        System.out.println("ФИО: " + fullName + ", зарплата: " + salary + ", департамент: " + department);
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] == 0) {
                indexForWrite = i;
                i = MassiveManager.markers.length;
                free = true;
                }
        }
        if (!free) {
            System.out.println("Ошибка! Список заполнен! Добавление сведений не удалось.");
        }
        //Теперь проверяем полученные данные
        boolean checkName = Employee.checkFullName(fullName);
        boolean checkSalary = Employee.checkSalary(salary);
        boolean checkDepartment = Employee.checkDepartment(department);
        if (checkName & checkSalary & checkDepartment) {
            //Создаем объект Employee и сохраняем его в массиве
            employees[indexForWrite] = new Employee(fullName, salary, department);
            //Ячейку в массиве markers отмечаем как занятую
            MassiveManager.markers[indexForWrite] = 1;
            System.out.println("Сведения по сотруднику добавлены!");
        }

    }

    //Метод - изменение сведений о сотруднике (сотрудника выбираем по ФИО)
    public void editEmployeeByName(String fullName, int salary, String department) {
        System.out.println("Изменение данных о сотруднике: " + fullName);
        boolean failToAdd = true;
        int oldSalary;
        String oldDepartment;
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] == 1
                    & employees[i].getFullName().equals(fullName)
                    & Employee.checkDepartment(department)) //Проверка департамента
            {
                oldSalary = employees[i].getSalary();
                oldDepartment = employees[i].getDepartment();
                employees[i].setSalary(salary);
                employees[i].setDepartment(department);
                failToAdd = false;
                i = MassiveManager.markers.length;
                System.out.println("Обновленные данные по сотруднику:");
                System.out.println("Размер зарплаты с " + oldSalary + " изменен на " + salary);
                System.out.println("Отдел с " + oldDepartment + " изменен на " + department);
            }
        }
        if (failToAdd) {
            System.out.println("Замена не удалась!");
            System.out.println("Сотрудник с ФИО " + fullName + " не найден.");
            System.out.println("Проверьте вводимые ФИО и название отдела.");
        }
    }

}