package gov.ifms.gst.util;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public interface GSTLocalDateAdapter {

	class LocalDateAdapter implements JsonSerializer<LocalDate> {

		public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
			return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
		}
	}

	class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime> {

		public JsonElement serialize(LocalDateTime date, Type typeOfSrc, JsonSerializationContext context) {
			return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); // "yyyy-MM-dd HH:mm:ss"
		}
	}

	class DateAdapter implements JsonSerializer<Date> {

		public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
			return new JsonPrimitive(new SimpleDateFormat("yyyy-MM-dd").format(date)); // "yyyy-MM-dd "
		}
	}
}
