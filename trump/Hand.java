package trump;

//ArrayListクラスをインポート
import java.util.ArrayList;

/*
 * クラス名:Hand
 * 概要:トランプの手札を表すクラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/02
 */
public class Hand {

	//手札にあるカードを保持するためのリスト
	private ArrayList<Card> playerHand = new ArrayList<>();

	/*
	 * 関数名：addCard
	 * 概要:カードを加える
	 * 引数：加えるカード(Card型)
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void addCard(Card specificCard) {
		//カードをリストの最後に追加する
		playerHand.add(specificCard);
	}

	/*
	 * 関数名：lookCard
	 * 概要:カードを見る
	 * 引数：カードの置位を指定する数字(int型)
	 * 戻り値：指定したカード(Card型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public Card lookCard(int cardPosition) {

		//指定カードの位置を表す変数を宣言
		Card lookingCard = null;

		//指定カードが存在可能な位置である場合
		if ((0 <= cardPosition) && (cardPosition < playerHand.size())) {

			//カードの位置を指定
			lookingCard = (Card) playerHand.get(cardPosition);
		}
		//指定した位置のカードを返却
		return lookingCard;
	}

	/*
	 * 関数名：pickCard
	 * 概要:カードを引く
	 * 引数：カードの置位を指定する数字(int型)
	 * 戻り値：指定位置のカード(Card型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public Card pickCard(int cardPosition) {

		//指定カードの位置を表す変数を宣言
		Card pickedCard = null;

		//指定カードが存在可能な位置である場合
		if ((0 <= cardPosition) && (cardPosition < playerHand.size())) {

			//カードの位置を指定
			pickedCard = (Card) playerHand.remove(cardPosition);
		}
		//指定した位置を返却
		return pickedCard;
	}

	/*
	 * 関数名：shuffleCards
	 * 概要:カードをシャッフルする
	 * 引数：なし
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void shuffleCards() {
		
		//カードを混ぜる度合いを定数化
		final int SHUFFLE_DEGREE = 2;

		//手札の数を取得
		int handNumber = playerHand.size();

		//カードを引き出す位置を設定
		int pullPosition;

		//手札をシャッフルする
		for (int pullCount = 0; pullCount < handNumber * SHUFFLE_DEGREE; pullCount++) {

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
	 * 概要: 手札の枚数を数える
	 * 引数：なし
	 * 戻り値：手札にあるカードの枚数(int型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public int getNumberOfCards() {

		//手札にあるカードの枚数を返却
		return playerHand.size();
	}

	/*
	 * 関数名：toString
	 * 概要:手札にあるカードの文字列を表示
	 * 引数：なし
	 * 戻り値：手札にあるカードの文字列表記(String型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public String toString() {

		//StringBufferクラスの変数を設定
		StringBuffer bufferString = new StringBuffer();

		//手札の枚数を表す変数を宣言
		int handSize = playerHand.size();
		//手札の枚数が0超過の場合
		if (handSize > 0) {

			//手札の枚数分だけ繰り返す処理
			for (int index = 0; index < handSize; index++) {

				//手札のカードを用意
				Card card = (Card) playerHand.get(index);
				//カードの文字列を表示
				bufferString.append(card);
				//空白を表示
				bufferString.append(" ");
			}
		}

		//手札にあるカードの文字列表記を返却
		return bufferString.toString();
	}

}
