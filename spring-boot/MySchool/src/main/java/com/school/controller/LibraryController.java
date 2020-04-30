package com.school.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.exception.ResourceNotFoundException;
import com.school.model.Library;
import com.school.repository.LibraryRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class LibraryController {
	@Autowired
	private LibraryRepository libraryRepository;

	@GetMapping("/libraries")
	public List<Library> getAllLibraries() {
		return libraryRepository.findAll();
	}

	@GetMapping("/libraries/{id}")
	public ResponseEntity<Library> getLibraryById(@PathVariable(value = "id") Long Id) throws ResourceNotFoundException {
		Library library = libraryRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Library not found for this id :: " + Id));
		return ResponseEntity.ok().body(library);
	}

	@PostMapping("/libraries")
	public Library createLibrary(@Valid @RequestBody Library library) {
		return libraryRepository.save(library);
	}

	@PutMapping("/libraries/{id}")
	public ResponseEntity<Library> updateLibrary(@PathVariable(value = "id") Long libraryId, @Valid @RequestBody Library libraryData) throws ResourceNotFoundException {
		Library libraryToUpdate = libraryRepository.findById(libraryId).orElseThrow(() -> new ResourceNotFoundException("Library not found for this id :: " + libraryId));
		libraryToUpdate.setLibraryName(libraryData.getLibraryName());

		final Library updatedLibrary = libraryRepository.save(libraryToUpdate);
		return ResponseEntity.ok(updatedLibrary);
	}

	@DeleteMapping("/libraries/{id}")
	public Map<String, Boolean> deleteLibrary(@PathVariable(value = "id") Long libraryId) throws ResourceNotFoundException {
		Library library = libraryRepository.findById(libraryId).orElseThrow(() -> new ResourceNotFoundException("Library not found for this id :: " + libraryId));

		libraryRepository.delete(library);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
