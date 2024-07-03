package trump;

/*
 * インタフェース名:Rule
 * 概要:トランプゲームのルールの情報を管理するインタフェース
 * 作成者:S.Hiruta
 * 作成日:2024/07/02
 */
public interface Rule {
	
	/*
	 * 関数名：findCandidate
	 * 概要:テーブルに出すことが可能なカードを探す。
	 * 引数：手札(Hand型), ゲームに使用するテーブル(Table型)
	 * 戻り値：テーブルに出せるカードの組み合わせ(見つからない場合はNULLを返す)(Card型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public Card[] findCandidate(Hand gameHand, Table gameTable);

}
