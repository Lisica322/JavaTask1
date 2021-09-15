package main;

import java.io.IOException;


import static main.SortedWords.*;

public class Main {
    public static void main(String[] args) throws IOException {
                maxCounting(rewriteWords(readTheFileText(FilePathHP.pathReader())));
    }
}
