package oldMaidRemake;


//trumpパッケージのCardクラスをインポート
import trump.Card;
//trumpパッケージのHandクラスをインポート
import trump.Hand;
//trumpパッケージのRuleクラスをインポート
import trump.Rule;
//trumpパッケージのTableクラスをインポート
import trump.Table;

/*
 * クラス名:OldMaidRule
 * 概要:ババ抜きのルールの情報を管理するクラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/02
 */
public class OldMaidRule implements Rule {

	/*
	 * 関数名：findCandidate
	 * 概要:手札の中で数字が等しいカードの組み合わせを探す
	 * 引数：手札(Hand型), ゲームに使用するテーブル(Table型)
	 * 戻り値：テーブルに出せるカードの組み合わせ(見つからない場合はNULLを返す)(Card[]型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public Card[] findCandidate(Hand gameHand, Table gameTable) {
		
		//テーブルへ捨てるカードの枚数を定数化
		final int CANDIDATE_CARD_COUNT = 2;

		//手札の枚数を確認
		int numberOfHand = gameHand.getNumberOfCards();

		//テーブルに置くことのできるカードの組み合わせの変数を宣言
		Card[] candidateCard = null;

		//手札のカードの回数分繰り返す処理
		OuterRoop: for (int handOrder = 0; handOrder < numberOfHand; handOrder++) {

			//手元のカードを確認
			Card lookingCard = gameHand.lookCard(handOrder);

			//同じ数字のカードがないか探す
			for (int checkOrder = 0; checkOrder < numberOfHand; checkOrder++) {

				//手元のカードを確認
				Card checkingCard = gameHand.lookCard(checkOrder);

				//対象のカードの数字を確認
				int handNumber = lookingCard.getNumber();
				//比較するカードの数字を確認
				int checkingNumber = checkingCard.getNumber();

				//異なる手札を比較して、カードの数字が同じ場合
				if (handOrder != checkOrder && handNumber == checkingNumber) {

					//捨てられるカードがあると判断
					candidateCard = new Card[CANDIDATE_CARD_COUNT];
					//テーブルに置けるカードを確認
					candidateCard[0] = gameHand.pickCard(handOrder);
					//テーブルに置けるカードを確認
					candidateCard[1] = gameHand.pickCard(checkOrder - 1);
					//処理を抜ける
					break OuterRoop;
				}
			}
		}

		//同じ数字の組み合わせを返却
		return candidateCard;
	}
}
