package main;

import java.time.LocalDate;

public class FilePathAdressesConst {
    public static LocalDate today = LocalDate.now();
    public static final String FILE_PATH_POTTER = "src/main/harry_potter.txt";
    public static final String FILE_CHANGES_PATH_POTTER = "harry_potter_result_'" + today.toString() + "'.txt";
}
