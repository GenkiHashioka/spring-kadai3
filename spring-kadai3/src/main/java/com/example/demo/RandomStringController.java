package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//----------------------------------------------------------------------
// [概要] 問題2,3 ランダム文字列ジェネレータの機能追加①
// [詳細] ランダム文字列生成時、生成数を10個固定ではなく画面から指定できるようにする。
//       テキストボックス画からの場合はデフォルト値として１個生成するようにする。
//----------------------------------------------------------------------

// ----------------------------------------------------------------------
// [概要] 問題4 ランダム文字列生成時、画面から「数字を含める」「英字を含める」を指定できるようにしてください。両方にチェックが入っていない場合は文字列の生成を行いません。
// 
// コントローラの作成
@Controller
public class RandomStringController {
	// インスタンス化の省略 
	@Autowired
	RandomStringGenerator gen;
	
	// 初期画面の表示
	@RequestMapping("/")
	public String index() {
		return "random";
	}
	
	// POSTメソッドリクエストパラメータとしてlength,includeNumber,countを引数として受け取る
	@RequestMapping(value = "/generate", method = RequestMethod.POST)
	public ModelAndView generate(@RequestParam("length") int length,
	@RequestParam(name = "includeNumber", defaultValue = "") String includeNumber,
	@RequestParam(name= "count", defaultValue = "1") int count,
	@RequestParam(name= "includeAlpha", defaultValue = "") String includeAlpha, // 英字を含めるチェックボックス追加による。
	ModelAndView mv) {
//		includeNumberの値が1であればtrueを返す変数
		boolean includeNumberFlag = "1".equals(includeNumber);
//		includeAlphaのチェック判定用の変数
		boolean includeAlphaFlag = "1".equals(includeAlpha);
//		チェックボックスのどちらにもチェックが入っていない場合の処理
		if (!includeNumberFlag && !includeAlphaFlag) {
			mv.addObject("error", "英字または数字のどちらかは必須です。");
			mv.setViewName("random");
			return mv;
		}
		
//		Listクラスの変数results RandomStringGeneratorクラスのgenerateメソッドに引数を入れて値を取得する。(文字数、個数、true or false)
		List<String> results = gen.generate(length, count, includeNumberFlag, includeAlphaFlag); // includeAlphaFlagを追加。
//	ModelAndViewのresultsに変数resultsの値を格納
		mv.addObject("results", results);
//	ModelAndViewの値をrandom.htmlにセットする。
		mv.setViewName("random");
//		ModelAndView型のmvを返り値に指定。
		return mv;
		
	}
	
	
}
