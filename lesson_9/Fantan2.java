package lesson_9;

import fantan.FantanMaster;
import fantan.FantanPlayer;
import fantan.FantanRule;
import fantan.FantanTable;
//
import trump.Card;
import trump.Hand;
import trump.Master;
import trump.Player;
import trump.Rule;
import trump.Table;

/*
 * クラス名：Fantan
 * 概要:七並べを行うクラス
 * 引数：なし
 * 戻り値：なし
 * 作成者：S.Hiruta
 * 作成日：2024/07/02
*/
public class Fantan2 {

	/*
	 * 関数名：createTrump
	 * 概要:トランプのカードを生成する
	 * 引数：なし
	 * 戻り値：トランプの全カードの手札(Hand型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/04
	*/
	private static Hand createTrump() {

		//トランプの数字の最大値を表す定数を定義
		final int TRUMP_MUXIMUM_NUMBER = 13;
		//トランプの数字の最小数を表す定数を定義
		final int TRUMP_MINIMUM_NUMBER = 1;

		//全トランプの手札を格納する変数を宣言
		Hand trumpHand = new Hand();

		//スートごとにトランプのカードを揃える
		for (int number = TRUMP_MINIMUM_NUMBER; number <= TRUMP_MUXIMUM_NUMBER; number++) {

			//クローバーを揃える
			trumpHand.addCard(new Card(Card.SUIT_CLUB, number));
			//ダイヤモンドを揃える
			trumpHand.addCard(new Card(Card.SUIT_DIAMOND, number));
			//ハートを揃える
			trumpHand.addCard(new Card(Card.SUIT_HEART, number));
			//スペードを揃える
			trumpHand.addCard(new Card(Card.SUIT_SPADE, number));
		}

		//揃えたカードを返却
		return trumpHand;
	}

	/*
	 * 関数名：main
	 * 概要:七並べを行うクラス
	 * 引数：なし
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public static void main(String[] args) {

		//進行役の生成
		Master gameMaster = new FantanMaster();

		//テーブルの生成
		Table gameTable = new FantanTable();

		//ルールの生成
		Rule gameRule = new FantanRule();

		//プレイヤー村田の生成
		Player playerMurata = new FantanPlayer("村田", gameMaster, gameTable, gameRule);
		//プレイヤー山田の生成
		Player playerYamada = new FantanPlayer("山田", gameMaster, gameTable, gameRule);
		//プレイヤー齋藤の生成
		Player playerSaito = new FantanPlayer("齋藤", gameMaster, gameTable, gameRule);

		//進行役へ、プレイヤー村田を登録
		gameMaster.registerPlayer(playerMurata);
		//進行役へ、プレイヤー山田を登録
		gameMaster.registerPlayer(playerYamada);
		//進行役へ、プレイヤー齋藤を登録
		gameMaster.registerPlayer(playerSaito);

		//トランプの生成
		Hand gameTrump = createTrump();

		//ゲームの準備をする
		gameMaster.prepareGame(gameTrump);

		//トランプを配置したテーブルを表示する
		System.out.println(gameTable);
	}

}
