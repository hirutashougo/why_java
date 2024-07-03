package oldMaid;

//ArrayListクラスをインポート
import java.util.ArrayList;

/*
 * クラス名:Hand
 * 概要:トランプの手札を表すクラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/02
 */
public class Hand {

	//
	private ArrayList<Card> playerHand = new ArrayList<>();

	/*
	 * 関数名：addCard
	 * 概要:
	 * 引数：なし
	 * 戻り値：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void addCard(Card specificCard) {
		//
		playerHand.add(specificCard);
	}

	/*
	 * 関数名：pickCard
	 * 概要:
	 * 引数：なし
	 * 戻り値：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public Card pickCard() {

		//
		Card pickedCard = (Card) playerHand.remove(0);

		//
		return pickedCard;
	}

	/*
	 * 関数名：shuffleCards
	 * 概要:
	 * 引数：なし
	 * 戻り値：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void shuffleCards() {

		//手札の数を取得
		int handNumber = playerHand.size();

		//カードを引き出す位置を設定
		int pullPosition;

		//
		for (int pullCount = 0; pullCount < handNumber * 2; pullCount++) {

			//カードを抜き取る位置をランダムに決定
			pullPosition = (int) (Math.random() * handNumber);
			//カードを抜き取る
			Card pickedCard = (Card) playerHand.remove(pullPosition);

			//抜き取ったカードを最後に加える
			playerHand.add(pickedCard);
		}
	}

	/*
	 * 関数名：getNumberOfCard
	 * 概要:
	 * 引数：なし
	 * 戻り値：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public int getNumberOfCards() {

		//
		return playerHand.size();
	}

	/*
	 * 関数名：getNumberOfCard
	 * 概要:
	 * 引数：なし
	 * 戻り値：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public Card[] findSameNumberCard() {

		//
		int numberOfCard = playerHand.size();
		//
		Card[] sameCards = null;

		//
		if (numberOfCard > 0) {

			//
			int lastIndex = numberOfCard - 1;
			//
			Card lastAddedCard = (Card) playerHand.get(lastIndex);

			//
			int lastAddedCardNumber = lastAddedCard.getNumber();

			//
			for (int cardInndex = 0; cardInndex < lastIndex; cardInndex++) {

				//
				Card card = (Card) playerHand.get(cardInndex);
				//
				if (card.getNumber() == lastAddedCardNumber) {

					//
					sameCards = new Card[2];
					//
					sameCards[0] = (Card) playerHand.remove(lastIndex);
					//
					sameCards[1] = (Card) playerHand.remove(cardInndex);

					//
					break;
				}
			}

		}
		//
		return sameCards;
	}

	/*
	 * 関数名：getNumberOfCard
	 * 概要:
	 * 引数：なし
	 * 戻り値：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public String toString() {

		//StringBufferクラスの変数を設定
		StringBuffer bufferString = new StringBuffer();

		//
		int size = playerHand.size();
		//
		if (size > 0) {

			//
			for (int index = 0; index < size; index++) {

				//
				Card card = (Card) playerHand.get(index);
				//
				bufferString.append(card);
				//
				bufferString.append(" ");
			}
		}

		//
		return bufferString.toString();
	}

}
