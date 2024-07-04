package oldMaidRemake;

//trumpパッケージのCardクラスをインポート
import trump.Card;
import trump.Hand;
import trump.Rule;
import trump.Table;

public class OldMaidRule implements Rule {

	/*
	 * 関数名：findCandidate
	 * 概要:手札の中で数字が等しいカードの組み合わせを探す
	 * 引数：手札(Hand型), ゲームに使用するテーブル(Table型)
	 * 戻り値：テーブルに出せるカードの組み合わせ(見つからない場合はNULLを返す)(Card型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public Card[] findCandidate(Hand gameHand, Table gameTable) {

		//手札の枚数を確認
		int numberOfHand = gameHand.getNumberOfCards();

		//テーブルに置ける、数字が等しいカードの組み合わせの変数を宣言
		Card[] candidateCard = null;

		//手札の数字を一度全て覚えておくための配列を宣言
		int[] handNumbers = new int[numberOfHand];

		//手札の数字を覚えていく
		for (int handOrder = 0; handOrder < numberOfHand; handOrder++) {

			//手元のカードを確認
			Card lookingCard = gameHand.lookCard(handOrder);
			//手元のカードの数字を確認
			int cardNumber = lookingCard.getNumber();
			//数字を覚える
			handNumbers[handOrder] = cardNumber;
		}

		//同じ数字がないか、順番に確かめる
		for (int handOrder = 0; handOrder < numberOfHand; handOrder++) {

			//手元のカードを確認
			Card lookingCard = gameHand.lookCard(handOrder);
			//手元のカードの数字を確認
			int firstNumber = lookingCard.getNumber();
			
			//取り上げたカードと同じ数字がないか確かめていく
			for (int checkOrder = 0; checkOrder < numberOfHand; checkOrder++) {
				
				//比べるカードの数字を確認
				int secondNumber = lookingCard.getNumber();
				
				//別々のカードを比べていて、それらが同じ数字の場合
				if(checkOrder == handOrder && firstNumber == secondNumber) {
					
					//テーブルに置けるカードの組であると判断
					candidateCard = new Card[2];
					//最初のカードを確認
					candidateCard[0] = gameHand.pickCard(handOrder);
					//次のカードを確認
					candidateCard[1] = gameHand.pickCard(checkOrder);
					
					//同じカードを比べてしまっている場合
				} else {
					
					//比べない
					break;
				}
			}
		}

		//数字が同じのカードの組み合わせを返却
		return candidateCard;
	}
}
