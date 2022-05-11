package gov.ifms.edp.oauth.exception;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import gov.ifms.edp.oauth.util.OAuthConstant;

/**
 * The Class OAuthExceptionSerializer.
 */
public class OAuthExceptionSerializer extends StdSerializer<OAuthException> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new o auth exception serializer.
	 */
	public OAuthExceptionSerializer() {
		super(OAuthException.class);
	}

	/**
	 * Serialize.
	 *
	 * @param value the value
	 * @param jsonGenerator the json generator
	 * @param serializerProvider the serializer provider
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Override
	public void serialize(OAuthException value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeNumberField(OAuthConstant.STATUS, value.getHttpErrorCode());
		jsonGenerator.writeObjectField(OAuthConstant.DATA, null);
		jsonGenerator.writeObjectField(OAuthConstant.ERRORS, Arrays.asList(value.getOAuth2ErrorCode(), value.getMessage()));
		if (value.getAdditionalInformation() != null) {
			for (Map.Entry<String, String> entry : value.getAdditionalInformation().entrySet()) {
				String key = entry.getKey();
				String add = entry.getValue();
				jsonGenerator.writeStringField(key, add);
			}
		}
		jsonGenerator.writeEndObject();
	}
}