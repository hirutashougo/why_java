package fantan;

//trumpパッケージのCardクラスをインポート
import trump.Card;
//trumpパッケージのHandクラスをインポート
import trump.Hand;
//trumpパッケージのRuleクラスをインポート
import trump.Rule;
//trumpパッケージのTableクラスをインポート
import trump.Table;

/*
 * クラス名:FantanRule
 * 概要:七並べのルールの情報を管理するクラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/02
 */
public class FantanRule implements Rule {

	/*
	 * 関数名：findCandidate
	 * 概要:テーブルに出すことが可能なカードを探す。
	 * 引数：手札(Hand型), ゲームに使用するテーブル(Table型)
	 * 戻り値：テーブルに出せるカードの組み合わせ(見つからない場合はNULLを返す)(Card型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public Card[] findCandidate(Hand gameHand, Table gameTable) {

		//テーブルに置かれているカードを確認
		Card[][] gameTableCards = gameTable.getCard();
		//プレイヤーの手札を確認
		Card[] playerHandCards = gameHand.playerHand;
		//プレーヤーの手札のカードの順番を表す変数を宣言
		int handOrder = gameHand.getNumberOfCards();
		//テーブルの上にあるカードのマークの順番を表す変数を宣言
		int suitOrder = Card.SUIT_NUMBER;
		//テーブルの上にあるカードの数字の順番を表す変数を宣言
		int numberOrder = Card.CARD_NUMBER;

		//テーブルに置くことのできるカードの組み合わせの変数を宣言
		Card[] ableToPlaceCard = null;

		//カードの回数分繰り返す処理
		for (suitOrder = 0; suitOrder < Card.SUIT_NUMBER; suitOrder++) {

			//カードの数だけ繰り返す処理
			for (numberOrder = 0; numberOrder < Card.CARD_NUMBER; numberOrder++) {

				//テーブルに置く場所がある場合
				if () {

					//
					
				}
			}
		}

		//テーブルに置くことのできるカードの組み合わせを返却
		return ableToPlaceCard;
	}

}
