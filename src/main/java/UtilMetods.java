import model.Companies;
import model.Securities;

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
}
