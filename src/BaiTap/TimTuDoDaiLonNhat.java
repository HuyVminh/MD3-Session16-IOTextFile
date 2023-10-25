package BaiTap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TimTuDoDaiLonNhat {
    public static void main(String[] args) {
        String filePath = "D://RA/Module03-JavaCore/Session16-IOTextFile/src/BaiTap/file.txt";
        String[] words = readWords(filePath);
        List<String> longestWords = findLongestWords(words);
        System.out.println("Các từ có độ dài lớn nhất trong file là:");
        for (String word : longestWords) {
            System.out.println(word + " (" + word.length() + " ký tự)");
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

    private static List<String> findLongestWords(String[] words) {
        List<String> longestWords = new ArrayList<>();
        int maxLength = 0;
        for (String word : words) {
            int length = word.length();
            if (length > maxLength) {
                maxLength = length;
                longestWords.clear();
                longestWords.add(word);
            } else if (length == maxLength) {
                longestWords.add(word);
            }
        }
        return longestWords;
    }
}
