package gov.ifms.common.logging;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import gov.ifms.common.util.Constant;

/**
 * The LoggingAspect class.
 */
@Component
@Aspect
public class LoggingAspect {

	
	
	/** The environment. */
	@Autowired
	private Environment environment;

	/**
	 * Trace.
	 *
	 * @param proceedingJP the proceeding JP
	 */
	@Before(Constant.EXECUTION_GOV_IFMS_COMMON_LOGGING_ANNOTATION_TRACE)
	public void trace(final JoinPoint proceedingJP) {
		final Logger fileLogger = LoggerFactory.getLogger(proceedingJP.getTarget().getClass());
		CodeSignature codeSignature = (CodeSignature) proceedingJP.getSignature();
		try {
			String parametersNames = String.join(Constant.DELIMITER, Arrays.asList(codeSignature.getParameterNames()));
			String parameterValues = Arrays.asList(proceedingJP.getArgs()).stream().map(String::valueOf)
					.collect(Collectors.joining(Constant.DELIMITER));
			if (!StringUtils.isEmpty(parametersNames) && isLoggingEnable())
				fileLogger.info(Constant.ENTERING2, proceedingJP.getSignature().getName(), parametersNames,
						parameterValues);
			else
				fileLogger.info(Constant.ENTERING, proceedingJP.getSignature().getName());
		} catch (Exception e) {
			fileLogger.error(e.getMessage(), e);
		}
	}

	/**
	 * Trace after returning.
	 *
	 * @param proceedingJP the proceeding JP
	 */
	@AfterReturning(Constant.EXECUTION_GOV_IFMS_COMMON_LOGGING_ANNOTATION_TRACE)
	public void traceAfterReturning(final JoinPoint proceedingJP) {
		final Logger fileLogger = LoggerFactory.getLogger(proceedingJP.getTarget().getClass());
		String methodInformation = proceedingJP.getStaticPart().getSignature().getName();
		fileLogger.info(Constant.EXITING, methodInformation);
	}

	/**
	 * Trace after throwing.
	 *
	 * @param proceedingJP the proceeding JP
	 */
	@AfterThrowing(Constant.EXECUTION_GOV_IFMS_COMMON_LOGGING_ANNOTATION_TRACE)
	public void traceAfterThrowing(final JoinPoint proceedingJP) {
		final Logger fileLogger = LoggerFactory.getLogger(proceedingJP.getTarget().getClass());
		String methodInformation = proceedingJP.getStaticPart().getSignature().getName();
		fileLogger.error(Constant.EXITING, methodInformation);
	}
	
	/**
	 * Checks if is logging enable.
	 *
	 * @return true, if is logging enable
	 */
	public boolean isLoggingEnable() {
		String propertyValue = environment.getProperty(Constant.SPRING_LOGGING_ENABLED);
		return propertyValue!=null?Boolean.valueOf(propertyValue):Boolean.FALSE;
	}

}