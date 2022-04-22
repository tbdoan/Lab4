package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Optional;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLaunchProfileClicked(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void onShowCounterClicked(View view) {
        Intent intent = new Intent(this, CounterActivity.class);

        TextView maxCountView = findViewById(R.id.max_count_view);
        String maxCountStr = maxCountView.getText().toString();

        Optional<Integer> maybeMaxCount = Utilities.parseCount(maxCountStr);
        if (!maybeMaxCount.isPresent()) {
            Utilities.showAlert(this, "not a number");
            return;
        }

        int maxCount = maybeMaxCount.get();
        if (maxCount <= 0) {
            Utilities.showAlert(this,
                    "please enter a positive number");
            return;
        }

        intent.putExtra("max_count", maxCount);
        startActivity(intent);
    }
}

/*
Question #1
In your own words: What does it mean to block the main UI thread? Why would you want to avoid doing
this? Give an example of what could go wrong if we did.
    to block the main ui thread is to run a time-consuming process on the main ui thread. we avoid it
    because the ui cannot update until the process has finished and the thread is freed.

Question #2
Imagine you are currently inside a thread running in the background (not the main UI thread).
Thinking back to previous labs, give at least two examples of methods that you could only call
by using runOnUiThread.
    man idk. like changing color of the background or something.
 */