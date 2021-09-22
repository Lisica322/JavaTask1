import model.Companies;
import model.Result;
import model.Securities;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UtilMetods {
    public static List<Securities> getFilteringSecurities(Companies[] companies, Predicate<Securities> predicate) {
        return Stream.of(companies)
                .flatMap(c -> c.getSecurities().stream())
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static List<Companies> getFilteringCompanies(Companies[] companies, Predicate<Companies> predicate) {
        return Stream.of(companies)
                .filter(predicate)
                .collect(Collectors.toList());
    }
    public static void returnCodeAndIdByCurrency(Companies[] companies) throws IOException {
        System.out.println("Введите валюту для вывода id компании и code");
        BufferedReader readerFromKeyBoard = new BufferedReader(new InputStreamReader(System.in));
        String currency = readerFromKeyBoard.readLine();

        String id;
        ArrayList<Result> res = new ArrayList<>();
        for (Companies company : companies) {
            id = company.getId();
            List<String> securities2 =
                    getFilteringSecurities(companies, s -> s.getCurrency().contains(currency))
                            .stream().map(Securities::getCode).collect(Collectors.toList());
            res.add(new Result(id, securities2));
        }
        res.forEach(System.out::println);
        System.out.println("================== Конец вывода блока с валютами ===================== ");
    }
}
