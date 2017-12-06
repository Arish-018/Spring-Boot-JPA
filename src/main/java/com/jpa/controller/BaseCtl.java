package com.jpa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jpa.accessor.CommonForm;
import com.jpa.models.CommonDto;
import com.jpa.repository.BaseRepository;

public abstract class BaseCtl<T extends CommonForm> {
	protected BaseRepository baseRepository;

	public abstract void setService(BaseRepository baseRepository);

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public CommonDto add(@RequestBody T form) {
		CommonDto dto = null;
		Long pk = null;
		dto = form.makeDto();
		return (CommonDto) baseRepository.save(dto);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<CommonDto>> getAll() {
		List<CommonDto> list = baseRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/edit/{id}")
	public ResponseEntity<CommonDto> getNoteById(@PathVariable(value = "id") Long noteId) {
		CommonDto note = (CommonDto) baseRepository.findOne(noteId);
		if (note == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(note);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CommonDto> updateNote(@PathVariable(value = "id") Long noteId, @Valid @RequestBody T form) {
		CommonDto note = (CommonDto) baseRepository.findOne(noteId);
		if (note == null) {
			return ResponseEntity.notFound().build();
		}
		CommonDto dto = form.makeDto();
		CommonDto updatedNote = (CommonDto) baseRepository.save(dto);
		return ResponseEntity.ok(updatedNote);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CommonDto> deleteNote(@PathVariable(value = "id") Long id) {
		CommonDto dto = (CommonDto) baseRepository.findOne(id);

		if (dto == null) {
			return ResponseEntity.notFound().build();
		}
		baseRepository.delete(id);
		return ResponseEntity.ok().build();
	}
}