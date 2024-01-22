package view;

import model.PersonalInfo;

import java.util.List;

public class InfoView {
    public void showMenu(){
        System.out.println("""
            Введите цифу, соответствующую пункту меню:
            1 - Ввод данных.
            2 - Прросмотр введенной информации.
            3 - Запись введенной информации в файл. Выход.                     \s
            """);
    }
    public void showMessage1(){
        System.out.println("Введите Фамилию Имя Отчество, строго по порядку");
    }

    public void showMessage2(){
        System.out.println("В произвольном порядке, через пробел, введите дату рождения в формате dd.mm.yyyy, +\n" +
                "номер телефона (11 цифр без знаков) и пол (f / m) ");
    }
    public void showEnteredData(List<PersonalInfo> personalInfo){
        System.out.println(personalInfo.toString());
    }
}
