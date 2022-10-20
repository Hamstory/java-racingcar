package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TrialNumberTest {
    @Test
    void test_negative_number() {
        assertThatThrownBy(() -> new TrialNumber(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test_has_remaining() {
        assertThat(new TrialNumber(0).hasRemaining()).isFalse();
        assertThat(new TrialNumber(1).hasRemaining()).isTrue();
    }

    @Test
    void test_reduce() {
        TrialNumber number = new TrialNumber(1);
        number.reduce();
        assertThat(number.hasRemaining()).isFalse();
    }

    @Test
    void test_reduce_zero() {
        assertThatThrownBy(() -> new TrialNumber(0).reduce())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
