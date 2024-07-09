package lesson_2;

//乱数生成のためのクラスをインポート
import java.util.Random;

/*
 * クラス名:SimpleJanken
 * 概要:オブジェクト指向を使用しないジャンケンプログラム
 * 作成者:S.Hiruta
 * 作成日:2024/06/27
 */
public class SimpleJanken {

	//ジャンケンの手を表す定数を宣言
	//グーを表す定数を定義
	public static final int STONE_NUMBER = 0;
	//チョキを表す定数を定義
	public static final int SCISSORS_NUMBER = 1;
	//パーを表す定数を定義
	public static final int PAPER_NUMBER = 2;
	//対戦回数を表す定数を定義
	public static final int GAME_COUNT = 3;
	//対戦回数の表示を調整するための定数を宣言
	public static final int GAME_COUNT_ADJUSTMENT = 1;
	//ジャンケンの手の種類の数を定数化
	public static final int JANKEN_TYPE_COUNT = 3;
	//ジャンケンの手を決める乱数の範囲を調整する定数を宣言
	public static final int JANKEN_TYPE_COUNT_ADJUSTMENT = -1;

	/*
	 * 関数名：main
	 * 概要:オブジェクト指向を使用しないジャンケンプログラム
	 * 引数：なし
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/06/27
	*/
	public static void main(String[] args) {

		//プログラムが開始したことを表示する
		//プログラム開始のメッセージを表示する
		System.out.println("【ジャンケン開始】\n");

		//プレイヤー1の勝ち数
		int firstPlayerWinCount = 0;

		//プレイヤー2の勝ち数
		int secondPlayerWinCount = 0;

		//ジャンケンを3回実施する
		//勝負した回数を加算する
		//3回勝負が終わったか?
		for (int count = 0; count < GAME_COUNT; count++) {

			//対戦回数の表示と対戦開始の宣言
			System.out.print("【" + (count + GAME_COUNT_ADJUSTMENT) + "回戦目】\n");

			//乱数生成クラスの変数を宣言
			Random randomNumber = new Random();

			//プレイヤーの手を格納する変数を定義
			int firstPlayerHand = 0;

			//乱数を格納するための定数を定義
			double firstJankenNumber = 0;

			//0以上2未満の少数として乱数を得る
			firstJankenNumber = randomNumber.nextInt(JANKEN_TYPE_COUNT + JANKEN_TYPE_COUNT_ADJUSTMENT);

			//生成された乱数が1未満の場合
			if (firstJankenNumber == STONE_NUMBER) {
				//グーを選択
				firstPlayerHand = STONE_NUMBER;
				//プレイヤーの手を表示する
				System.out.print("グー");

				//生成された乱数が(1以上)2未満の場合
			} else if (firstJankenNumber == SCISSORS_NUMBER) {
				//チョキを選択
				firstPlayerHand = SCISSORS_NUMBER;
				//プレイヤーの手を表示する
				System.out.print("チョキ");

				//生成された乱数が(2以上)3未満の場合
			} else if (firstJankenNumber == PAPER_NUMBER) {
				//パーを選択
				firstPlayerHand = PAPER_NUMBER;
				//プレイヤーの手を表示する
				System.out.print("パー");
			}

			//vsと表示
			System.out.print("vs.");

			//プレイヤーの手を格納する変数を定義
			int secondPlayerHand = 0;

			//乱数を格納するための定数を定義
			double secondjankenNumber = 0;

			//0以上2未満の少数として乱数を得る
			secondjankenNumber = randomNumber.nextInt(JANKEN_TYPE_COUNT + JANKEN_TYPE_COUNT_ADJUSTMENT);

			//生成された乱数が1未満の場合
			if (secondjankenNumber == STONE_NUMBER) {
				//グーを選択
				secondPlayerHand = STONE_NUMBER;
				//プレイヤーの手を表示する
				System.out.print("グー");

				//生成された乱数が(1以上)2未満の場合
			} else if (secondjankenNumber == SCISSORS_NUMBER) {
				//チョキを選択
				secondPlayerHand = SCISSORS_NUMBER;
				//プレイヤーの手を表示する
				System.out.print("チョキ");

				//生成された乱数が(2以上)3未満の場合
			} else if (secondjankenNumber == PAPER_NUMBER) {
				//パーを選択
				secondPlayerHand = PAPER_NUMBER;
				//プレイヤーの手を表示する
				System.out.print("パー");
			}
			//どちらが勝ちかを判定し、結果を表示する
			//プレイヤー1が勝つ場合
			if ((firstPlayerHand == STONE_NUMBER && secondPlayerHand == SCISSORS_NUMBER)
					|| (firstPlayerHand == SCISSORS_NUMBER && secondPlayerHand == PAPER_NUMBER)
					|| (firstPlayerHand == PAPER_NUMBER && secondPlayerHand == STONE_NUMBER)) {

				//プレイヤー1が勝った回数を加算する
				firstPlayerWinCount++;

				//ジャンケンの結果を表示する
				System.out.println("\nプレイヤー1が勝ちました!\n");

				//プレイヤー2が勝つ場合
			} else if ((secondPlayerHand == STONE_NUMBER && firstPlayerHand == SCISSORS_NUMBER)
					|| (secondPlayerHand == SCISSORS_NUMBER && firstPlayerHand == PAPER_NUMBER)
					|| (secondPlayerHand == PAPER_NUMBER && firstPlayerHand == STONE_NUMBER)) {

				//プレイヤー2が勝った回数を加算する
				secondPlayerWinCount++;

				//ジャンケンの結果を表示する
				System.out.println("\nプレイヤー2が勝ちました!\n");

				//引き分けの場合
			} else {

				//ジャンケンの結果を表示する
				System.out.println("\n引き分けです!\n");
			}
		}

		//最終的な勝者を判定し、画面に表示する
		System.out.println("【ジャンケン終了】\n");

		//プレイヤー1の勝ち数が多いとき
		if (firstPlayerWinCount > secondPlayerWinCount) {

			//プレイヤー1の勝ちを表示する
			System.out.println(firstPlayerWinCount + "対" + secondPlayerWinCount + "でプレイヤー1の勝ちです!\n");

			//プレイヤー2の勝ち数が多いとき
		} else if (firstPlayerWinCount < secondPlayerWinCount) {

			//プレイヤー2の勝ちを表示する
			System.out.println(firstPlayerWinCount + "対" + secondPlayerWinCount + "でプレイヤー2の勝ちです!\n");

			//プレイヤー1とプレイヤー2の勝ち数が同じとき
		} else if (firstPlayerWinCount == secondPlayerWinCount) {

			//引き分けを表示する
			System.out.println(firstPlayerWinCount + "対" + secondPlayerWinCount + "で引き分けです!\n");
		}
	}

}
