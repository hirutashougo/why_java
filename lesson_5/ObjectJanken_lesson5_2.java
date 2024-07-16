package lesson_5;

//lesson_5.jankenパッケージのCycleTacticsクラスをインポート
import lesson_5.janken.CycleTactics;
//lesson_5.jankenパッケージのJudgeクラスをインポート
import lesson_5.janken.Judge;
//lesson_5.jankenパッケージのPlayerクラスをインポート
import lesson_5.janken.Player;
//lesson_5.jankenパッケージのRandomTacticsクラスをインポート
import lesson_5.janken.RandomTactics;
//lesson_5.jankenパッケージのTacticsインタフェースをインポート
import lesson_5.janken.Tactics;

/*
 * クラス名:ObjectJanken
 * 概要:戦略インタフェースに対応したジャンケンプログラム
 * 作成者:S.Hiruta
 * 作成日:2024/07/01
 */
public class ObjectJanken_lesson5_2 {

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

		//最初のプレイヤー(村田さん)の生成
		Player playerMurata = new Player("村田さん");

		//村田さんに渡す戦略クラスの生成(ジャンケンの手は周期的に出る)
		Tactics murataTactics = new CycleTactics();

		//村田さんに戦略クラスを渡す
		playerMurata.setTactics(murataTactics);

		//次のプレイヤー(山田さん)の生成
		Player playerYamada = new Player("山田さん");

		//山田さんに渡す戦略クラスの生成(ジャンケンの手はランダムに出る)
		Tactics yamadaTactics = new RandomTactics();

		//山田さんに戦略クラスを渡す
		playerYamada.setTactics(yamadaTactics);
		
		//村田さんと山田さんをプレイヤーとしてジャンケンを開始する
		jankenJudge.startJanken(playerMurata, playerYamada);
	}

}
