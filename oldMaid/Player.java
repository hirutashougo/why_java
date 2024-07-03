package oldMaid;

/*
 * クラス名:Player
 * 概要:ババ抜きのプレイヤーの情報を管理するクラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/02
 */
public class Player {

	//進行役のフィールドを設定
	private Master master;
	//テーブルのフィールドを宣言
	private Table table;
	//手札のフィールドを宣言
	private Hand myHand = new Hand();
	//プレイヤーの名前のフィールドを宣言
	private String name;

	/*
	 * コンストラクタ名：Player
	 * 概要:プレイヤーに関する情報を初期化して宣言
	 * 引数：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public Player(String name, Master master, Table table) {

		//
		this.name = name;
		//
		this.master = master;
		//
		this.table = table;
	}

	/*
	 * 関数名：disposeCard
	 * 概要:
	 * 引数：なし
	 * 戻り値：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void playGame(Player nextPlayer) {

		//
		Hand nextHand = nextPlayer.showHand();

		//
		Card pickedCard = nextHand.pickCard();

		//
		System.out.println(this + ":" + nextPlayer + "さんから" + pickedCard + "を引きました");

		//
		dealCard(pickedCard);

		//
		if (myHand.getNumberOfCards() == 0) {

			//
			master.declareWin(this);

			//
		} else {

			//
			System.out.println(this + ":残りの手札は" + myHand + "です");
		}
	}

	/*
	 * 関数名：showHand
	 * 概要:
	 * 引数：なし
	 * 戻り値：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public Hand showHand() {

		//
		if (myHand.getNumberOfCards() == 1) {

			//
			master.declareWin(this);
		}
		
		//
		myHand.shuffleCards();
		
		//
		return myHand;
	}
	
	/*
	 * 関数名：receiveCard
	 * 概要:
	 * 引数：なし
	 * 戻り値：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void receiveCard(Card card) {
		
		//
		dealCard(card);
	}

	/*
	 * 関数名：receiveCard
	 * 概要:
	 * 引数：なし
	 * 戻り値：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	private void dealCard(Card card) {
		
		//
		myHand.addCard(card);
		
		//
		Card[] sameCards = myHand.findSameNumberCard();
		
		//
		if(sameCards != null) {
			
			//
			System.out.print(this + ":");
			//
			table.disposeCard(sameCards);
		}
	}
	
	/*
	 * 関数名：receiveCard
	 * 概要:
	 * 引数：なし
	 * 戻り値：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public String toString() {
		
		//
		return name;
	}
}
