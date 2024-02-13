package com.finalproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finalproject.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository <Movie, Long> {
	
	List<Movie> findByTitleIgnoreCaseLike(String title);
	
	@Query("SELECT m FROM Movie m WHERE m.createdBy = :username")
	List<Movie> findByCreatedBy(@Param("username") String username);
	
	List<Movie> findByCategory(String category);


}
