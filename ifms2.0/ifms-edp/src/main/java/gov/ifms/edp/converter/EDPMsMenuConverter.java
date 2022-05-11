package gov.ifms.edp.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsMenuDto;
import gov.ifms.edp.entity.EDPMsMenuEntity;
import gov.ifms.edp.oauth.converter.OAuthMsUserEndpointsConverter;
import gov.ifms.edp.oauth.dto.OAuthMsUserEndpointsDTO;
import gov.ifms.edp.oauth.entity.OAuthMsUserEndpointsEntity;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPMsMenuConverter class.
 * 
 * @version 1.0
 * @created 2019/08/29 17:40:15
 *
 */
@Component
public class EDPMsMenuConverter implements BaseConverter<EDPMsMenuEntity, EDPMsMenuDto> {
	
	/** The oauth ms user endpoints converter. */
	@Autowired
	private OAuthMsUserEndpointsConverter oauthMsUserEndpointsConverter;
	
	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsMenu entity
	 */
	@Override
	public EDPMsMenuEntity toEntity(EDPMsMenuDto dto) {
		EDPMsMenuEntity entity = new EDPMsMenuEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsMenu dto
	 */
	@Override
	public EDPMsMenuDto toDTO(EDPMsMenuEntity entity) {
		EDPMsMenuDto dto = new EDPMsMenuDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * Object to menu dto.
	 *
	 * @param object the object
	 * @return the EDP ms menu dto
	 */
	public EDPMsMenuDto objectToMenuDto(Object[] object) {
		EDPMsMenuDto dto = new EDPMsMenuDto();
		dto.setMenuId(EDPUtility.convertObjectToLong(object[0]));
		dto.setMenuName(EDPUtility.convertObjectToString(object[1]));
		dto.setMenuNameGuj(EDPUtility.convertObjectToString(object[8]));
		dto.setMenuDescription(EDPUtility.convertObjectToString(object[9]));
		dto.setMenuDescriptionGuj(EDPUtility.convertObjectToString(object[10]));
		dto.setMenuCode(EDPUtility.convertObjectToString(object[11]));
		dto.setParentMenuId(EDPUtility.convertObjectToLong(object[14]));
		dto.setMenuLink(EDPUtility.convertObjectToString(object[15]));
		dto.setFromId(EDPUtility.convertObjectToLong(object[16]));
		dto.setOrderId(EDPUtility.convertObjectToShort(object[17]));
		dto.setLinkMenuId(EDPUtility.convertObjectToLong(object[27]));
		return dto;
	}
	
	/**
	 * Gets the oauth ms user endpoint DTO list from menu id.
	 *
	 * @param menuId the menu id
	 * @return the oauth ms user endpoint DTO list from menu id
	 */
	public List<OAuthMsUserEndpointsDTO> getOauthMsUserEndpointDTOListFromMenuId(Long menuId,List<OAuthMsUserEndpointsEntity> endpointList ) {
		return endpointList.stream().filter(endpoint-> endpoint.getMenuId().equals(menuId))
				.map(entity-> oauthMsUserEndpointsConverter.toDTO(entity))
				.collect(Collectors.toList());
	}
	
	
	/**
	 * Auth token entity to dto list.
	 *
	 * @param menuDataList the menu data list
	 * @param masterEndpointList the master endpoint list
	 * @param menuWf 
	 * @return the list
	 */
	public List<EDPMsMenuDto> authTokenEntityToDtoList(List<Object[]> menuDataList,
			List<OAuthMsUserEndpointsEntity> masterEndpointList, Map<Long, Set<ClueDto>> menuWf) {
		List<EDPMsMenuDto> response = new ArrayList<>();
		Map<Long, List<Object[]>> moduleMap = new HashMap<>();
			menuDataList.forEach(obj -> {
				Long moduleId = null != obj[28] ? EDPUtility.convertObjectToLong(obj[28]):null;
				if (moduleMap.containsKey(moduleId)) {
					List<Object[]> value = moduleMap.get(moduleId);
					value.add(obj);
					moduleMap.replace(moduleId, value);
				} else {
					List<Object[]> objList = new ArrayList<>();
					objList.add(obj);
					moduleMap.put(moduleId, objList);
				}
			});

			moduleMap.forEach((key, value) -> {
				List<EDPMsMenuDto> subModuleList = getSubModuleList(value, masterEndpointList,menuWf);
				if(!CollectionUtils.isEmpty(subModuleList)) {
					if(null != key) {
						EDPMsMenuDto dto = new EDPMsMenuDto();
						dto.setMenuId(EDPUtility.convertObjectToLong(value.get(0)[28]));
						dto.setMenuName(EDPUtility.convertObjectToString(value.get(0)[31]));
						dto.setOrderId(EDPUtility.convertObjectToShort(value.get(0)[32]));
						dto.setMenuDtos(subModuleList);
						response.add(dto);
					} else {
						response.addAll(subModuleList);
					}
				}
			});
			response.sort((EDPMsMenuDto s1, EDPMsMenuDto s2)->s1.getOrderId().compareTo(s2.getOrderId()));
			return response;
	}
	
	/**
	 * Gets the sub module list.
	 *
	 * @param subModuleObjList the sub module obj list
	 * @param menuWf 
	 * @return the sub module list
	 */
	private List<EDPMsMenuDto> getSubModuleList(List<Object[]> subModuleObjList, List<OAuthMsUserEndpointsEntity> masterEndpointList, Map<Long, Set<ClueDto>> menuWf) {
		List<EDPMsMenuDto> response = new ArrayList<>();
		Map<Long, List<Object[]>> submoduleMap = new HashMap<>();
		subModuleObjList.forEach(obj -> {
			Long subModuleId = null != obj[29] ? EDPUtility.convertObjectToLong(obj[29]):null;
			if (submoduleMap.containsKey(subModuleId)) {
				List<Object[]> kayValue = submoduleMap.get(subModuleId);
				kayValue.add(obj);
				submoduleMap.replace(subModuleId, kayValue);
			} else {
				List<Object[]> objList = new ArrayList<>();
				objList.add(obj);
				submoduleMap.put(subModuleId, objList);
			}
		});

		submoduleMap.forEach((key, value) -> {
			List<EDPMsMenuDto> menuList = getMenuList(value,masterEndpointList,menuWf);
			if(!CollectionUtils.isEmpty(menuList)) {
				if(null != key) {
					EDPMsMenuDto dto = new EDPMsMenuDto();
					dto.setMenuId(EDPUtility.convertObjectToLong(value.get(0)[29]));
					dto.setMenuName(EDPUtility.convertObjectToString(value.get(0)[34]));
					dto.setOrderId(EDPUtility.convertObjectToShort(value.get(0)[35]));
					dto.setMenuDtos(menuList);
					response.add(dto);
				} else {
					response.addAll(menuList);
				}
			}
		});
		response.sort((EDPMsMenuDto s1, EDPMsMenuDto s2)->s1.getOrderId().compareTo(s2.getOrderId()));
		return response;
	}

	/**
	 * Gets the menu list.
	 *
	 * @param menuObjList the menu obj list
	 * @param menuWf 
	 * @return the menu list
	 */
	private List<EDPMsMenuDto> getMenuList(List<Object[]> menuObjList, List<OAuthMsUserEndpointsEntity> masterEndpointList, Map<Long, Set<ClueDto>> menuWf) {
		List<EDPMsMenuDto> response = new ArrayList<>();
		Map<Long,List<Object[]>> menuModuleMap = new HashMap<>();
		menuObjList.forEach(obj -> {
			Long menuId = EDPUtility.convertObjectToLong(obj[0]);
			if(obj != null && menuModuleMap.containsKey(menuId)) {
				List<Object[]> kayValue = menuModuleMap.get(menuId);
				kayValue.add(obj);
				menuModuleMap.replace(menuId,kayValue);
			} else {
				List<Object[]> objList = new ArrayList<>();
				objList.add(obj);
				menuModuleMap.put(menuId, objList);
			}
		});
		
		menuModuleMap.forEach((key,value)->{
			EDPMsMenuDto dto = objectToMenuDto(value.get(0));
			dto.setOauthMsUserEndpointsDTOList(getOauthMsUserEndpointDTOListFromMenuId(dto.getMenuId(),masterEndpointList));
			dto.setEdpMsRolePermissionsDto(getRolePrmForMenu(value));
			dto.setWfRoleId(getWfRoleFromListByMenuId(value));
			if(null != dto.getLinkMenuId() && !dto.getLinkMenuId().equals(dto.getMenuId()) && menuWf.containsKey(dto.getLinkMenuId())) {
				dto.setLinkMenuWfRoleId(menuWf.get(dto.getLinkMenuId()).stream().collect(Collectors.toSet()));
			}
			response.add(dto);
		});
		response.sort((EDPMsMenuDto s1, EDPMsMenuDto s2)->s1.getOrderId().compareTo(s2.getOrderId()));
		return response;
	}

	/**
	 * Gets the role prm for menu.
	 *
	 * @param value the value
	 * @return the role prm for menu
	 */
	private List<ClueDto> getRolePrmForMenu(List<Object[]> value) {
		return value.stream().map(prm->{
			ClueDto rolePrm = new ClueDto();
			rolePrm.setId(EDPUtility.convertObjectToLong(prm[2]));
			rolePrm.setName(EDPUtility.convertObjectToString(prm[3]));
			return rolePrm;
		}).collect(Collectors.toList());
	}
	
	/**
	 * Gets the wf role from list by menu id.
	 *
	 * @param menuData the menu data
	 * @return the wf role from list by menu id
	 */
	public Set<ClueDto> getWfRoleFromListByMenuId(List<Object[]> menuData){
		return menuData.stream().map(object->{
					ClueDto dto = new ClueDto();
					dto.setWfRoleIds(Arrays.asList(EDPUtility.convertObjectToLong(object[4])));
					dto.setWfRoleCode(Arrays.asList(EDPUtility.convertObjectToString(object[5])));
					return dto;
				}).collect(Collectors.toSet());
	}

	
}
