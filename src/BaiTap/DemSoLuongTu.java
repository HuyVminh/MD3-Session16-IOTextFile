package BaiTap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DemSoLuongTu {
    public static void main(String[] args) {
        String filePath = "D://RA/Module03-JavaCore/Session16-IOTextFile/src/BaiTap/file.txt";
        int wordCount = countWords(filePath);
        System.out.println("Số lượng từ trong file là "+wordCount);
    }

    private static int countWords(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int wordCount = 0;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
            return wordCount;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
