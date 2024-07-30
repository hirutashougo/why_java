package lesson_9.fantan;

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
	
	//手札を格納した配列において右端のカード番号を定数化
	public static final int RIGHT_EDN_NUMBER = 12;
	//手札を格納した配列において左端のカード番号を定数化
	public static final int LEFT_END_NUMBER = 1;
	//手札を格納した配列の調整数を定数化
	public static final int ADJUST_NUMBER = 1;
	//配列における最小の要素数を定数化
	public static final int MINIMUM_ELEMENT = 1;
	
	/*
	 * 関数名：findCandidate
	 * 概要:テーブルに出すことが可能なカードを探す
	 * 引数：手札(Hand型), ゲームに使用するテーブル(Table型)
	 * 戻り値：テーブルに出せるカードの組み合わせ(見つからない場合はnullを返す)(Card型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public Card[] findCandidate(Hand gameHand, Table gameTable) {
		
		//手札の枚数を確認
		int numberOfHand = gameHand.getNumberOfCards();

		//テーブルに置かれているカードを確認
		Card[][] gameTableCards = gameTable.getCard();

		//テーブルに置くことのできるカードの組み合わせの変数を宣言
		Card[] candidateCard = null;

		//手札のカードの回数分繰り返す処理
		for (int handOrder = 0; handOrder < numberOfHand; handOrder++) {

			//手元のカードを確認
			Card lookingCard = gameHand.lookCard(handOrder);
			//手元のカードのスートを確認
			int cardSuit = lookingCard.getSuit();
			//手元のカードの数字を確認
			int cardNumber = lookingCard.getNumber();
			
			//カードの数字を配列に合わせて調整
			int adjustmentNmber = cardNumber - ADJUST_NUMBER;
			
			//右側のカードの数字
			int rightSideNumber = (adjustmentNmber == RIGHT_EDN_NUMBER) ? RIGHT_EDN_NUMBER: adjustmentNmber + ADJUST_NUMBER;
			//左側のカードの数字
			int leftSideNumber = (cardNumber == LEFT_END_NUMBER) ? LEFT_END_NUMBER: adjustmentNmber - ADJUST_NUMBER;

			//テーブル上にカード列の右側に連ねて置ける場所があった場合
			if (gameTableCards[cardSuit - ADJUST_NUMBER][rightSideNumber] != null
					&& gameTableCards[cardSuit - ADJUST_NUMBER][adjustmentNmber] == null) {

				//テーブルに置けるカードがあると判断
				candidateCard = new Card[MINIMUM_ELEMENT];
				//テーブルに置けるカードを確認
				candidateCard[0] = gameHand.pickCard(handOrder);
				//処理を抜ける
				break;

				//テーブル上にカード列の左側に連ねて置ける場所があった場合
			} else if (gameTableCards[cardSuit - ADJUST_NUMBER][leftSideNumber] != null
					&& gameTableCards[cardSuit - ADJUST_NUMBER][adjustmentNmber] == null) {

				//テーブルに置けるカードがあると判断
				candidateCard = new Card[MINIMUM_ELEMENT];
				//テーブルに置けるカードを確認
				candidateCard[0] = gameHand.pickCard(handOrder);
				//処理を抜ける
				break;
			}
		}

		//テーブルに置くことのできるカードの組み合わせを返却
		return candidateCard;
	}

}
