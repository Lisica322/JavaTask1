package main;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static main.FilePathAdressesConst.FILE_CHANGES_PATH_POTTER;

public class SortedWords {

    public static String[] readTheFileText(String firstFilePath) throws IOException {
        Path path = Paths.get(firstFilePath);
        String cont;

        cont = String.valueOf
                (Files.readAllLines(path)).
                toLowerCase();

        String[] split = cont.split("\\s+");

        Arrays.sort(split);
        return split;
    }

    public static ArrayList<String> rewriteWords() {
        ArrayList<String> listPart = new ArrayList<>();
        ArrayList<String> resultList = new ArrayList<>();
        try {
            Collections.addAll(listPart, readTheFileText(FILE_CHANGES_PATH_POTTER));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : listPart) {
            resultList.add(s.replaceAll("[^a-z^A-Z]", ""));
            for (int i = 0; i < resultList.size(); i++) {
                resultList.removeIf(e -> e.equals(""));
            }
        }
        try {
            try (FileWriter writer = new FileWriter(FILE_CHANGES_PATH_POTTER)) {
                for (String news : resultList) {
                    writer.write(news + System.getProperty("line.separator"));
                }
            }
        } catch (IOException e) {
            System.out.println("Не удалось записать данные в файл");
        }
        return resultList;
    }

    public static Map<String, Long> wordStatistics(ArrayList<String> incomeList) {
        Map<String, Long> frequency =
                incomeList
                        .stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        frequency.forEach((k, v) -> System.out.println(k + ": " + v));
        return frequency;
    }

    public static void maxCounting(ArrayList<String> incomeList) {
        System.out.println("Статистика: ");
        Map<String, Long> statsMap = wordStatistics(incomeList);
        System.out.println("Слова с максимальным кол-вом повторений:");
        int max = 0;
        TreeMap<String, Long> mapMax = new TreeMap<>();
        for (Map.Entry<String, Long> pair : statsMap.entrySet()) {
            if (pair.getValue() >= max) {
                if (pair.getValue() > max) {
                    max = Math.toIntExact(pair.getValue());
                    mapMax.clear();
                }
                mapMax.put(pair.getKey(), pair.getValue());
            }
        }
        for (Map.Entry<String, Long> pair : mapMax.entrySet()) {
            System.out.println(pair.getKey() + " повторяется: " + pair.getValue());
        }
    }
}
