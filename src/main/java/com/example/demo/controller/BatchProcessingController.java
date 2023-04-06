package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.InsertOriginalService;

/**
 * バッチ処理を操作するコントローラー.
 * 
 * @author moriharanariki
 *
 */
@Controller
@RequestMapping("")
public class BatchProcessingController {
	
	@Autowired 
	private InsertOriginalService insertOriginalService;
	
	@GetMapping("/insert")
	public String insert() {
		String train_tsv = "/Users/moriharanariki/Desktop/大量データ課題ドキュメント/train.tsv";
		File f = new File(train_tsv);
		
		try(BufferedReader br = new BufferedReader(new FileReader(f));){
			String line;
			
			while ((line = br.readLine()) != null ) {
				String[] oneItemData = line.split("\t",0);				
				insertOriginalService.insert(oneItemData);
				break;
			}
			
		} catch (IOException e){
			System.out.println(e);
		}
		
		return "finish";
	}
}
