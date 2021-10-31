package com.bookstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.Album;

public interface AlbumRepository extends CrudRepository<Album, Long>{
	Album findByName(String name);
	Album findByArtist(String artist);
	//Album findByCompanyName(String company);
	List<Album> findAll();
}
