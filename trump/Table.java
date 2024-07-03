package trump;

/*
 * インタフェース名:Table
 * 概要:トランプゲームのテーブルの情報を管理するインタフェース
 * 作成者:S.Hiruta
 * 作成日:2024/07/02
 */
public interface Table {
	
	/*
	 * 関数名：putCard
	 * 概要:テーブルにカードを置く
	 * 引数：カード(Card型)
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void putCard(Card[] playerCard);
	
	/*
	 * 関数名：getCard
	 * 概要:テーブルに置かれたカードを表す
	 * 引数：なし
	 * 戻り値：テーブルに置かれたカードを表す配列(Card[][]型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public Card[][] getCard();
	
}
