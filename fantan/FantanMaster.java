package fantan;

//trumpパッケージのMasterクラスをインポート
import trump.Master;

/*
 * クラス名:FantanMaster
 * 概要:七並べの進行役の情報を管理するクラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/04
 */
public class FantanMaster extends Master{

	//パスの可能な回数を宣言
	public static final int PASS_LIMIT = 3;
	
	/*
	 * 関数名：findCandidate
	 * 概要:パスを宣言する
	 * 引数：パスを宣言したプレイヤー(Player型)
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void declarePass(FantanPlayer gamePlayer) {
		
		//パスを表示
		System.out.println(" " + gamePlayer + "さんは" + gamePlayer.getPass() + "回のパスをしました！");
		
		//パスの制限数を超えた場合
		if(gamePlayer.getPass() > PASS_LIMIT) {
			
			//パス制限を超えたらプレイヤーは負け
			System.out.println(" " + gamePlayer + "さんは負けです！");
			//ゲームからプレイヤーを排除
			deregisterPlayer(gamePlayer);
		}
	}
}
