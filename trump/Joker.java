package trump;

/*
 * クラス名:Joker
 * 概要:ジョーカーを表すクラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/02
 */
public class Joker extends Card{

	/*
	 * コンストラクタ名：Card
	 * 概要:ジョーカーに関する情報を初期化して宣言
	 * 		ジョーカーはデフォルトでは何も返さない
	 * 引数：カードのスートを表す数字,カードの数字(int型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public Joker() {
		//カードの数字と名前は0を返すように設定
		super(0, 0);
	}
	
	/*
	 * 関数名：setNumber
	 * 概要:カードの数を変更する
	 * 引数：なし
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void setNumber(int changedCardNumber) {
		//カードの数字を変更
		this.cardNumber = changedCardNumber;
	}
	
	/*
	 * 関数名：setSuit
	 * 概要:カードのマークを変更する
	 * 引数：なし
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void setSuit(int changedCardSuit) {
		//カードのマークを変更
		this.suitNumber = changedCardSuit;
	}
	
	/*
	 * 関数名：toString
	 * 概要:ジョーカーの表示を行う
	 * 引数：なし
	 * 戻り値：ジョーカーの表示(Stringr型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public String toString() {
		
		//JKと表示
		return "JK";
	}
}
