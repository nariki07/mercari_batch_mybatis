package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Original;
import com.example.demo.repository.OriginalMapper;

/**
 * original情報を操作するためのサービスクラス.
 * 
 * @author moriharanariki
 *
 */
@Service
@Transactional
public class InsertOriginalService {

	@Autowired
	private OriginalMapper originalMapper;

	/**
	 * tsvファイルの商品情報を保存します.
	 * 
	 * @param oneItemData 1つの商品データ
	 */
	public void insert(String[] oneItemData) {
		Original original = new Original();
		original.setId(Integer.parseInt(oneItemData[0]));
		original.setName(oneItemData[1]);
		original.setConditionId(Integer.parseInt(oneItemData[2]));
		original.setCategoryName(oneItemData[3]);
		original.setBrand(oneItemData[4]);
		original.setPrice(Double.parseDouble(oneItemData[5]));
		original.setShipping(Integer.parseInt(oneItemData[6]));
		original.setDescription(oneItemData[7]);
		
		originalMapper.insert(original);
	}

}
