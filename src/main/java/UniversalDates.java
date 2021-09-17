import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

class UniversalDates extends TypeAdapter<LocalDate> {
    @Override
    public void write(final JsonWriter jsonWriter, final LocalDate localDate) throws IOException {
        if (localDate == null) {
            jsonWriter.nullValue();
        }
        else {
            jsonWriter.value(localDate.toString());
        }
    }

    @Override
    public LocalDate read(final JsonReader jsonReader) throws IOException {
        SimpleDateFormat jsonDateGetter;
        SimpleDateFormat newDateFormat;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;}
        else

        jsonDateGetter = new SimpleDateFormat("dd.mm.yyyy", Locale.getDefault());
        newDateFormat = new SimpleDateFormat("yyyy-mm-dd", Locale.getDefault());
        String dateFromJson = jsonReader.nextString();
        Date date = null;
        try {
            date = jsonDateGetter.parse(dateFromJson);
        } catch (ParseException e) {
            System.out.println("Не удалось определить дату");
        }
        String result = newDateFormat.format(date);
        return LocalDate.parse(result);
    }
}