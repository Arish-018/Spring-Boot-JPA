package com.jpa.accessor;


import java.util.Date;
import com.jpa.models.CommonDto;
import com.jpa.models.UserDto;

public class UserForm extends CommonForm {

	private String firstName;

	private String lastName;

	private Date createdAt;

	private Date updatedAt;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public CommonDto makeDto() {
		UserDto userDto = new UserDto();
		userDto.setCreatedAt(createdAt);
		userDto.setFirstName(firstName);
		userDto.setLastName(lastName);
		userDto.setUpdatedAt(updatedAt);
		return userDto;
	}

	@Override
	public void populate(CommonDto dto) {

		UserDto userDto = (UserDto) dto;
		createdAt = userDto.getCreatedAt();
		updatedAt = userDto.getUpdatedAt();
		lastName = userDto.getLastName();
		firstName = userDto.getFirstName();
		super.populateCommon(dto);
	}

}
