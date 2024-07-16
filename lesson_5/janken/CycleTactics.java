package lesson_5.janken;

/*
 * クラス名:CycleTactics
 * 概要:標準入力によりグー・チョキ・パーの順に手を出す戦略クラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/01
 */
public class CycleTactics implements Tactics {

	//ジャンケンの手を表す定数を宣言
	//グーを表す定数を定義
	public static final int STONE_NUMBER = 0;
	//チョキを表す定数を定義
	public static final int SCISSORS_NUMBER = 1;
	//パーを表す定数を定義
	public static final int PAPER_NUMBER = 2;
	//ジャンケンの手数を表す定数を定義
	public static final int JANKEN_TYPE_COUNT = 3;
	//最初の試合数を表す定数を定義
	public static final int FIRST_GAME_COUNT = 1;
	//次の試合数を表す定数を定義
	public static final int SECOND_GAME_COUNT = 2;
	//ジャンケンの試合数の初期値を定数化
	public static final int INITIAL_GAME_COUNT = 1;

	//ジャンケンが行われた試合数を表す変数を宣言
	private int gameCount = INITIAL_GAME_COUNT;

	/*
	 * 関数名：readTactis
	 * 概要:
	 * 引数：なし
	 * 戻り値：ジャンケンの手を表す数字(int型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/01
	*/
	public int readTactics() {

		//ジャンケンの手を格納する変数を定義
		int jankenHand = 0;

		//試合回数が3の倍数+1の場合
		if (gameCount % JANKEN_TYPE_COUNT == FIRST_GAME_COUNT) {

			//ジャンケンの手をグーに設定
			jankenHand = STONE_NUMBER;
			//試合回数を加算
			gameCount++;

			//試合関数が3の倍数+2の場合
		} else if (gameCount % JANKEN_TYPE_COUNT == SECOND_GAME_COUNT) {

			//ジャンケンの手をチョキに設定
			jankenHand = SCISSORS_NUMBER;
			//試合回数を加算
			gameCount++;

			//試合回数が3の倍数の場合
		} else {

			//ジャンケンの手をパーに設定
			jankenHand = PAPER_NUMBER;
			//試合回数を加算
			gameCount++;
		}

		//ジャンケンの手を表示
		return jankenHand;
	}
}
