package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadProfile();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveProfile();
    }

    public void loadProfile() {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        TextView nameText = this.findViewById(R.id.name_textview);
        TextView statusText = this.findViewById(R.id.status_textview);
        nameText.setText(prefs.getString("name", ""));
        statusText.setText(prefs.getString("status", ""));
    }

    public void saveProfile() {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        TextView nameTextView = this.findViewById(R.id.name_textview);
        TextView statusTextView = this.findViewById(R.id.status_textview);
        String nameText = "" + nameTextView.getText();
        String statusText = "" + statusTextView.getText();
        editor.putString("name", nameText);
        editor.putString("status", statusText);
        editor.apply();
    }

    public void onExitClicked(View view) {
        finish();
    }
}