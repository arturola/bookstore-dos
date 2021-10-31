package com.bookstore.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Album;
import com.bookstore.repository.AlbumRepository;
import com.bookstore.service.AlbumService;


@Service
public class AlbumServiceImpl implements AlbumService {

	private static final Logger LOG = LoggerFactory.getLogger(AlbumService.class);
	@Autowired
	private AlbumRepository albumRepository;
	
	@Transactional
	public Album createAlbum(Album album) {
		Album localAlbum = albumRepository.findByName(album.getName());
		
		if(localAlbum != null) {
			LOG.info("Album with name {} already exists ", album.getName());	
		} else {
			localAlbum = albumRepository.save(album);
		}
		
		return localAlbum;
	}

}
