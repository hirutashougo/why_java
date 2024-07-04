package lesson_9;

import oldMaid.Master;
import oldMaid.Player;
import oldMaid.Table;
import trump.Card;
import trump.Hand;

/*
 * クラス名：RemakeOldMaid
 * 概要:ババ抜きを行うクラス
 * 引数：なし
 * 戻り値：なし
 * 作成者：S.Hiruta
 * 作成日：2024/07/02
*/
public class RemakeOldMaid {
	
	/*
	 * 関数名：main
	 * 概要:ババ抜きを行うクラス
	 * 引数：なし
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	private static Hand createTrump() {
		
		//
		Hand trump = new Hand();
		
		//
		for(int number = 1; number <= 13; number++) {
			
			//
			trump.addCard(new Card(Card.SUIT_CLUB, number));
			//
			trump.addCard(new Card(Card.SUIT_DIAMOND, number));
			//
			trump.addCard(new Card(Card.SUIT_HEART, number));
			//
			trump.addCard(new Card(Card.SUIT_SPADE, number));
		}
		
		//
		trump.addCard(new Card(0, Card.JOKER_CONSTANT));
		
		//
		return trump;
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

		//
		Master master = new Master();

		//
		Table field = new Table();

		//プレイヤー村田を生成
		Player murata = new Player("村田", master, field);
		//プレイヤー山田を生成
		Player yamada = new Player("山田", master, field);
		//プレイヤー齋藤を生成
		Player saito = new Player("齋藤", master, field);

		//進行役へプレイヤーを登録
		//村田を認識
		master.registerPlayer(murata);
		//山田を認識
		master.registerPlayer(yamada);
		//齋藤を認識
		master.registerPlayer(saito);
		
		//
		Hand trump = createTrump();
		
		//
		master.prepareGame(trump);
		
		//
		master.startGame();
	}

}
