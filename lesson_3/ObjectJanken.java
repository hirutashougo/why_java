package lesson_3;

/*
 * クラス名:ObjectJanken
 * 概要:オブジェクト指向によるジャンケンプログラム
 * 作成者:S.Hiruta
 * 作成日:2024/06/28
 */
public class ObjectJanken {
	
	/*
     * 関数名:main
     * 概要:オブジェクト指向によるジャンケンプログラム
     * 引数:なし
     * 戻り値:なし
     * 作成者:S.Hiruta
     * 作成日:2024/06/28
     */
	public static void main(String[] args) {
		
		//審判(齋藤さん)のインスタンス生成
		Judge judgmentSaito = new Judge();
		
		//プレイヤー1(村田さん)の生成
		Player playerMurata = new Player("村田さん");
		
		//プレイヤー2(山田さん)の生成
		Player playerYamada = new Player("山田さん");
		
		//村田さんと山田さんをプレイヤーとしてジャンケンを開始する
		judgmentSaito.startJanken(playerMurata, playerYamada);
	}

}
