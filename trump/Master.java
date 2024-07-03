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

	//手札にあるカードを保持するためのリスト
	private ArrayList<Player> cardLists = new ArrayList<>();

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
		int numberOfPlayers = cardLists.size();

		//カードの枚数分、処理を繰り返す
		for (int processIndex = 0; processIndex < numberOfCards; processIndex++) {

			//カードから1枚引く
			Card cardDeck = handCards.pickCard(0);

			//カードを配るプレイヤーの順番を決める
			Player gamePlayers = (Player) cardLists.get(processIndex % numberOfPlayers);
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
		for (int count = 0; cardLists.size() > 1; count++) {

			//プレイヤーを進行順序を確認
			int playerIndex = count % cardLists.size();
			//プレイヤー同士の前後関係を確認
			int nextPlayerIndex = (count + 1) % cardLists.size();

			//指名するプレイヤーの取得
			Player player = (Player) cardLists.get(playerIndex);

			//その次のプレイヤーの取得
			Player nextPlayer = (Player) cardLists.get(nextPlayerIndex);

			//プレイヤーを指名
			System.out.println("\n" + player + "さんの番です");
			//次のプレイヤーへ受け渡す
			player.playGame(nextPlayer);
		}

		//ババ抜きを終了しましたと表示
		System.out.println("【ババ抜きを終了しました】");
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
		System.out.println(gameWinner + "さんが上がりました!");

		//上がったプレイヤーをゲームから除外
		cardLists.remove(cardLists.indexOf(gameWinner));
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
		cardLists.add(joinPlayer);
	}
	
	/*
	 * 関数名：dereregisterPlayer
	 * 概要:ゲームのプレイヤーを登録から解除
	 * 引数：解除するプレイヤー(Player型)
	 * 戻り値：なし
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void dereregisterPlayer(Player leavedPlayer) {

		//離脱者をゲームの登録から解除
		cardLists.remove(cardLists.indexOf(leavedPlayer));
		
		//残り一人になった場合
		if (cardLists.size() == 1) {
			
			//敗者が決定する
			Player gameLoser = (Player) cardLists.get(0);
			//敗者を伝える
			System.out.println(gameLoser + "さんの負けです!");
		}
	}
}