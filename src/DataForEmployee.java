import java.util.Random;

//Данный класс добавлен для хранения списков ФИО и названий отделов (департаментов)
//Также, класс предоставляет методы выбора значений из списков для создания объекта класса Employee

public class DataForEmployee {

    static int bufferForIndexOfNames = 0;
    static String[] fullNames = {"Иванов Иван Иванович",
            "Петров Степан Борисович",
            "Савельева Мария Викторовна",
            "Егоров Иван Михайлович",
            "Сотова Светлана Андреевна",
            "Корытов Вячеслав Алексеевич",
            "Пушкин Александр Сергеевич",
            "Волкова Екатерина Ивановна",
            "Зайцев Сергей Юрьевич",
            "Сухов Андрей Борисович",
            "Солнцев Иван Геннадьевич",
    };
    static String[] departments = {"1", "2", "3", "4", "5"};

    //Первоначально, при написании программы использовал более привычные названия отделов
    //Но, согласно условиям курсовой "Отделы для простоты должны быть названы от 1 до 5."
    //Поэтому пусть будут безликие названия-цифры.
    /*static String[] departments = {"Бухгалтерия",
            "Правовой департамент",
            "Технический департамент",
            "АХО",
            "Секретариат",
    };*/


    //Метод - получения не совсем уникального ФИО из массива имен
    //Пока что получилось чтобы ФИО не дублировалось два раза подряд
    //Но в идеале хотелось бы, чтоб вообще повторов не было
    public static String selectFullName() {
        Random randomName = new Random();
        int currentIndexOfNames = randomName.nextInt(fullNames.length);
        if (bufferForIndexOfNames == currentIndexOfNames) {
            selectFullName();
        }
        return fullNames[currentIndexOfNames];
    }

    //Метод - получение случайным образом названия департамента
    //Повтор названия не критичен, дополнительной проверки нет
    public static String selectDepartment() {
        Random randomDepartment = new Random();
        int indexOfDepartment = randomDepartment.nextInt(departments.length);
        return departments[indexOfDepartment];
    }

    //Метод возвращает число в диапазоне от 0 до 100 000
    public static int selectSalary() {
        return new Random().nextInt(1000000);
    }
}