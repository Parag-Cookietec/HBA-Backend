package gov.ifms.common.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

/**
 * The MessageUtil class.
 */
@Component
public class MessageUtil {

	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/** The accessor. */
	private static MessageSourceAccessor accessor;

	/**
	 * Inits the.
	 */
	@PostConstruct
	private synchronized void init() {
		accessor = new MessageSourceAccessor(messageSource, LocaleContextHolder.getLocale());
	}

	/**
	 * Gets the msg.
	 *
	 * @param code the code
	 * @return the msg
	 */
	public static String getMsg(String code) {
		try{
			return accessor.getMessage(code);
		}catch (Exception e){

		}
		return Constant.NO_MESSAGE_FOUND;
	}

	/**
	 * Gets the msg.
	 *
	 * @param code   the code
	 * @param fields the fields
	 * @return the msg
	 */
	public static String getMsg(String code, Object... fields) {
		try{
			return accessor.getMessage(code, fields);
		}catch (Exception e){

		}
		return Constant.NO_MESSAGE_FOUND;
	}
}
