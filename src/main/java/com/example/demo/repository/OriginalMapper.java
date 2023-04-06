package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Original;

/**
 * オリジナル情報 Mapper
 * 
 * @author moriharanariki
 *
 */
@Repository
@Mapper
public interface OriginalMapper {
	
	public void insert(Original original);
	
}
