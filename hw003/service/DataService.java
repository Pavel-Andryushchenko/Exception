package service;

import model.PersonalInfo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DataService {
    List<PersonalInfo> personalInfoList = new ArrayList<>();

    public void createPersonalInfo(String fullName, String otherData) {
        String date = null;
        String phone = null;
        String sex = null;
        for (String s : otherData.split(" ")) {
            if (isPhone(s)) {
                phone = s;
            }
            if (isSex(s)) {
                sex = s;
            }
            if (isDate(s)) {
                date = s;
            }
        }
        date += " " + phone + " " + sex;
        personalInfoList.add(new PersonalInfo(fullName, date));

    }

    public int[] checkFIO(String fio) {
        String[] fioArray = fio.split(" ");
        if (fioArray.length != 3) return new int[]{1, fioArray.length};
        for (String s : fioArray) {
            if (!s.matches("[а-яА-Я]+")) {
                return new int[]{2};
            }
        }
        return new int[]{0};
    }

    public int[] checkOtherData(String otherData) {
        String[] otherDataArray = otherData.split(" ");
        if (otherDataArray.length != 3) return new int[]{1, otherDataArray.length};
        String date = null;
        String phone = null;
        String sex = null;
        for (String s : otherDataArray) {
            if (isSex(s)) {
                sex = s;
            }
            if (isPhone(s)) {
                phone = s;
            }
            if (isDate(s)) {
                date = s;
            }
        }
        if (date == null) return new int[]{2};
        if (phone == null) return new int[]{3};
        if (sex == null) return new int[]{4};
        return new int[]{0};
    }

    private boolean isSex(String s) {
        return s.length() == 1 && (s.equalsIgnoreCase("f") || s.equalsIgnoreCase("m"));
    }

    private boolean isPhone(String s) {
        return (s.length() == 11 && s.matches("[0-9]+"));
    }

    private boolean isDate(String s) {
        return s.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
    }
    public List<PersonalInfo> getPersonalInfoList() {
        return personalInfoList;
    }
}
