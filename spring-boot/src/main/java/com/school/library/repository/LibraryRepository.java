package com.school.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.library.model.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

}
