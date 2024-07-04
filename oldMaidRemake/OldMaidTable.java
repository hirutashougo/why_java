package oldMaidRemake;

//trumpパッケージのCardクラスをインポート
import trump.Card;
import trump.Table;

/*
 * クラス名:Table
 * 概要:ババ抜きのテーブルの情報を管理するクラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/02
 */
public class OldMaidTable implements Table {

	//テーブルの状態を表す行列を宣言
	private Card[][] gameTable = new Card[Card.SUIT_NUMBER][Card.CARD_NUMBER];

	/*
	 * 関数名：disposeCard
	 * 概要:
	 * 引数：なし
	 * 戻り値：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void putCard(Card[] playerCard) {

		//トランプの数字を取得
		int trumpNumber = playerCard[0].getNumber();
		//トランプのマークを取得
		int trumpSuit = playerCard[0].getSuit();

		//テーブルにトランプを並べる
		gameTable[trumpSuit - 1][trumpNumber - 1] = playerCard[0];

	}

	/*
	 * 関数名：getCard
	 * 概要:テーブルに置かれたカードを表す
	 * 引数：なし
	 * 戻り値：テーブルに置かれたカードを表す配列(Card[][]型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public Card[][] getCard() {

		//テーブルに置かれたカードを返却
		return gameTable;
	}
}
