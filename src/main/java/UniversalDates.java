import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class UniversalDates extends TypeAdapter<LocalDate> {
    @Override
    public void write(final JsonWriter jsonWriter, final LocalDate localDate) throws IOException {
        if (localDate == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(localDate.toString());
        }
    }

    @Override
    public LocalDate read(final JsonReader jsonReader) throws IOException {
        String dateFromJson;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        } else
            dateFromJson = jsonReader.nextString();
        return LocalDate.parse(dateFromJson, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}