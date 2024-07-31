package trump;

//ArrayListクラスをインポート
import java.util.ArrayList;

/*
 * クラス名:Master
 * 概要:トランプゲームの進行役の情報を管理するクラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/02
 */
public class Master {

	//参加したプレイヤーを保持するためのリスト
	private ArrayList<Player> playersList = new ArrayList<>();
	
	//プレーヤーの最小人数を定数化
	static final int MINIMUM_PLAYER_COUNT = 1;

	/*
	 * 関数名：prepareGame
	 * 概要:ゲーム開始の準備をする
	 * 引数：手札(Hand型)
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void prepareGame(Hand handCards) {

		//カードを配りますと表示
		System.out.println("【カードを配ります】");

		//トランプをシャッフルする
		handCards.shuffleCards();

		//トランプの枚数を取得する
		int numberOfCards = handCards.getNumberOfCards();

		//プレイヤーの人数を取得する
		int numberOfPlayers = playersList.size();

		//カードの枚数分、処理を繰り返す
		for (int processIndex = 0; processIndex < numberOfCards; processIndex++) {

			//カードから1枚引く
			Card cardDeck = handCards.pickCard(0);

			//カードを配るプレイヤーの順番を決める
			Player gamePlayers = (Player) playersList.get(processIndex % numberOfPlayers);
			//カードを渡す(プレイヤーが受け取る)
			gamePlayers.receiveCard(cardDeck);

		}
	}

	/*
	 * 関数名：startGame
	 * 概要:ゲームを開始する
	 * 引数：なし
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void startGame() {

		//ゲームを開始しますと表示
		System.out.println("【ゲームを開始します】");

		//プレイヤーの人数を取得する
		for (int count = 0; playersList.size() > MINIMUM_PLAYER_COUNT; count++) {

			//プレイヤーを進行順序を確認
			int playerIndex = count % playersList.size();
			//プレイヤー同士の前後関係を確認
			int nextPlayerIndex = (count + 1) % playersList.size();

			//指名するプレイヤーの取得
			Player gamePlayer = (Player) playersList.get(playerIndex);

			//その次のプレイヤーの取得
			Player nextPlayer = (Player) playersList.get(nextPlayerIndex);

			//プレイヤーを指名
			System.out.println("\n" + gamePlayer + "さんの番です");
			//次のプレイヤーへ受け渡す
			gamePlayer.playGame(nextPlayer);
		}

		//ゲームを終了しましたと表示
		System.out.println("【ゲームを終了しました】");
	}

	/*
	 * 関数名：declareWin
	 * 概要:上がりを宣言する
	 * 引数：上がったプレイヤー(Player型)
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void declareWin(Player gameWinner) {

		//上がったプレイヤーを伝える
		System.out.println(" " + gameWinner + "さんが上がりました!");

		//上がったプレイヤーをゲームから除外
		deregisterPlayer(gameWinner);
	}

	/*
	 * 関数名：registerPlayer
	 * 概要:ゲームのプレイヤーを登録
	 * 引数：参加するプレイヤー(Player型)
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void registerPlayer(Player joinPlayer) {

		//参加者をゲームに登録する
		playersList.add(joinPlayer);
	}
	
	/*
	 * 関数名：deregisterPlayer
	 * 概要:ゲームのプレイヤーを登録から解除
	 * 引数：解除するプレイヤー(Player型)
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void deregisterPlayer(Player leavedPlayer) {

		//離脱者をゲームの登録から解除
		playersList.remove(playersList.indexOf(leavedPlayer));
		
		//残り一人になった場合
		if (playersList.size() == MINIMUM_PLAYER_COUNT) {
			
			//敗者が決定する
			Player gameLoser = (Player) playersList.get(0);
			//敗者を伝える
			System.out.println(gameLoser + "さんの負けです!");
		}
	}
	
	/*
	 * 関数名：getPlayerCount
	 * 概要:プレイヤーに残りのプレイ人数を教える
	 * 引数：なし
	 * 戻り値：残りのプレイヤー人数(int型)
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public int getPlayerCount() {
		
		//プレイヤーの残り人数を伝える
		return playersList.size();
	}
}
