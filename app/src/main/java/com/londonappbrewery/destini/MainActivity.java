package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView storyTextView;
    private Button topButton;
    private Button bottomButton;
    int appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyTextView = findViewById(R.id.storyTextView);
        topButton = findViewById(R.id.buttonTop);
        bottomButton = findViewById(R.id.buttonBottom);

        if(savedInstanceState != null) appState = savedInstanceState.getInt("AppState");
        else appState = 1;

        installStoryPlace(appState);



        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(appState == 1) appState = 3;
                else  if(appState == 3) appState = 6;
                else  if(appState == 2) appState = 3;
                else appState = -1;
                installStoryPlace(appState);

            }
        });




        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(appState == 1) appState = 2;
                else  if(appState == 2) appState = 4;
                else  if(appState == 3) appState = 5;
                else appState = -1;
                installStoryPlace(appState);
            }
        });

    }
    private void installStoryPlace(int storyIndex){
        if(storyIndex == 1){
            storyTextView.setText(R.string.T1_Story);
            topButton.setText(R.string.T1_Ans1);
            bottomButton.setText(R.string.T1_Ans2);
        }
        else if (storyIndex == 2){
            storyTextView.setText(R.string.T2_Story);
            topButton.setText(R.string.T2_Ans1);
            bottomButton.setText(R.string.T2_Ans2);
        }
        else if (storyIndex == 3){
            storyTextView.setText(R.string.T3_Story);
            topButton.setText(R.string.T3_Ans1);
            bottomButton.setText(R.string.T3_Ans2);
        }
        else if (storyIndex == 4){
            storyTextView.setText(R.string.T4_End);
            topButton.setVisibility(View.GONE);
            bottomButton.setVisibility(View.GONE);
        }
        else if (storyIndex == 5){
            storyTextView.setText(R.string.T5_End);
            topButton.setVisibility(View.GONE);
            bottomButton.setVisibility(View.GONE);
        }
        else if (storyIndex == 6){
            storyTextView.setText(R.string.T6_End);
            topButton.setVisibility(View.GONE);
            bottomButton.setVisibility(View.GONE);
        }
        else storyTextView.setText("Error");
     }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("AppState", appState);
    }
}
