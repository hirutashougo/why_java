package lesson_4.work4_1;

/*
 * クラス名:Yamada
 * 概要:ジャンケンプレイヤーYamadaの情報を管理
 * 作成者:S.Hiruta
 * 作成日:2024/06/27
 */
public class Yamada {

	//ジャンケンの手を表す定数を宣言
	//グーを表す定数を定義
	public static final int STONE_NUMBER = 0;
	//チョキを表す定数を定義
	public static final int SCISSORS_NUMBER = 1;
	//パーを表す定数を定義
	public static final int PAPER_NUMBER = 2;
	//ジャンケンの手を決める乱数の範囲を定数化
	public static final int JANKEN_RANGE = 3;
	//生成される乱数の中で1番目の区切りとなる数値を定数化
	public static final int FIRST_RANDOM_MNUMBER = 1;
	//生成される乱数の中で2番目の区切りとなる数値を定数化
	public static final int SECOND_RANDOM_MNUMBER = 2;
	//生成される乱数の中で3番目の区切りとなる数値を定数化
	public static final int THIRD_RANDOM_MNUMBER = 3;
	//プレイヤーの属性

	//プレイヤーの名前
	private String playerName = "";
	//プレイヤーの勝った回数
	private int winCount = 0;

	/*
	 * コンストラクタ名：Yamada
	 * 概要:ジャンケンプレイヤーの名前を初期化して宣言
	 * 引数：ジャンケンプレイヤーの名前(String型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/06/28
	*/
	public Yamada(String inputName) {
		//ジャンケンプレイヤーの名前を入力値で初期化
		playerName = inputName;
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

		//パーを選択
		playerHand = PAPER_NUMBER;
		//プレイヤーの手を表示する
		System.out.print("パー");

		//ジャンケンの手を返却
		return playerHand;
	}

	/*
	 * 関数名：notifyResult
	 * 概要:審判から勝敗を聞く(ジャンケンの勝った回数を加算する)
	 * 引数：ジャンケンの勝ち負け(boolean型)
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/06/28
	*/
	public void notifyResult(boolean result) {

		//ジャンケンに勝った場合
		if (true == result) {
			//勝った回数を1加算する
			winCount += 1;
		}
	}

	/*
	 * 関数名：getWinCount
	 * 概要:自分の勝った回数を答える(ジャンケンに勝った回数を返却する)
	 * 引数：なし
	 * 戻り値：ジャンケンに勝った回数(int型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/06/28
	*/
	public int getWinCount() {

		//勝った回数
		return winCount;
	}

	/*
	 * 関数名：getName
	 * 概要:プレイヤーの名前を返却する
	 * 引数：なし
	 * 戻り値：ジャンケンプレイヤーの名前(int型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/06/28
	*/
	public String getName() {

		//勝った回数
		return playerName;
	}

}
