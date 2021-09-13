package main;

import java.io.IOException;

import static main.FilePathAdressesConst.FILE_PATH_POTTER;
import static main.SortedWords.*;

public class Main {
    public static void main(String[] args) throws IOException {
        readTheFileText(FILE_PATH_POTTER);
        wordStatistics(rewriteWords());
        maxCounting(rewriteWords());
    }
}
