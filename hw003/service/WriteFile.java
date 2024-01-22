package service;
import model.PersonalInfo;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public void recordInfo(PersonalInfo selectedInfo){
        String s = selectedInfo.getFullName().split(" ")[0];
        try(FileWriter fileWriter = new FileWriter(s, true)) {
            fileWriter.write(selectedInfo.toString() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
