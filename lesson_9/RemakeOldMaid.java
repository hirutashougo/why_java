package lesson_9;

//oldMaidRemakeパッケージのOldMaidPlayerクラスをインポート
import oldMaidRemake.OldMaidPlayer;
//oldMaidRemakeパッケージのOldMaidRuleクラスをインポート
import oldMaidRemake.OldMaidRule;
//oldMaidRemakeパッケージのOldMaidTableクラスをインポート
import oldMaidRemake.OldMaidTable;
//trumpパッケージのCardクラスをインポート
import trump.Card;
//trumpパッケージのHandクラスをインポート
import trump.Hand;
//trumpパッケージのJokerクラスをインポート
import trump.Joker;
//trumpパッケージのMasterクラスをインポート
import trump.Master;
//trumpパッケージのPlayerクラスをインポート
import trump.Player;
//trumpパッケージのRuleクラスをインポート
import trump.Rule;
//trumpパッケージのTableクラスをインポート
import trump.Table;

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
		
		//トランプを用意する
		Hand trump = new Hand();
		
		//スートごとにトランプを生成
		for(int number = 1; number <= Card.CARD_NUMBER; number++) {
			
			//クローバーのトランプを生成
			trump.addCard(new Card(Card.SUIT_CLUB, number));
			//ダイヤモンドのトランプを生成
			trump.addCard(new Card(Card.SUIT_DIAMOND, number));
			//ハートのトランプを生成
			trump.addCard(new Card(Card.SUIT_HEART, number));
			//スペードのトランプを生成
			trump.addCard(new Card(Card.SUIT_SPADE, number));
		}
		
		//ジョーカーを生成
		trump.addCard(new Joker());
		
		//用意したトランプを返却
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

		//ゲームの進行役を呼ぶ
		Master gameMaster = new Master();
		
		//ルールの生成
		Rule gameRule = new OldMaidRule();

		//テーブルの生成
		Table gameTable = new OldMaidTable();

		//プレイヤー村田の生成
		Player playerMurata = new OldMaidPlayer("村田", gameMaster, gameTable, gameRule);
		//プレイヤー山田の生成
		Player playerYamada = new OldMaidPlayer("山田", gameMaster, gameTable, gameRule);
		//プレイヤー齋藤の生成
		Player playerSaito = new OldMaidPlayer("齋藤", gameMaster, gameTable, gameRule);

		//進行役へプレイヤーを登録
		//村田を認識
		gameMaster.registerPlayer(playerMurata);
		//山田を認識
		gameMaster.registerPlayer(playerYamada);
		//齋藤を認識
		gameMaster.registerPlayer(playerSaito);
		
		//トランプを生成
		Hand gameTrump = createTrump();
		
		//ゲームの準備をする
		gameMaster.prepareGame(gameTrump);
		
		//ゲームを開始する
		gameMaster.startGame();
	}

}
