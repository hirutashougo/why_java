package lesson_6;

import oldMaid.Card;
import oldMaid.Hand;
import oldMaid.Master;
import oldMaid.Player;
import oldMaid.Table;

/*
 * クラス名:OldMaid
 * 概要:ババ抜きを行うクラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/02
 */
public class OldMaid {
	
	/*
	 * 関数名：createTrump
	 * 概要:トランプの手を作る
	 * 引数：なし
	 * 戻り値：トランプの手札(Card型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	private static Hand createTrump() {
		
		//トランプの数字の最大値を表す定数を定義
		final int TRUMP_MUXIMUM_NUMBER = 13;
		//トランプの数字の最小数を表す定数を定義
		final int TRUMP_MINIMUM_NUMBER = 1;
		
		//トランプの手を格納する変数を定義
		Hand trumpHand = new Hand();
		
		//トランプの数とスートを組み合わせる
		for(int number = TRUMP_MINIMUM_NUMBER; number <= TRUMP_MUXIMUM_NUMBER; number++) {
			
			//クローバーのスートのカードを作る
			trumpHand.addCard(new Card(Card.SUIT_CLUB, number));
			//ダイヤモンドのスートのカードを作る
			trumpHand.addCard(new Card(Card.SUIT_DIAMOND, number));
			//ハートのスートのカードを作る
			trumpHand.addCard(new Card(Card.SUIT_HEART, number));
			//スペードのスートのカードを作る
			trumpHand.addCard(new Card(Card.SUIT_SPADE, number));
		}
		
		//ジョーカーを作る
		trumpHand.addCard(new Card(0, Card.JOKER_CONSTANT));
		
		//トランプの手札を返却
		return trumpHand;
	}

	/*
	 * 関数名：main
	 * 概要:ババ抜きを行うクラス
	 * 引数：なし
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public static void main(String[] args) {

		//ゲームマスターを生成
		Master gameMaster = new Master();

		//ゲームで使用するテーブルを生成
		Table gameField = new Table();

		//プレイヤー村田を生成
		Player murata = new Player("村田", gameMaster, gameField);
		//プレイヤー山田を生成
		Player yamada = new Player("山田", gameMaster, gameField);
		//プレイヤー齋藤を生成
		Player saito = new Player("齋藤", gameMaster, gameField);

		//進行役へプレイヤーを登録
		//村田を認識
		gameMaster.registerPlayer(murata);
		//山田を認識
		gameMaster.registerPlayer(yamada);
		//齋藤を認識
		gameMaster.registerPlayer(saito);
		
		//
		Hand trump = createTrump();
		
		//
		gameMaster.prepareGame(trump);
		
		//
		gameMaster.startGame();
	}

}
