package oldMaid;

//ArrayListクラスをインポート
import java.util.ArrayList;

/*
 * クラス名:Table
 * 概要:トランプゲームのテーブルの情報を管理するクラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/02
 */
public class Table {

	//
	private ArrayList<Card[]>  disposedCards = new ArrayList<> ();
	
	/*
	 * 関数名：disposeCard
	 * 概要:
	 * 引数：なし
	 * 戻り値：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void disposeCard(Card card[]) {
		
		//
		for(int index = 0; index < card.length; index++) {
			
			//
			System.out.print(card[index] + " ");
		}
		
		//捨てたと表示
		System.out.println("を捨てました。");
		
		//捨てられたカードはリストに追加しておく
		disposedCards.add(card);
		
	}
}
