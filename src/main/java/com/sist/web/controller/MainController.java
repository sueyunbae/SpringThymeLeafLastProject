package com.sist.web.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.sist.web.service.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class MainController {
	private final SeoulService sService;
   @GetMapping("/")
   public String main_page(Model model)
   {
	   Map map=new HashMap();
	   map.put("table_name", "seoul_location");
	   List<SeoulVO> lList=sService.seoulMainData(map);
	   
	   map=new HashMap();
	   map.put("table_name", "seoul_nature");
	   List<SeoulVO> nList=sService.seoulMainData(map);

	   map=new HashMap();
	   map.put("table_name", "seoul_shop");
	   List<SeoulVO> sList=sService.seoulMainData(map);
	   
	   //main에 전송
	   model.addAttribute("lList",lList);
	   model.addAttribute("nList",nList);
	   model.addAttribute("sList",sList);
	   
	   model.addAttribute("main_html", "main/home");
	   return "main/main";
   }
}