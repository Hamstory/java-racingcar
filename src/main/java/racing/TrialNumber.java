package racing;

public class TrialNumber {
    private int value;

    public TrialNumber(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 작을 수 없습니다");
        }
        this.value = value;
    }

    public boolean hasRemaining() {
        return this.value > 0;
    }

    public void reduce() {
        if (value <= 0) {
            throw new IllegalArgumentException("이미 모두 시도 했습니다.");
        }
        this.value--;
    }
}
