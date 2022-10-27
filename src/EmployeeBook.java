public class EmployeeBook {

    //Количество записей о сотрудниках (10 сотрудников)
    private final Employee[] employees = new Employee[10];

    public Employee[] getEmployees() {
        return employees;
    }

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
                    employees[i] = null;
                    MassiveManager.markers[i] = 0;
                    System.out.println("Запись о сотруднике с ФИО " + name + " успешно удалена");
                }
            } else {
                System.out.println("Запись о сотруднике с ФИО " + name + " не найдена!");
                System.out.println("Пожалуйста, уточните ФИО сотрудника.");
            }
        }
    }

    //Метод - просмотр всех сотрудников со всеми данными по сотруднику
    public void viewAllEmployees(Employee[] employees) {
        int counter = 0;
        System.out.println("Список сотрудников организации: ");
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

    //Метод - просмотра сотрудников по отделам
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

    //Метод - просмотр ФИО всех сотрудников
    public void viewFullNameList() {
        System.out.println("Список всех сотрудников (только ФИО):");
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
                System.out.println(employees[i].getFullName());
            }
        }
    }

    //Метод - расчет суммы затрат на зарплаты всей организации в месяц
    public void sumOfSalary() {
        System.out.println("Сведения о сумме всех зарплат в организации:");
        int counterOfEmployees = 0;
        int sumOfSalary = 0;
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
                sumOfSalary += employees[i].getSalary();
                counterOfEmployees++;
            }
        }
        if (counterOfEmployees > 0) {
            System.out.println("Сумма затрат на зарплату по всей организации = " + sumOfSalary);
        } else {
            System.out.println("Список сотрудников организации пуст.");
        }


    }

    //Метод - расчет средней зарплаты всех сотрудников
    public void averageSalary() {
        System.out.println("Сведения о средней зарплате в организации:");
        int counterOfEmployees = 0;
        int sumOfSalary = 0;
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
                sumOfSalary += employees[i].getSalary();
                counterOfEmployees++;
            }
        }
        if (counterOfEmployees > 0) {
            System.out.println("Средняя зарплата в организации = " + sumOfSalary / counterOfEmployees);
        } else {
            System.out.println("Список сотрудников организации пуст.");
        }

    }


    //Метод - индексация зарплаты
    public void salaryRecalculation(int percent) {
        int newSalary;
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
                newSalary = employees[i].getSalary() + employees[i].getSalary() * percent / 100;
                employees[i].setSalary(newSalary);
            }
        }
    }

    //Метод - поиск сотрудника с минимальной зарплатой
    public void findMinimalSalary() {
        int minSalary = 0;
        int indexEmployees = 0;
        //Ищем любую заполненную ячейку в массиве
        //Сохраняем размер зарплаты для дальнейшего использования
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
                minSalary = employees[i].getSalary();
            }
        }
        //Проходим по массиву, просматриваем только заполненные ячейки
        //Находим минимальное значение и сохраняем индекс ячейки, из которой взяли это значение
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
                if (employees[i].getSalary() < minSalary) {
                    minSalary = employees[i].getSalary();
                    indexEmployees = i;
                }
            }
        }
        //Выводим на экран данные о сотруднике с минимальной зарплатой
        //Или сообщаем о пустом списке сотрудников
        if (indexEmployees != 0) {
            System.out.println("Данные о сотруднике с минимальной зарплатой:");
            System.out.println(employees[indexEmployees].toString());
        } else {
            System.out.println("Список сотрудников организации пуст.");
            System.out.println("Сведения о сотруднике с минимальной зарплатой не могут быть представлены.");
        }
    }

    //Метод - поиск сотрудника с максимальной зарплатой
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
        //Проходим по массиву, просматриваем только заполненные ячейки
        //Находим максимальное значение и сохраняем индекс ячейки, из которой взяли это значение
        for (int i = 0; i < MassiveManager.markers.length; i++) {
            if (MassiveManager.markers[i] > 0) {
                if (employees[i].getSalary() > maxSalary) {
                    maxSalary = employees[i].getSalary();
                    indexEmployees = i;
                }
            }
        }
        //Выводим на экран данные о сотруднике с максимальной зарплатой
        //Или сообщаем о пустом списке сотрудников
        if (indexEmployees != 0) {
            System.out.println("Данные о сотруднике с максимальной зарплатой:");
            System.out.println(employees[indexEmployees].toString());
        } else {
            System.out.println("Список сотрудников организации пуст.");
            System.out.println("Сведения о сотруднике с максимальной зарплатой не могут быть представлены.");
        }
    }

    //Метод - расчет средней зарплаты по департаменту (в консоль выводятся все департаменты)
    public void averageSalaryByDepartment() {
        System.out.println("Сведения о средней зарплате по каждому департаменту:");
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
                System.out.println("Средняя зарплата сотрудников этого отдела = " + sumOfSalary / counterOfEmployees);
            }
            counterOfEmployees = 0;
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
                            ", зарплата: " + employees[i].getSalary() + " рублей");

                }
                counterOfEmployees++;
            }
        }
        if (counterOfEmployees == 0) {
            System.out.println("Список сотрудников пуст. Информация для отображения отсутсвует.");
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
                            ", зарплата: " + employees[i].getSalary() + " рублей");

                }
                counterOfEmployees++;
            }
        }
        if (counterOfEmployees == 0) {
            System.out.println("Список сотрудников пуст. Информация для отображения отсутсвует.");
        }
    }
}