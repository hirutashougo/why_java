package trump;

/*
 * クラス名:Player
 * 概要:トランプゲームのプレイヤーの情報を管理するクラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/02
 */
public abstract class Player {

	//進行役のフィールドを設定
	protected Master gameMaster;
	//テーブルのフィールドを宣言
	protected Table gameTable;
	//手札のフィールドを宣言
	protected Hand playerHand = new Hand();
	//プレイヤーの名前のフィールドを宣言
	protected String playerName;
	//ゲームのルールのフィールドを宣言
	protected Rule gameRule;

	/*
	 * コンストラクタ名：Player
	 * 概要:プレイヤーに関する情報を初期化して宣言
	 * 引数：プレイヤー名(String型),進行役(Mster型),テーブル(Table型),ルール(Rule型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public Player(String playerName, Master gameMaster, Table gameTable, Rule gameRule) {

		//プレイヤーの名前のフィールドを初期化して宣言
		this.playerName = playerName;
		//進行役のフィールドを初期化して宣言
		this.gameMaster = gameMaster;
		//テーブルのフィールドを初期化して宣言
		this.gameTable = gameTable;
		//ルールのフィールドを初期化して宣言
		this.gameRule = gameRule;
	}
	
	/*
	 * 関数名：playGame
	 * 概要:順番を指名する
	 * 引数：次のプレイヤー(Player型)
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public abstract void playGame(Player nextPlayer);

	/*
	 * 関数名：receiveCard
	 * 概要:カードを受け取る
	 * 引数：受け取るカード(Card型)
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void receiveCard(Card receivedCard) {

		//カードを手札に加える
		playerHand.addCard(receivedCard);
	}

	/*
	 * 関数名：toString
	 * 概要:プレイヤーの名前を表示
	 * 引数：なし
	 * 戻り値：プレイヤーの名前の表記(String型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public String toString() {

		//プレイヤーの名前の表記を返却
		return playerName;
	}
}
