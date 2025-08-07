package com.example.demo;

import java.util.Random;

//step6占いサイトの作成
//このクラスで結果を保持できるようにする

public class Fortune {
	// フィールド変数の作成
	private int month;
	private String luckyItem;
	private String luckyColor;
	private int ranking;
	
//	配列にラッキーアイテムとラッキーカラーを定数にまとめておく
	private static final String[] LUCKYITEMS = {"タオル", "カバン", "腕時計"};
	private static final String[] LUCKYCOLORS = {"赤", "黃", "白"};
	
	// コンストラクタ コントローラからデータを受け取り、変数に値を格納する。
	public Fortune(int month) {
		this.month = month;
//		ランダムクラスのインスタンス作成
		Random rand = new Random();
//		ラッキーアイテムとラッキーカラーを配列からランダムに取り出し格納する。
		this.luckyItem = LUCKYITEMS[rand.nextInt(LUCKYITEMS.length)];
		this.luckyColor = LUCKYCOLORS[rand.nextInt(LUCKYCOLORS.length)];
		// ランキングは 1~12までの値をランダムに格納する
		this.ranking = rand.nextInt(12) + 1; // (12)だと0~11になるため1を物理的に足す事によって1~12を実現する
	}
	
//	getterの作成
	public int getMonth() {
		return month;
	}
	
	public String getLuckyItem() {
		return luckyItem;
	}
	
	public String getLuckyColor() {
		return luckyColor;
	}
	
	public int getRanking() {
		return ranking;
	}
	
}
