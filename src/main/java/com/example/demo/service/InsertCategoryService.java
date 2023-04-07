package com.example.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.BigCategory;
import com.example.demo.domain.Item;
import com.example.demo.domain.MediumCategory;
import com.example.demo.domain.SmallCategory;
import com.example.demo.repository.BigCategoryMapper;
import com.example.demo.repository.ItemMapper;
import com.example.demo.repository.MediumCategoryMapper;
import com.example.demo.repository.SmallCategoryMapper;

/**
 * カテゴリ情報を操作するサービスクラス.
 * 
 * @author moriharanariki
 *
 */
@Service
@Transactional
public class InsertCategoryService {

	@Autowired
	private BigCategoryMapper bigCategoryMapper;

	@Autowired
	private MediumCategoryMapper mediumCategoryMapper;

	@Autowired
	private SmallCategoryMapper smallCategoryMapper;
	
	@Autowired
	private ItemMapper itemMapper;

	/**
	 * カテゴリ情報の保存を行います.
	 * 
	 * @param oneItemData
	 */
	public void insert(String[] oneItemData, Map<String, Integer> bigCategoryIdMap,
			Map<String, Integer> mediumCategoryIdMap, Map<String, Integer> smallCategoryIdMap) {

		if (oneItemData[3] == "") {
			oneItemData[3] = "Other/Other/Other";
		}

		// oneItemData[3]を/区切りで配列に格納. 例)oneItemData[3] = Men/Tops/T-shirts.
		String[] categories = oneItemData[3].split("/", 0);

		// "Men"
		String bigCategoryName = categories[0];
		// "Men/Clothes"
		String mediumCategoryName = categories[0] + "/" + categories[1];
		// "Men/Clothes/Jeans"
		String smallCategoryName = categories[0] + "/" + categories[1] + "/" + categories[2];
		
		//大カテゴリの保存処理.
		if (bigCategoryIdMap.get(bigCategoryName) == null) {
			BigCategory bigCategory = new BigCategory();
			bigCategory.setName(categories[0]);
			bigCategoryMapper.insert(bigCategory);
			int parentId = bigCategory.getId();
			bigCategoryIdMap.put(bigCategoryName, parentId);
		}
		
		//中カテゴリの保存処理.
		if (mediumCategoryIdMap.get(mediumCategoryName) == null) {
			MediumCategory mediumCategory = new MediumCategory();
			mediumCategory.setBigCategoryId(bigCategoryIdMap.get(bigCategoryName));
			mediumCategory.setName(categories[1]);
			mediumCategoryMapper.insert(mediumCategory);
			int parentId = mediumCategory.getId();
			mediumCategoryIdMap.put(mediumCategoryName, parentId);
		}
		
		//小カテゴリの保存処理.
		if (smallCategoryIdMap.get(smallCategoryName) == null) {
			SmallCategory smallCategory = new SmallCategory();
			smallCategory.setMediumCategoryId(mediumCategoryIdMap.get(mediumCategoryName));
			smallCategory.setName(categories[2]);
			smallCategory.setNameAll(oneItemData[3]);
			smallCategoryMapper.insert(smallCategory);
			int parentId = smallCategory.getId();
			smallCategoryIdMap.put(smallCategoryName, parentId);
		}
		
		//itemテーブルへの保存処理を行う.
		Item item = new Item();
		item.setName(oneItemData[1]);
		item.setConditionId(Integer.parseInt(oneItemData[2]));
		item.setSmallCategoryId(smallCategoryIdMap.get(smallCategoryName)); //小カテゴリのIDをセット.
		item.setBrand(oneItemData[4]);
		item.setPrice(Double.parseDouble(oneItemData[5]));
		item.setShipping(Integer.parseInt(oneItemData[6]));
		item.setDescription(oneItemData[7]);
		itemMapper.insert(item);
		
	}

}
