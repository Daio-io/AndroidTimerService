package daveloper.timerservice.services;

import android.app.Notification;
import android.app.NotificationManager;

import daveloper.timerservice.R;

/**
 * Quick example sub class of TimerService to show sending a notification on
 * countdown completing
 */
public class TestServiceExtension extends TimerService {

    @Override
    public void countdownFinished() {
        super.countdownFinished();
        Notification.Builder noti = new Notification.Builder(this.getApplicationContext());
        noti.setSmallIcon(R.drawable.ic_launcher);
        noti.setContentTitle("Timer Up");
        noti.setContentText("Looks like the timer has service has completed");

        Notification notification = noti.build();
        NotificationManager notificationManager =
                (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);



        notificationManager.notify(0, notification);
    }

}
