package racing;

import java.util.List;
import java.util.function.Consumer;

public class CarRace {
    private static final CarMovingStrategy DEFAULT_STRATEGY = new RandomCarMovingStrategy();

    private final Cars cars;
    private final TrialNumber trialNumber;

    public CarRace(String[] carNames, int trialNumber) {
        this.cars = new Cars(carNames);
        this.trialNumber = new TrialNumber(trialNumber);
    }

    public void startRace(Consumer<Cars> callback) {
        startRace(DEFAULT_STRATEGY, callback);
    }

    public void startRace(CarMovingStrategy strategy, Consumer<Cars> callback) {
        while (trialNumber.hasRemaining()) {
            cars.move(strategy);
            callback.accept(cars);
            trialNumber.reduce();
        }
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }
}
