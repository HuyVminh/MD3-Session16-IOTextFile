package BaiTap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class SapXepTheoBangChuCai {
    public static void main(String[] args) {
        String filePath = "D://RA/Module03-JavaCore/Session16-IOTextFile/src/BaiTap/file.txt";
        String[] words = readWords(filePath);
        Arrays.sort(words);
        System.out.println("Các từ trong file được sắp xếp theo thứ tự bảng chữ cái là:");
        for (String word : words) {
            System.out.println(word);
        }
    }

    private static String[] readWords(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(" ");
            }
            return sb.toString().split("\\s+");
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
    }
}
