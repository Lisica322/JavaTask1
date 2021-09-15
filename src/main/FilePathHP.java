package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FilePathHP {
    public static String pathReader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathFromKeyBoard = reader.readLine();
        return filePath(pathFromKeyBoard);
    }

    public static String filePath(String keyBoardWord) {
        return keyBoardWord;
    }

}
