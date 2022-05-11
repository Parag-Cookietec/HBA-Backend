package gov.ifms.common.util;

import java.io.IOException;
import java.io.StringWriter;

import org.springframework.stereotype.Component;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.exception.CustomException;

@Component
public class FreeMarkerEngine {

	private Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);

	public FreeMarkerEngine() {

		configuration.setClassForTemplateLoading(getClass(), "/");
		configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));
		configuration.setDefaultEncoding("UTF-8");
		configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		configuration.setIncompatibleImprovements(new Version(2, 3, 28));

	}

	public String process(String templateName, Object model) throws CustomException {
		
		try {
			
			Template template = configuration.getTemplate(templateName);
			StringWriter stringWriter = new StringWriter();
			template.process(model, stringWriter);

			return stringWriter.toString();

		} catch (IOException | TemplateException e) {
			throw new CustomException(4001, MsgConstant.COMMON_ERROR_PROCESSING_TEMPLATE);		
		}
	}

}