package timer;

/**
 * Interface contract for the custom countdown timer
 */
public interface CountDownInterface {
    long getTimeRemaining();
    void stopCountDown();
    void startCountDown();
}
