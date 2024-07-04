package fantan;

//trumpパッケージのCardクラスをインポート
import trump.Card;
//trumpパッケージのTableクラスをインポート
import trump.Table;

/*
 * クラス名:FantanTable
 * 概要:七並べのテーブルの情報を管理するクラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/02
 */
public class FantanTable implements Table {

	//テーブルの状態を表す行列を宣言
	private Card[][] gameTable = new Card[Card.SUIT_NUMBER][Card.CARD_NUMBER];

	/*
	 * 関数名：putCard
	 * 概要:テーブルにカードを置く
	 * 引数：カード(Card[]型)
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void putCard(Card[] playerCard) {

		//トランプの数字を取得
		int trumpNumber = playerCard[0].getNumber();
		//トランプのマークを取得
		int trumpSuit = playerCard[0].getSuit();

		//テーブルにトランプを並べる
		gameTable[trumpSuit - 1][trumpNumber - 1] = playerCard[0];
	}

	/*
	 * 関数名：getCard
	 * 概要:テーブルに置かれたカードを表す
	 * 引数：なし
	 * 戻り値：テーブルに置かれたカードを表す配列(Card[][]型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public Card[][] getCard() {

		//テーブルに置かれたカードを返却
		return gameTable;
	}

	/*
	 * 関数名：toString
	 * 概要:手札にあるカードの文字列を表示
	 * 引数：なし
	 * 戻り値：テーブルの文字列表記(String型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public String toString() {

		//StringBufferクラスの変数を設定
		StringBuffer tableLineUp = new StringBuffer(200);
		
		//カードの回数分繰り返す処理
		for(int suitCount = 0; suitCount < Card.SUIT_NUMBER; suitCount++) {
			
			//カードの数だけ繰り返す処理
			for(int numberCount = 0; numberCount < Card.CARD_NUMBER; numberCount++) {
				
				//並べられる数字がない場合
				if(gameTable[suitCount][numberCount] == null) {
					
					//「..」を表示
					tableLineUp.append("..");
					
					//並べられる数字がある場合
				} else {
					
					//カードの表記を表示
					tableLineUp.append(gameTable[suitCount][numberCount].toString());					
				}
				
				//文字の間隔を開ける
				tableLineUp.append(" ");
			}
			
			//改行する
			tableLineUp.append("\n");
		}

		//テーブルの文字列表記を返却
		return tableLineUp.toString();
	}
}
