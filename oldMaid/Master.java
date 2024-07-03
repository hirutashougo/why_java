package oldMaid;

import java.util.ArrayList;

/*
 * クラス名:Master
 * 概要:ババ抜きの進行役の情報を管理するクラス
 * 作成者:S.Hiruta
 * 作成日:2024/07/02
 */
public class Master {

	//
	private ArrayList<Player> players = new ArrayList<>();

	/*
	 * 関数名：prepareGame
	 * 概要:
	 * 引数：なし
	 * 戻り値：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void prepareGame(Hand cards) {

		//
		System.out.println("【カードを配ります】");

		//
		cards.shuffleCards();

		//
		int numberOfCards = cards.getNumberOfCards();

		//
		int numberOfPlayers = players.size();

		//
		for (int index = 0; index < numberOfCards; index++) {

			//
			Card card = cards.pickCard();
			//
			Player player = (Player) players.get(index % numberOfPlayers);
			//
			player.receiveCard(card);

		}
	}
	
	/*
	 * 関数名：startGame
	 * 概要:
	 * 引数：なし
	 * 戻り値：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void startGame() {
		
		//
		for (int count = 0; players.size() > 1; count++) {
			
			//
			int playerIndex = count % players.size();
			//
			int nextPlayerIndex = (count + 1) % players.size();
			
			//
			Player player = (Player) players.get(playerIndex);
			
			//
			Player nextPlayer = (Player) players.get(nextPlayerIndex);
			
			//
			System.out.println("\n" + player + "さんの番です");
			//
			player.playGame(nextPlayer);
		}
		
		//
		System.out.println("【ババ抜きを終了しました】");
	}
	
	/*
	 * 関数名：declareWin
	 * 概要:
	 * 引数：なし
	 * 戻り値：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void declareWin(Player winner) {
		
		//
		System.out.println(winner + "さんが上がりました!");
		
		//
		players.remove(players.indexOf(winner));
		
		//
		if (players.size() == 1) {
			
			//
			Player loser = (Player) players.get(0);
			
			//
			System.out.println(loser + "さんの負けです!");
		}
	}
	
	/*
	 * 関数名：startGame
	 * 概要:
	 * 引数：なし
	 * 戻り値：
	 * 作成者：S.Hiruta
	 * 作成日：2024/07/02
	*/
	public void registerPlayer(Player player) {
		
		//
		players.add(player);
	}
}
