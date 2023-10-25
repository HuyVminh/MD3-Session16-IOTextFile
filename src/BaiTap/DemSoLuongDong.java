package BaiTap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DemSoLuongDong {
    public static void main(String[] args) {
        String filePath = "D://RA/Module03-JavaCore/Session16-IOTextFile/src/BaiTap/file.txt";
        int lineCount = countLines(filePath);
        System.out.println("Số lượng dòng trong file là "+lineCount);
    }
    private static int countLines(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int lineCount = 0;
            while (br.readLine() != null) {
                lineCount++;
            }
            return lineCount;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
