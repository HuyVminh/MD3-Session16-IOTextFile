package BaiTap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HienThiTuTrungLap {
    public static void main(String[] args) {
        String filePath = "D://RA/Module03-JavaCore/Session16-IOTextFile/src/BaiTap/file.txt";
        List<String> duplicateWords = findDuplicateWords(filePath);
        System.out.println("Các từ trùng lặp trong file là: " + duplicateWords);
    }

    private static List<String> findDuplicateWords(String filePath) {
        Map<String, Integer> wordCount = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> duplicateWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                duplicateWords.add(entry.getKey());
            }
        }
        return duplicateWords;
    }
}