package baseball.controller;

import baseball.domain.GameNumberRepository;
import baseball.domain.GameNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/02
 */
public class GameController {

	public void playBall() {
		do {
			playOneRound();
		} while (isPlayAgain());
	}

	public void playOneRound() {
		GameNumbers targetGameNumbers = new GameNumbers(GameNumberRepository.createGameNumbers());
		System.out.println(targetGameNumbers); // TODO: 2020/03/02  지워야하고 Tostring도 지워야할듯?
		GameNumbers playerGameNumbers;
		do {
			OutputView.askPlayerGameNumber();
			playerGameNumbers = new GameNumbers(InputView.getPlayerGameNumbers());
			int strike = targetGameNumbers.getSamePositionGameNumberCount(playerGameNumbers);
			int ball = targetGameNumbers.getContainingGameNumbersCount(playerGameNumbers);
			OutputView.printResult(strike, ball - strike);
			System.out.println(targetGameNumbers.getSamePositionGameNumberCount(playerGameNumbers));
		} while (targetGameNumbers.getSamePositionGameNumberCount(playerGameNumbers) != 3);
	}

	private boolean isPlayAgain() {
		OutputView.askPlayAgain();
		int againOrNot = InputView.getPlayAgainOrNot();
		if (againOrNot != 1 && againOrNot != 2) {
			throw new IllegalArgumentException("잘못된 입력입니다.");
		}
		return againOrNot == 1;
	}
}
