package lesson_5;

import jankenWithInterface.AskTactics;
//jankenWithInterfaceパッケージのJudgeクラスをインポート
import jankenWithInterface.Judge;
import jankenWithInterface.Player;
import jankenWithInterface.RandomTactics;
import jankenWithInterface.Tactics;

/*
 * クラス名:ObjectJanken
 * 概要:戦略インタフェースに対応したジャンケンプログラム
 * 作成者:S.Hiruta
 * 作成日:2024/07/01
 */
public class ObjectJanken {

	/*
	 * 関数名:main
	 * 概要:戦略インタフェースに対応したジャンケンプログラム
	 * 引数:なし
	 * 戻り値:なし
	 * 作成者:S.Hiruta
	 * 作成日:2024/07/01
	 */
	public static void main(String[] args) {

		//審判のインスタンスを生成
		Judge jankenJudge = new Judge();

		//プレイヤー1(村田さん)の生成
		Player playerMurata = new Player("村田さん");

		//村田さんに渡す戦略クラスの生成
		Tactics murataTactics = new AskTactics();

		//村田さんに戦略クラスを渡す
		playerMurata.setTactics(murataTactics);

		//プレイヤー2(山田さん)の生成
		Player playerYamada = new Player("山田さん");

		//山田さんに渡す戦略クラスの生成
		Tactics yamadaTactics = new RandomTactics();

		//山田さんに戦略クラスを渡す
		playerYamada.setTactics(yamadaTactics);
		
		//村田さんと山田さんをプレイヤーとしてジャンケンを開始する
		jankenJudge.startJanken(playerMurata, playerYamada);
	}

}
