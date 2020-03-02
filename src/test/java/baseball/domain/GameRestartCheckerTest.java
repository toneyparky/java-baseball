package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/02
 */
public class GameRestartCheckerTest {

	@Test
	void GameRestartChecker_생성자_올바른_동작_확인() {
		assertThat(new GameRestartChecker(1)).isInstanceOf(GameRestartChecker.class);
	}
}
