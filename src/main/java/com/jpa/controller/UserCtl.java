package com.jpa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.accessor.UserForm;
import com.jpa.repository.BaseRepository;
import com.jpa.repository.UserRepository;

@RestController
@RequestMapping("/User")
public class UserCtl extends BaseCtl<UserForm> {

	@RequestMapping("/hello")
	public String retturnPage() {
		return "Hello Namkeen";
	}

	@Override
	@Autowired
	@Qualifier("userRepo")
	public void setService(BaseRepository baseRepository) {
		this.baseRepository = baseRepository;
	}
}
