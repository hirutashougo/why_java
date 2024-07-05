package oldMaid;

/*
 * クラス名:Card
 * 概要:トランプのカードを表すクラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/01
 */
public class Card {

	//ジョーカーを表す定数を宣言
	public static final int JOKER_CONSTANT = 0;
	//スペードを表す定数を宣言
	public static final int SUIT_SPADE = 1;
	//ダイヤを表す定数を宣言
	public static final int SUIT_DIAMOND = 2;
	//クラブを表す定数を宣言
	public static final int SUIT_CLUB = 3;
	//ハートを表す定数を宣言
	public static final int SUIT_HEART = 4;
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
	private int suitNumber;
	//カードの数字を表す変数をフィールドを宣言
	private int cardNumber;

	/*
	 * コンストラクタ名：Card
	 * 概要:カードに関する情報を初期化して宣言
	 * 引数：カードのスート,カードの数字(int型)
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
	 * 概要:カードの数字を返却
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
	 * 関数名：showHand
	 * 概要:
	 * 引数：なし
	 * 戻り値：ジャンケンの手
	 * 作成者：S.Hiruta
	 * 作成日：2024/06/28
	*/
	public String toString() {

		//StringBufferクラスの変数を設定
		StringBuffer bufferString = new StringBuffer();

		//カードの数字が0以上の場合
		if (cardNumber > 0) {

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

				//
				bufferString.append(cardNumber);
				//処理を終了
				break;
			}
			}
			//	ジョーカーの場合
		} else {

			//カードにとJKと追加する
			bufferString.append("JK");
		}

		//トランプの表記を考慮したカード表記を返却
		return bufferString.toString();
	}
}
