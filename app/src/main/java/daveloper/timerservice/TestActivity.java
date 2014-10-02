package daveloper.timerservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import daveloper.timerservice.services.TestServiceExtension;


public class TestActivity extends Activity {

    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        setupViews();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void startTheService(){
        Intent intent = new Intent(this, TestServiceExtension.class);
        intent.putExtra(TestServiceExtension.TIME_TO_RUN, (long) 10000);
        startService(intent);
    }

    public void setupViews(){
        startBtn = (Button)findViewById(R.id.startBtn);
        startBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTheService();
            }
        });
    }
}
