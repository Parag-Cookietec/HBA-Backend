package gov.ifms.common.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.beanutils.BeanUtils;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.ErrorResponse;


public class NativeQueryResultsMapper {

    public static <T> T map(Object object, Class<T> genericType) throws CustomException {
        List<Field> mappingFields = getNativeQueryResultColumnAnnotatedFields(genericType);
        T t = null;
        Object[] objectArr = (Object[]) object;
        try {
            t = genericType.newInstance();
            for (int i = 0; i < objectArr.length; i++) {
                BeanUtils.setProperty(t, mappingFields.get(i).getName(), objectArr[i]);
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException  ie) {
        	throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
        }
		return t;
    }
    
    
	private NativeQueryResultsMapper() {
		super();
	}
	
	public static <T> List<T> map(List<Object[]> objectArrayList, Class<T> genericType) throws CustomException {
		List<T> ret = new ArrayList<>();
		List<Field> mappingFields = getNativeQueryResultColumnAnnotatedFields(genericType);
		try {
			for (Object[] objectArr : objectArrayList) {
				T t = genericType.newInstance();
				for (int i = 0; i < objectArr.length; i++) {
					if (mappingFields.get(i) != null && mappingFields.get(i).getName() != null && objectArr[i] != null) {
						if (mappingFields.get(i).getType().equals(LocalDateTime.class)) {
							BeanUtils.setProperty(t, mappingFields.get(i).getName(), LocalDateTime.ofInstant(Instant.ofEpochMilli(((Timestamp) objectArr[i]).getTime()), TimeZone.getDefault().toZoneId()));
						} else if (Boolean.class.equals(mappingFields.get(i).getType())) {
							BeanUtils.setProperty(t, mappingFields.get(i).getName(), Boolean.parseBoolean(objectArr[i].toString().trim()));
						} else {
							BeanUtils.setProperty(t, mappingFields.get(i).getName(), objectArr[i]);
						}
					}
				}
				ret.add(t);
			}
		} catch (Exception ie) {
			ie.printStackTrace();
			ret.clear();
			throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
		}
		return ret;
	}

	// Get ordered list of fields
	private static <T> List<Field> getNativeQueryResultColumnAnnotatedFields(Class<T> genericType) {
		Field[] fields = genericType.getDeclaredFields();
		List<Field> orderedFields = Arrays.asList(new Field[fields.length]);
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].isAnnotationPresent(NativeQueryResultColumn.class)) {
				NativeQueryResultColumn nqrc = fields[i].getAnnotation(NativeQueryResultColumn.class);
				orderedFields.set(nqrc.index(), fields[i]);
			}
		}
		return orderedFields;
	}

	public static <T> T map(Object[] objectArray, Class<T> genericType) throws CustomException {
		List<Field> mappingFields = getNativeQueryResultColumnAnnotatedFields(genericType);
		try {
			T t = genericType.newInstance();
			for (int i = 0; i < objectArray.length; i++) {
				BeanUtils.setProperty(t, mappingFields.get(i).getName(), objectArray[i]);
			}
			return t;
		} catch (Exception ie) {
			throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
		}
	}
	
	public static <T> List<T> map(List<Object[]> objectArrayList, Class<T> genericType, int[] ignore)
			throws CustomException {
		List<T> ret = new ArrayList<>();
		List<Field> mappingFields = getNativeQueryResultColumnAnnotatedFields(genericType);
		try {
			for (Object[] objectArr : objectArrayList) {
				T t = genericType.newInstance();
				for (int i = 0; i < objectArr.length; i++) {
					if (!contains(ignore, i) && mappingFields != null && mappingFields.get(i) != null
							&& mappingFields.get(i).getName() != null && objectArr[i] != null)
						BeanUtils.setProperty(t, mappingFields.get(i).getName(), objectArr[i]);
				}
				ret.add(t);
			}
		} catch (Exception ie) {
			ret.clear();
			throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
		}
		return ret;
	}

	private static boolean contains(final int[] array, final int key) {
		 return Arrays.stream(array).anyMatch(i -> i == key);
	}
}