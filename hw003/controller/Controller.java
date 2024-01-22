package controller;

import service.DataService;
import service.MyException;
import service.WriteFile;
import view.InfoView;
import java.util.Scanner;

public class Controller {
    private final Scanner scanner = new Scanner(System.in);
    private final InfoView informationView = new InfoView();
    private final DataService dataService = new DataService();
    private final WriteFile writeFile = new WriteFile();

    public void showMenu(){informationView.showMenu();}
    public void inpootPersonalInfo() throws MyException {
        try {
            informationView.showMessage1();
            String fio = scanner.nextLine();
            if (dataService.checkFIO(fio)[0] == 1) throw new MyException("ФИО должно содержать 3 слова, вы ввели " + dataService.checkFIO(fio)[1]);
            if(dataService.checkFIO(fio)[0] == 2) throw new MyException("Используйте только кирилицу!");
            informationView.showMessage2();
            String otherDate = scanner.nextLine();
            if (dataService.checkOtherData(otherDate)[0] == 1) throw new MyException("Необходимо ввести 3 параметра, вы ввели " + dataService.checkOtherData(otherDate)[1]);
            if (dataService.checkOtherData(otherDate)[0] == 2) throw new MyException("Неверно введена дата");
            if (dataService.checkOtherData(otherDate)[0] == 3) throw new MyException("Неверно введен телефон");
            if (dataService.checkOtherData(otherDate)[0] == 4) throw new MyException("Неверно введен пол");
            dataService.createPersonalInfo(fio, otherDate);
            writeFile.recordInfo(dataService.getPersonalInfoList().getLast());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

    }

    public void showEnteredData(){
        informationView.showEnteredData(dataService.getPersonalInfoList());
    }


}
