package Babanuki;

/*
 * クラス名:Card
 * 概要:トランプのカードを表すクラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/01
 */
public class Card {

	//ジョーカーを表す定数を宣言
	public static final int JOKER_CONSTANT = 0;
	//スペードを表す定数を宣言
	public static final int SUIT_SPADE = 1;
	//ダイヤを表す定数を宣言
	public static final int SUIT_DIAMOND = 2;
	//クラブを表す定数を宣言
	public static final int SUIT_CLUB = 3;
	//ハートを表す定数を宣言
	public static final int SUIT_HEART = 4;

	//カードのスートを表す変数をフィールドを宣言
	private int suitNumber = 0;
	//カードの数字を表す変数をフィールドを宣言
	private int cardNumber = 0;
}
