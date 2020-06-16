package by.zapolski.englishphrases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class MainTest {

    public void test() throws IOException {
        List<String> list = Files.lines(Paths.get("D:/ideaProjects/english-phrases/src/main/resources/model/Frequency_60000.txt"))
                .collect(Collectors.toList());

        int i = 0;
        while (i <= list.size() - 1) {
            String tmp = list.get(i).replaceAll("\\p{Cntrl}", "").replace("\uFEFF", "");
            if (!tmp.isEmpty() && !tmp.contains("[")) {
                i = i + 2;
                String rank = list.get(i);
                rank = rank.substring(20);
                rank = rank.substring(0,rank.indexOf("["));
                i = i + 1;
                String pos = list.get(i);
                pos = pos.substring(19, 20);

                String result = tmp + ";" + pos + ";" + rank;
                System.out.println(result);
            }
            i++;
        }

    }


    public static void main(String[] args) throws IOException {
        MainTest mainTest = new MainTest();
        mainTest.test();
    }


}
