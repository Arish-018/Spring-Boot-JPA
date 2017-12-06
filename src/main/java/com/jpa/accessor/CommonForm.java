package com.jpa.accessor;

import com.jpa.models.CommonDto;

public abstract class CommonForm {
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CommonDto makeDto(CommonDto dto) {
		dto.setId(id);
		return dto;
	}

	public abstract CommonDto makeDto();

	public void populateCommon(CommonDto dto) {
		id = dto.getId();
	}

	public abstract void populate(CommonDto dto);
}
