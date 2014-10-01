package timer;

import android.os.CountDownTimer;

import daveloper.timerservice.services.CountdownServiceInterface;

/**
 * Custom countdown timer which takes a CountDownServiceInterface
 * to communicate back to the service one completion
 */
public class ServiceCountdownTimer extends CountDownTimer implements CountDownInterface  {

    private CountdownServiceInterface countdownService;
    private long timeRemaining;

    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     * @param countdownService The service which will be passed into the
     *                         countdown timer in order to invoke methods
     *                         on that service during countdown.
     */
    public ServiceCountdownTimer(CountdownServiceInterface countdownService,
                                 long millisInFuture,
                                 long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.countdownService = countdownService;
    }

    @Override
    public long getTimeRemaining() {
        return this.timeRemaining;
    }

    @Override
    public void stopCountDown() {
        this.cancel();
    }

    @Override
    public void startCountDown() {
        this.start();
    }

    @Override
    public void onTick(long millisUntilFinished) {
        this.timeRemaining = millisUntilFinished;
    }

    @Override
    public void onFinish() {
        this.countdownService.countdownFinished();
    }
}
