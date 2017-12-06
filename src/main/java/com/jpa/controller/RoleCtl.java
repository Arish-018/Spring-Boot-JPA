package com.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.accessor.RoleForm;
import com.jpa.repository.BaseRepository;

@RestController
@RequestMapping("/Role")
public class RoleCtl extends BaseCtl<RoleForm> {

	@RequestMapping("/hello")
	public String retturnPage() {
		return "Hello Namkeen";
	}

	@Override
	@Autowired
	@Qualifier("roleRepo")
	public void setService(BaseRepository baseRepository) {
		this.baseRepository = baseRepository;
	}

}
