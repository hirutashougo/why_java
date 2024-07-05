package trump;

/*
 * クラス名:Card
 * 概要:トランプのカードを表すクラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/01
 */
public class Card {

	//スペードを表す定数を宣言
	public static final int SUIT_SPADE = 1;
	//ダイヤを表す定数を宣言
	public static final int SUIT_DIAMOND = 2;
	//クラブを表す定数を宣言
	public static final int SUIT_CLUB = 3;
	//ハートを表す定数を宣言
	public static final int SUIT_HEART = 4;
	//スートの数を表す定数を宣言
	public static final int SUIT_NUMBER = 4;
	//値の数を表す定数を宣言
	public static final int CARD_NUMBER = 13;
	//トランプのエースを表す定数を宣言
	public static final int ACE_CONSTANT = 1;
	//トランプのキングを表す定数を宣言
	public static final int KING_CONSTANT = 13;
	//トランプのクイーンを表す定数を宣言
	public static final int QUEEN_CONSTANT = 12;
	//トランプのジャックを表す定数を宣言
	public static final int JACK_CONSTANT = 11;
	//トランプのテンを表す定数を宣言
	public static final int TEN_CONSTANT = 10;

	//カードのスートを表す変数をフィールドを宣言
	protected int suitNumber;
	//カードの数字を表す変数をフィールドを宣言
	protected int cardNumber;

	/*
	 * コンストラクタ名：Card
	 * 概要:カードに関する情報を初期化して宣言
	 * 引数：カードのスートを表す数字,カードの数字(int型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public Card(int suitNumber, int cardNumber) {
		//カードのスートを表すフィールドを入力値で初期化
		this.suitNumber = suitNumber;
		//カードの数字を表すフィールドを入力値で初期化
		this.cardNumber = cardNumber;
	}

	/*
	 * 関数名：getNumber
	 * 概要:カードの数を見る
	 * 引数：なし
	 * 戻り値：カードの数字(int型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public int getNumber() {
		//カードの数字を返却
		return cardNumber;
	}

	/*
	 * 関数名：getSuit
	 * 概要:カードのスートを見る
	 * 引数：なし
	 * 戻り値：カードのスートを表す数字(int型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public int getSuit() {
		//カードのスートを表す数字を返却
		return suitNumber;
	}

	/*
	 * 関数名：toString
	 * 概要:トランプ(ジョーカー以外)の表示を行う
	 * 引数：なし
	 * 戻り値：トランプの表示(String型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public String toString() {

		//StringBufferクラスの変数を設定
		StringBuffer bufferString = new StringBuffer();

		//カードのスートを反映させる
		switch (suitNumber) {

		//カードのスートがスペードの場合
		case SUIT_SPADE: {

			//カードにSと追加する
			bufferString.append("S");
			//処理を終了
			break;
		}
		//カードのスートがダイヤの場合
		case SUIT_DIAMOND: {

			//カードにと追加する
			bufferString.append("D");
			//処理を終了
			break;
		}
		//カードのスートがクローバーの場合
		case SUIT_CLUB: {

			//カードにCと追加する
			bufferString.append("C");
			//処理を終了
			break;
		}
		//カードのスートがハートの場合
		case SUIT_HEART: {

			//カードにHと追加する
			bufferString.append("H");
			//処理を終了
			break;
		}
		//その他の場合
		default: {

			//処理を終了
			break;
		}
		}

		//特定の数字を文字の表記に置き換える
		switch (cardNumber) {

		//カードの数字が1の場合
		case ACE_CONSTANT: {

			//カードにとAと追加する
			bufferString.append("A");
			//処理を終了
			break;
		}
		//カードの数字が10の場合
		case TEN_CONSTANT: {

			//カードにとTと追加する
			bufferString.append("T");
			//処理を終了
			break;
		}
		//カードの数字が10の場合
		case JACK_CONSTANT: {

			//カードにJと追加する
			bufferString.append("J");
			//処理を終了
			break;
		}
		//カードの数字が12の場合
		case QUEEN_CONSTANT: {

			//カードにQと追加する
			bufferString.append("Q");
			//処理を終了
			break;
		}
		//カードの数字が13の場合
		case KING_CONSTANT: {

			//カードにKと追加する
			bufferString.append("K");
			//処理を終了
			break;
		}
		//その他の場合
		default: {
			//そのまま数字を表示
			bufferString.append(cardNumber);
			//処理を終了
			break;
		}
		}

		//トランプの表記を考慮したカード表記を返却
		return bufferString.toString();
	}
}
