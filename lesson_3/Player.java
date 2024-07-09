package lesson_3;

//乱数生成のためのクラスをインポート
import java.util.Random;

/*
 * クラス名:Player
 * 概要:ジャンケンのプレイヤーの情報を管理
 * 作成者:S.Hiruta
 * 作成日:2024/06/28
 */
public class Player {

	//グーを表す定数を定義
	public static final int STONE_NUMBER = 0;
	//チョキを表す定数を定義
	public static final int SCISSORS_NUMBER = 1;
	//パーを表す定数を定義
	public static final int PAPER_NUMBER = 2;
	//ジャンケンの手の種類の数を定数化
	public static final int JANKEN_TYPE_COUNT = 3;
	//ジャンケンの手を決める乱数の範囲を調整する定数を宣言
	public static final int JANKEN_TYPE_COUNT_ADJUSTMENT = -1;

	//プレイヤーの名前
	private String playerNamea = "";
	//プレイヤーの勝った回数
	private int winCount = 0;

	/*
	 * コンストラクタ名：Player
	 * 概要:ジャンケンプレイヤーの名前を初期化して宣言
	 * 引数：ジャンケンプレイヤーの名前(String型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/06/28
	*/
	public Player(String inputName) {
		//ジャンケンプレイヤーの名前を入力値で初期化
		playerNamea = inputName;
	}

	//プレイヤークラスの操作

	/*
	 * 関数名：showHand
	 * 概要:ジャンケンの手を決める
	 * 引数：なし
	 * 戻り値：ジャンケンの手を表す数字(int型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/06/28
	*/
	public int showHand() {

		//乱数生成クラスの変数を宣言
		Random randomNumber = new Random();

		//プレイヤーの手を格納する変数を定義
		int playerHand = 0;

		//乱数を格納するための定数を定義
		double jankenNumber = 0;

		//0以上2未満の少数として乱数を得る
		jankenNumber = randomNumber.nextInt(JANKEN_TYPE_COUNT + JANKEN_TYPE_COUNT_ADJUSTMENT);

		//生成された乱数が1未満の場合
		if (jankenNumber == STONE_NUMBER) {
			//グーを選択
			playerHand = STONE_NUMBER;

			//生成された乱数が(1以上)2未満の場合
		} else if (jankenNumber == SCISSORS_NUMBER) {
			//チョキを選択
			playerHand = SCISSORS_NUMBER;

			//生成された乱数が(2以上)3未満の場合
		} else if (jankenNumber == PAPER_NUMBER) {
			//パーを選択
			playerHand = PAPER_NUMBER;
		}

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
	public void notifyResult(boolean gameResult) {

		//ジャンケンに勝った場合
		if (gameResult == true) {
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
		return playerNamea;
	}

}
