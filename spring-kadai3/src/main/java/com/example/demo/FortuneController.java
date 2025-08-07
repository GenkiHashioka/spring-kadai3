package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//step4:問題1 占いサイトの作成
///uranaiでfortune.htmlの内容を表示する
@Controller
public class FortuneController {
	@RequestMapping("/uranai")
	public String index() {
		return "fortune";
	}
	
	// step5 問題2 結果の表示
	@RequestMapping("/fortune")
	// リクエストパラメータでmonthを引数に受け取る
	public ModelAndView fortune(@RequestParam("month") int month, ModelAndView mv) {
//		step5 結果はとりあえず固定
		mv.addObject("month", 1);
		mv.addObject("luckyItem", "カバン");
		mv.addObject("luckyColor", "白");
		mv.addObject("ranking", 3);
		mv.setViewName("fortune");
		return mv;
	}
}
