package lesson_9.fantan;

import trump.Card;
//
import trump.Master;
//
import trump.Player;
//
import trump.Rule;
//
import trump.Table;

/*
 * クラス名:FantanPlayer
 * 概要:七並べのプレイヤーの情報を管理するクラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/04
 */
public class FantanPlayer extends Player {

	//パスした回数を表すフィールドを宣言
	private int passCount = 0;

	/*
	 * コンストラクタ名：Player
	 * 概要:プレイヤーに関する情報を初期化して宣言
	 * 引数：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public FantanPlayer(String playerName, Master gameMaster, Table gameTable, Rule gameRule) {

		//スーパーコンストラクタを呼び出して各フィールドを初期化
		super(playerName, gameMaster, gameTable, gameRule);
	}

	/*
	 * 関数名：playGame
	 * 概要:順番を指名する
	 * 引数：次のプレイヤー(Player型)
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void playGame(Player nextPlayer) {
		
		//現在の手札を表示する
		System.out.println(" " + playerHand);
		
		//現在の手札からカードを探す
		Card[] ableToPlaceCard = gameRule.findCandidate(playerHand, gameTable);

		//カードが置ける場合
		if (ableToPlaceCard != null) {

			//カードを置いたと表示
			System.out.println(" " + ableToPlaceCard[0] + "を置きました。\n");

			//見つかったカードをテーブルに置く
			gameTable.putCard(ableToPlaceCard);
			
			//テーブルの状態を表示
			System.out.println(gameTable);
			
			//手札がなくなったら上がりを宣言
			if(playerHand.getNumberOfCards() == 0) {
				//
				gameMaster.declareWin(this);
			}
			
			//テーブルに置けるカードがない場合
		} else {

			//パス回数をカウントする
			passCount++;
			//パスを進行役に宣言
			((FantanMaster)gameMaster).declarePass(this);
		}

		//パスした回数が4回以上の場合、負け
		if (passCount > FantanMaster.PASS_LIMIT) {

			//手持ちのカードを全てテーブルに置く
			for(int processCount = 0; processCount < playerHand.getNumberOfCards(); processCount++) {
				
				//手持ちのカードを全てテーブルに置く
				gameTable.putCard(new Card[] {playerHand.pickCard(0)});
			}
		}

	}

	/*
	 * 関数名：receiveCard
	 * 概要:カードを受け取る
	 * 引数：受け取るカード(Card型)
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void receiveCard(Card receivedCard) {

		//受け取ったカードの数字を確認
		int receivedNumber = receivedCard.getNumber();
		
//		//受け取ったカードを格納しておく配列を宣言
//		Card[] holdingCard = new Card[1];
//		//受け取ったカードを手に持つ
//		holdingCard[0] = receivedCard;

		//受け取ったカードが7の場合
		if (receivedNumber == 7) {

			//テーブルにカードを置いたと宣言
			System.out.println(playerName + ":" + receivedCard + "を置きました。");
			//直ちにテーブルに置く
			gameTable.putCard(new Card[] {receivedCard});

			//受け取ったカードが7でない場合
		} else {

			//カードを手札に加える
			playerHand.addCard(receivedCard);
		}
	}

	/*
	 * 関数名：getPass
	 * 概要:パスをする
	 * 引数：なし
	 * 戻り値：パスをした回数(int型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/04
	*/
	public int getPass() {

		//パスした回数を返却する
		return passCount;
	}
}
