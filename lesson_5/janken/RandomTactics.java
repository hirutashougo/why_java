package lesson_5.janken;

/*
 * クラス名:PlayerWithInterface
 * 概要:ランダムに手を決める戦略クラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/01
 */
public class RandomTactics implements Tactics{

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

	/*
	 * 関数名：readTactics
	 * 概要:ジャンケンの手をランダムに決める
	 * 引数：なし
	 * 戻り値：ジャンケンの手
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/01
	*/
	public int readTactics() {

		//乱数を格納するための定数を定義
		double randomNumber = 0;

		//プレイヤーが何を出すか決定する
		//プレイヤーの手を格納する変数を定義
		int playerHand = 0;

		//0以上3未満の少数として乱数を得る
		randomNumber = Math.random() * JANKEN_RANGE;

		//生成された乱数が1未満の場合
		if (randomNumber < FIRST_RANDOM_MNUMBER) {
			//グーを選択
			playerHand = STONE_NUMBER;

			//生成された乱数が(1以上)2未満の場合
		} else if (randomNumber < SECOND_RANDOM_MNUMBER) {
			//チョキを選択
			playerHand = SCISSORS_NUMBER;

			//生成された乱数が(2以上)3未満の場合
		} else if (randomNumber < THIRD_RANDOM_MNUMBER) {
			//パーを選択
			playerHand = PAPER_NUMBER;
		}

		//ジャンケンの手を返却
		return playerHand;

	}

}
