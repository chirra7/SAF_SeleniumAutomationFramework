package Config.Utilities;

import java.io.*;
import java.util.ArrayList;

public class FlatFileWork {
    public boolean createFile(String path) {
        File fileObj = new File(path);
        if (!fileObj.exists()) {
            try {
                fileObj.createNewFile();
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public void appendTextToFile(String filePath, String appendText) {
        try {
            File file = new File(filePath);
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            br.write("\n" + appendText);
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void appendTextToFile(String filePath, ArrayList<String> appendText) {
        try {
            File file = new File(filePath);
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            for (String line : appendText)
                br.write("\n" + line);
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getFileData(String filePath) {
        ArrayList<String> fileData_AL = new ArrayList<String>();
        File file = new File(filePath);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null)
                fileData_AL.add(line);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return fileData_AL;
    }

    public void createAndDataWriteIntoFile(String filePath, ArrayList<String> writeData) {
        try {
            File file = new File(filePath);
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String outputLine : writeData)
                bw.write(outputLine + "\n");
            if (bw != null)
                bw.close();
            if (fw != null)
                fw.close();
        } catch (IOException e) {
        }
    }
}