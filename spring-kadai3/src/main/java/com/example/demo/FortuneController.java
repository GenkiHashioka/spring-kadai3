package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//step4:問題1 占いサイトの作成
///uranaiでfortune.htmlの内容を表示する
@Controller
public class FortuneController {
	@RequestMapping("/uranai")
	public String index() {
		return "fortune";
	}
}
