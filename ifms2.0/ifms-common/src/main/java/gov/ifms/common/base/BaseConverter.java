package gov.ifms.common.base;

import java.util.List;
import java.util.stream.Collectors;



/**
 * The BaseConverter Class
 *
 * @param <E> the generic type as Entity
 * @param <D> the generic type as Dto
 */
public interface BaseConverter<E, D> {

	/**
	 * To entity.
	 * @param dto the dto
	 * @return the entity
	 */
	 E toEntity(D dto);

	/**
	 * To DTO.
	 * @param entity the entity
	 * @return the dto
	 */
	 D toDTO(E entity);
	

	/**
	 * To entity.
	 * @param list the list
	 * @return the list
	 */
	default  List<E> toEntity(List<D> list){
		return list.stream().map(this::toEntity).collect(Collectors.toList());
	}
	
	/**
	 * To DTO.
	 * @param list the list
	 * @return the list
	 */
	default List<D> toDTO(List<E> list){
		return list.stream().map(this::toDTO).collect(Collectors.toList());
	}

	
		
}
