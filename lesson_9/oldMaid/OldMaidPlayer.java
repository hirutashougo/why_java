package lesson_9.oldMaid;

//乱数生成クラスをインポート
import java.util.Random;

//trumpパッケージのCardクラスをインポート
import trump.Card;
//trumpパッケージのHandクラスをインポート
import trump.Hand;
//trumpパッケージのMasterクラスをインポート
import trump.Master;
//trumpパッケージのPlayerクラスをインポート
import trump.Player;
//trumpパッケージのRuleクラスをインポート
import trump.Rule;
//trumpパッケージのTableクラスをインポート
import trump.Table;

/*
 * クラス名:Player
 * 概要:ババ抜きのプレイヤーの情報を管理するクラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/02
 */
public class OldMaidPlayer extends Player {
	
	//乱数生成のための変数を宣言
	Random randomnumber = new Random();
	
	//手札の最小数を定数で宣言
	static final int MINIMUM_HAND_NUMBER = 1;

	/*
	 * コンストラクタ名：OldMaidPlayer
	 * 概要:プレイヤーに関する情報を初期化して宣言
	 * 引数：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public OldMaidPlayer(String playerName, Master gameMaster, Table gameTable, Rule gameRule) {

		//スーパーコンストラクタを呼び出して各フィールドを初期化
		super(playerName, gameMaster, gameTable, gameRule);
	}

	/*
	 * 関数名：playGame
	 * 概要:順番を指名する
	 * 引数：なし
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void playGame(Player nextPlayer) {

		//引く相手の手札に向かい合う
		Hand nextHand = ((OldMaidPlayer) nextPlayer).showHand();

		//カードを引く相手の手札の数を確認
		int rndomRange = nextHand.getNumberOfCards();
		//手札からどのカードを引くか決める
		int rndomNumber = randomnumber.nextInt(rndomRange);
		//手札からカードを引く
		Card pickedCard = nextHand.pickCard((int)rndomNumber);

		//誰から何を引いたか宣言
		System.out.println(this + ":" + nextPlayer + "さんから" + pickedCard + "を引きました");

		//引いたカードを手札に加え、同じものがあればテーブルに捨てる
		playerHand.addCard(pickedCard);

		//同じ数のカードを探す
		Card[] sameCards = gameRule.findCandidate(playerHand, gameTable);

		//同じ数のカードがあった場合
		if (sameCards != null) {

			//捨てる組み合わせを見せる
			System.out.print(this + ":");
			//カードをテーブルに捨てる
			gameTable.putCard(sameCards);
			
			//手札がなくなったら上がりを宣言
			if (playerHand.getNumberOfCards() == 0) {
				//勝利を宣言
				gameMaster.declareWin(this);

				//手札がまだある場合
			} else {

				//残りの手札数を提示
				System.out.println(this + ":残りの手札は" + playerHand + "です");
			}
		}
	}

	/*
	 * 関数名：showHand
	 * 概要:手札を見せる
	 * 引数：なし
	 * 戻り値：手札(Hand型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public Hand showHand() {

		//手札が残り一枚の場合
		if (playerHand.getNumberOfCards() == MINIMUM_HAND_NUMBER) {

			//勝利を宣言
			gameMaster.declareWin(this);
		}

		//手札をシャッフルする
		playerHand.shuffleCards();

		//手札を見せる
		return playerHand;
	}

	/*
	 * 関数名：receiveCard
	 * 概要:
	 * 引数：なし
	 * 戻り値：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void receiveCard(Card receivedCard) {

		//引いたカードを手札に加える
		super.receiveCard(receivedCard);

		//同じ数のカードを探す
		Card[] sameCards = gameRule.findCandidate(playerHand, (OldMaidTable) gameTable);

		//同じ数のカードがあった場合
		if (sameCards != null) {

			//捨てる組み合わせを見せる
			System.out.print(this + ":");
			//カードをテーブルに捨てる
			gameTable.putCard(sameCards);
		}
	}
}
