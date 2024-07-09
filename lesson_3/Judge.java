package lesson_3;

/*
 * クラス名:startJanken
 * 概要:ジャンケンの審判を表すクラス
 * 作成者:S.Hiruta
 * 作成日:2024/06/28
 */
public class Judge {

	//グーを表す定数を定義
	public static final int STONE_NUMBER = 0;
	//チョキを表す定数を定義
	public static final int SCISSORS_NUMBER = 1;
	//パーを表す定数を定義
	public static final int PAPER_NUMBER = 2;
	//ジャンケンの手種類の数を定数化
	public static final int JANKEN_RANGE = 3;
	//対戦回数を表す定数を定義
	public static final int GAME_COUNT = 3;
	//対戦回数の表示を調整するための定数を宣言
	public static final int GAME_COUNT_ADJUSTMENT = 1;

	/*
	 * 関数名：startJanken
	 * 概要:二人でジャンケンを行う
	 * 引数：二人のプレイヤー(Player型)
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/06/28
	*/
	public void startJanken(Player firstPlayer, Player secondPlayer) {

		//ジャンケンの開始を宣言する
		System.out.println("【ジャンケン開始】\n");

		//ジャンケンを三回行う
		for (int count = 0; count < GAME_COUNT; count++) {

			//何回戦目か表示する
			System.out.println("【" + (count + GAME_COUNT_ADJUSTMENT) + "回戦目】");

			//プレイヤーの手を見て、どちらが勝ちか判定する
			Player jankenWinner = judgeJanken(firstPlayer, secondPlayer);

			//ジャンケンが行われた場合
			if (jankenWinner != null) {

				//勝者を表示する
				System.out.println("\n" + jankenWinner.getName() + "が勝ちました!\n");

				//勝ったプレイヤーに結果を伝える
				jankenWinner.notifyResult(true);

				//引き分けの場合
			} else {
				//引き分けの場合
				System.out.println("\n引き分けです!\n");
			}

		}

		//ジャンケンの終了を伝える
		System.out.println("【ジャンケン終了】\n");

		//最終的な勝者を判定する
		Player finalWinner = judgeFinalWinner(firstPlayer, secondPlayer);

		//結果の表示
		System.out.println(firstPlayer.getWinCount() + "対" + secondPlayer.getWinCount() + "で");

		//勝敗がついている場合
		if (finalWinner != null) {
			//最終的な勝者を表示
			System.out.print(finalWinner.getName() + "の勝ちです!\n");

			//引き分けの場合
		} else {
			//引き分けを伝える
			System.out.println("\n引き分けです!\n");
		}

	}

	/*
	 * 関数名：judgeJanken
	 * 概要:二人のジャンケンの勝敗を決める
	 * 引数：二人のプレイヤー(Player型)
	 * 戻り値：勝ったほうのプレイヤー(Player型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/06/28
	*/
	private Player judgeJanken(Player firstPlayer, Player secondPlayer) {

		//勝者を表す変数を定義
		Player winner = null;

		//プレイヤー1の手を出す
		int firstPlayerHand = firstPlayer.showHand();

		//プレイヤー2の手を出す
		int secondPlayerHand = secondPlayer.showHand();

		//それぞれの手を表示する
		//プレイヤー1の手を表示
		printHand(firstPlayerHand);
		//vsと表示する
		System.out.print("vs.");
		//プレイヤー1の手を表示
		printHand(secondPlayerHand);
		//改行する
		System.out.print("\n");

		//プレイヤー1が勝つ場合
		if ((firstPlayerHand == STONE_NUMBER && secondPlayerHand == SCISSORS_NUMBER)
				|| (firstPlayerHand == SCISSORS_NUMBER && secondPlayerHand == PAPER_NUMBER)
				|| (firstPlayerHand == PAPER_NUMBER && secondPlayerHand == STONE_NUMBER)) {

			//プレイヤー1が勝者
			winner = firstPlayer;
		}

		//プレイヤー2が勝つ場合
		if ((secondPlayerHand == STONE_NUMBER && firstPlayerHand == SCISSORS_NUMBER)
				|| (secondPlayerHand == SCISSORS_NUMBER && firstPlayerHand == PAPER_NUMBER)
				|| (secondPlayerHand == PAPER_NUMBER && firstPlayerHand == STONE_NUMBER)) {

			//プレイヤー2が勝者
			winner = secondPlayer;
		}

		//どちらでもない場合は引き分け(nullを返す)
		return winner;
	}

	/*
	 * 関数名：judgeFinalWinner
	 * 概要:ジャンケンの総合的な勝者を決定する
	 * 引数：二人のプレイヤー(Player型)
	 * 戻り値：勝ったほうのプレイヤー(Player型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/06/28
	*/
	public Player judgeFinalWinner(Player firstPlayer, Player secondPlayer) {

		//総合勝者を表す変数を宣言
		Player jankenWinner = null;

		//プレイヤー1の勝利数を取得
		int firstPlayerWinCount = firstPlayer.getWinCount();

		//プレイヤー2の勝利数を取得
		int secondPlayerWinCount = secondPlayer.getWinCount();

		//プレイヤー1が多く勝った場合
		if (firstPlayerWinCount > secondPlayerWinCount) {

			//プレイヤー1が勝者
			jankenWinner = firstPlayer;

			//プレイヤー2が多く勝った場合
		} else if (firstPlayerWinCount < secondPlayerWinCount) {

			//プレイヤー2が勝者
			jankenWinner = secondPlayer;
		}

		//勝者を返却。引き分けの場合はnullを返却。
		return jankenWinner;
	}

	/*
	 * 関数名：printHand
	 * 概要:ジャンケンの手を表示
	 * 引数：ジャンケンの手(int型)
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/06/28
	*/
	public void printHand(int playerHand) {

		//ジャンケンの手によって違う表示をする
		switch (playerHand) {

		//グーの場合
		case Player.STONE_NUMBER:
			//グーと表示
			System.out.print("グー");
			//処理を終了
			break;

		//チョキの場合
		case Player.SCISSORS_NUMBER:
			//チョキを表示
			System.out.print("チョキ");
			//処理を終了
			break;

		//パーの場合
		case Player.PAPER_NUMBER:
			//パーを表示
			System.out.print("パー");
			//処理を終了
			break;

		//3つの手のどれでもない場合
		default:
			//何もせずに処理を終了
			break;
		}
	}

}
