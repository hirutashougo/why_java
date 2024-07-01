package jankenWithInterface;

//BufferedReaderクラスをインポート
import java.io.BufferedReader;
//InputStreamReaderクラスをインポート
import java.io.InputStreamReader;

/*
 * クラス名:AskTactics
 * 概要:標準入力によりジャンケンの手をユーザーに聞く戦略クラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/01
 */
public class AskTactics implements Tactics {

	//ジャンケンの手を表す定数を宣言
	//グーを表す定数を定義
	public static final int STONE_NUMBER = 0;
	//チョキを表す定数を定義
	public static final int SCISSORS_NUMBER = 1;
	//パーを表す定数を定義
	public static final int PAPER_NUMBER = 2;

	/*
	 * 関数名：readTactis
	 * 概要:戦略を読み、ジャンケンの手を得る。
	 * 		グー・チョキ・パーのいずれかをPlayerクラスに定義された以下の定数で返す。
	 * 		Player.STONE_NUMBER … グー
	 * 		Player.SCISSORS_NUMBER … チョキ
	 * 		Player.PAPER_NUMBER … パー
	 * 引数：なし
	 * 戻り値：ジャンケンの手を表す数字(int型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/01
	*/
	public int readTactics() {

		//BufferedReaderクラスの変数を設定
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		//ジャンケンの入力を促す
		System.out.println("/nジャンケンを入力してください。");
		//グーの表示
		System.out.println("0：グー");
		//チョキの表示
		System.out.println("1：チョキ");
		//パーの表示
		System.out.println("2：パー");
		//?の表示
		System.out.print("?");

		//ジャンケンの手を格納する変数を宣言
		int jankenHand = 0;

		//正しい値が入力されるまで繰り返す処理
		while (true) {
			//
			try {
				//ジャンケンの手を表す数字を格納する変数を定義
				String inputString = bufferedReader.readLine();

				//ジャンケンの手を表す数字を入力させる
				jankenHand = Integer.parseInt(inputString);

				//入力された数字がジャンケンの手の場合
				if (jankenHand == Player.STONE_NUMBER
						|| jankenHand == Player.SCISSORS_NUMBER
						|| jankenHand == Player.PAPER_NUMBER) {

					//処理を終了する
					break;

					//入力された数字がジャンケンの手以外の場合
				} else {

					//再入力を要請する
					System.out.println("入力が正しくありません。再度入力してください。");
					//?の表示
					System.out.print("?");
				}
				
			//例外発生時の処理の定義
			} catch (Exception exceptionNumber) {

				//再入力を要請する
				System.out.println("入力が正しくありません。再度入力してください。");
				//?の表示
				System.out.print("?");
			}
		}

		//ジャンケンの手を表示
		return jankenHand;
	}
}
