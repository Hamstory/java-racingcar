package racing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRaceTest {
    @Test
    void test_start_race() {
        Car car = new Car("car1");
        CarRace race = new CarRace(List.of(car), 3);
        race.startRace(() -> true, (cars) -> { });
        assertThat(car.hasDistance(new CarDistance(3))).isTrue();
    }

    @Test
    void test_get_winner() {
        Car winner = new Car("car1", 3);
        Car loser = new Car("car2", 0);
        CarRace race = new CarRace(Arrays.asList(winner, loser), 3);
        assertThat(race.getWinners().get(0)).isEqualTo(winner);
    }
}
