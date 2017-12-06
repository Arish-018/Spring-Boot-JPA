package com.jpa.accessor;

import com.jpa.models.CommonDto;
import com.jpa.models.RoleDto;

public class RoleForm extends CommonForm {

	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public CommonDto makeDto() {
		RoleDto roleDto = new RoleDto();
		roleDto.setRoleName(roleName);
		return roleDto;
	}

	@Override
	public void populate(CommonDto dto) {
		RoleDto roleDto = (RoleDto) dto;
		roleName = roleDto.getRoleName();
	}

}
