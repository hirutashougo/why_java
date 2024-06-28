package lesson_4.work4_2;

//jankenパッケージのPlayerクラスをインポート
import janken.Player;

/*
 * クラス名:Murata
 * 概要:ジャンケンプレイヤーMurataの情報を管理
 * 作成者:S.Hiruta
 * 作成日:2024/06/27
 */
public class Murata extends Player{
	
	/*
	 * コンストラクタ名：Murata
	 * 概要:ジャンケンプレイヤーの名前を初期化して宣言
	 * 引数：ジャンケンプレイヤーの名前(String型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/06/28
	*/
	public Murata(String inputName) {
		//Playerクラスのスーパーコンストラクタを呼び出す
		super(inputName);
	}

	//プレイヤークラスの操作

	/*
	 * 関数名：showHand
	 * 概要:ジャンケンの手を決める
	 * 引数：なし
	 * 戻り値：ジャンケンの手
	 * 作成者：S.Hiruta
	 * 作成日：2024/06/28
	*/
	public int showHand() {

		//プレイヤーが何を出すか決定する
		//プレイヤーの手を格納する変数を定義
		int playerHand = 0;

		//グーを選択
		playerHand = STONE_NUMBER;
		//プレイヤーの手を表示する
		System.out.print("グー");

		//ジャンケンの手を返却
		return playerHand;
	}

}
