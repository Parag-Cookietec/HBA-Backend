package gov.ifms.common.logging.annotation;

/**
 * The Trace interface.
 */
public @interface Trace {
    
    /**
     * Enable.
     *
     * @return true, if successful
     */
    boolean enable() default true;
}
