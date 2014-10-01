package daveloper.timerservice.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Base ServiceService to run for a specified amount of time
 * before completing an action on timerFinished();
 * Extension of this class is recommended
 * then override the timerFinished() to completed an action
 */
public class ServiceService extends Service implements CountdownServiceInterface {

    protected long timeToRun;

    public static final String TIME_TO_RUN = "TIME_TO_RUN";

    public static final long TWENTY_FOUR_HOURS = 86400000;
    public static final long TWELVE_HOURS = 43200000;
    public static final long TEN_MINUTES = 600000;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        this.timeToRun = intent.getLongExtra(TIME_TO_RUN, TEN_MINUTES);
        return START_STICKY;

    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void countdownFinished() {
        this.stopSelf();
    }
}
