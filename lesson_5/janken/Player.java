package lesson_5.janken;

/*
 * クラス名:PlayerWithInterface
 * 概要:ジャンケンのプレイヤーの情報を管理
 * 作成者:S.Hiruta
 * 作成日:2024/07/01
 */
public class Player {

	//グーを表す定数を定義
	public static final int STONE_NUMBER = 0;
	//チョキを表す定数を定義
	public static final int SCISSORS_NUMBER = 1;
	//パーを表す定数を定義
	public static final int PAPER_NUMBER = 2;
	//ジャンケンの勝利数を加算する際に用いる定数を宣言
	public static final int ADD_WIN_COUNT = 1;

	//プレイヤーの名前を表すフィールドを宣言
	private String playerName = "";
	//プレイヤーの勝った回数を表すフィールドを宣言
	private int winCount = 0;
	//戦略インタフェースから与えられるジャンケンの手を表す数字を宣言
	private Tactics jankenNumber;

	/*
	 * コンストラクタ名：Player
	 * 概要:ジャンケンプレイヤーの名前を初期化して宣言
	 * 引数：ジャンケンプレイヤーの名前(String型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/06/28
	*/
	public Player(String inputName) {
		//ジャンケンプレイヤーの名前を入力値で初期化
		playerName = inputName;
	}

	/*
	 * 関数名：showHand
	 * 概要:ジャンケンの手を決める
	 * 引数：なし
	 * 戻り値：ジャンケンの手を表す数字(int型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/01
	*/
	public void setTactics(Tactics jankenTactics) {

		//与えられた数字で、ジャンケンの手を初期化
		jankenNumber = jankenTactics;
	}

	/*
	 * 関数名：showHand
	 * 概要:ジャンケンの手を決める
	 * 引数：なし
	 * 戻り値：ジャンケンの手
	 * 作成者：S.Hiruta
	 * 作成日：2024/06/28
	*/
	public int showHand() {

		//与えられた戦略を読んでジャンケンの手を決める
		int playerHand = jankenNumber.readTactics();

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
	public void notifyResult(boolean gaemResult) {

		//ジャンケンに勝った場合
		if (true == gaemResult) {
			//勝った回数を1加算する
			winCount += ADD_WIN_COUNT;
		}
	}

	/*
	 * 関数名：getWinCount
	 * 概要:自分の勝った回数を取得する(ジャンケンに勝った回数を返却する)
	 * 引数：なし
	 * 戻り値：ジャンケンに勝った回数(int型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/06/28
	*/
	public int getWinCount() {

		//勝利回数を返却
		return winCount;
	}

	/*
	 * 関数名：getName
	 * 概要:プレイヤーの名前を取得する
	 * 引数：なし
	 * 戻り値：ジャンケンプレイヤーの名前(int型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/06/28
	*/
	public String getName() {

		//ジャンケンプレイヤーの名前を返却
		return playerName;
	}

}
