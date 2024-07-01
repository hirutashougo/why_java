package jankenWithInterface;

/*
* インターフェース名:Tactics
* 概要:ジャンケンの戦略を管理
* 作成者:S.Hiruta
* 作成日:2024/07/01
*/
public interface Tactics {
	
	/*
	 * 関数名：readTactics
	 * 概要:戦略を読み、ジャンケンの手を得る。
	 * 		グー・チョキ・パーのいずれかをPlayerクラスに定義された以下の定数で返す。
	 * 		Player.STONE_NUMBER … グー
	 * 		Player.SCISSORS_NUMBER … チョキ
	 * 		Player.PAPER_NUMBER … パー
	 * 引数：なし
	 * 戻り値：ジャンケンの手を表す定数(int型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/01
	*/
	public int readTactics();

}
