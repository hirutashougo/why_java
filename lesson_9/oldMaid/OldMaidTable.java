package lesson_9.oldMaid;

//配列生成のクラスをインポート
import java.util.ArrayList;

//trumpパッケージのCardクラスをインポート
import trump.Card;
//trumpパッケージのTableクラスをインポート
import trump.Table;

/*
 * クラス名:Table
 * 概要:ババ抜きのテーブルの情報を管理するクラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/02
 */
public class OldMaidTable implements Table {

	//捨てられたカードを格納する配列を用意
	private ArrayList<Card[]>  gameTable = new ArrayList<> ();

	/*
	 * 関数名：putCard
	 * 概要:なんのカードを捨てたのか示す
	 * 引数：なし
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void putCard(Card[] playerCard) {

		//テーブルに捨てられるカードを表示していく
		for (int index = 0; index < playerCard.length; index++) {

			//何のカードをしてたか表示
			System.out.print(playerCard[index] + " ");
			
			//捨てられたカードはテーブルに置かれる
			gameTable.add(playerCard);
		}

		//捨てたと表示
		System.out.println("を捨てました。");

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

		//テーブルに置かれたカードは見なくてもいい
		return null;
	}
}
