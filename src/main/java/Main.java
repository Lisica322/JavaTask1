import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import model.Companies;
import model.Securities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        try (JsonReader reader = new JsonReader(new BufferedReader(new InputStreamReader(new FileInputStream("src/companies.json"), "UTF-8")))) {

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new UniversalDates())
                    .create();

            Companies[] companies = gson.fromJson(reader, Companies[].class);

            System.out.println("Введите дату в формате dd/MM/YYYY или dd/MM/YY или dd.MM.YY или dd.MM.YYYY ");
            BufferedReader inputData = new BufferedReader(new InputStreamReader(System.in));
            String dataFormat = inputData.readLine();

            Stream.of(companies)
                    .forEach(company ->
                            System.out.println(
                                    String.join(
                                            "",
                                            "'",
                                            company.getNameCompany(),
                                            "' - '",
                                            company.getFormatedFounded(dataFormat), "'")));

            List<Securities> securities =
                    UtilMetods.getFilteringSecurities(companies, s -> s.getDate().isBefore(LocalDate.now()));

            UtilMetods.returnCodeAndIdByCurrency(companies);

            System.out.println("Количество компаний до текущей даты " + securities.size());

            securities.forEach(System.out::println);

            LocalDate foundationDate = LocalDate
                    .now()
                    .minusYears(46);

            System.out.println("======================================================");
            List<Companies> companiesByFoundationDate = UtilMetods.getFilteringCompanies(companies, c -> c.getFounded().isAfter(foundationDate));

            companiesByFoundationDate.forEach(System.out::println);
        }
    }
}