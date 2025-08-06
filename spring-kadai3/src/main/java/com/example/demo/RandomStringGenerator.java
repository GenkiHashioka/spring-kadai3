package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

// Model ModelAndViewに返す値の型を定義するためのメソッド
@Service
public class RandomStringGenerator {
	// 引数にint,int,booleanを受取、List型の返り値を返すgenerateメソッド
	public List<String> generate(int length, int count, boolean includeNumbers) {
		// リストの数が決まっていないリストとしてArrayListを作成。
		List<String> list = new ArrayList<>();
		
		
//	countで指定された回数だけ次の処理を繰り返すforの作成
		for(int i = 0; i < count; i++) {
			// 条件分岐 inculudeNumbersの値がtrueであれば以下の処理を実行
			if (includeNumbers) {
				// RandomStringUtilsライブラリを使用してランダムな文字列を取得（数字入り） 前提条件としてcommons-lang3の依存関係を設定。(build.gradle)
				list.add(RandomStringUtils.randomAlphanumeric(length));
				// falseの場合ランダムな文字列（数字なし）を追加。
			} else {
				list.add(RandomStringUtils.randomAlphabetic(length));
			}
		}
		// 戻り値としてlistを返す。
		return list;
	}
}
