import controller.Controller;
import service.MyException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyException {
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);
        while (true){
            controller.showMenu();
            String enteredData = scanner.next();
            switch (enteredData){
                case ("1"):
                    controller.inpootPersonalInfo();
                    break;
                case ("2"):
                    controller.showEnteredData();
                    break;
                case ("3"):
                    break;
                default:
                    System.out.println("Повторите попытку");
                    break;
            }
            if(enteredData.equals("3")) {break;}
        }
    }
}

