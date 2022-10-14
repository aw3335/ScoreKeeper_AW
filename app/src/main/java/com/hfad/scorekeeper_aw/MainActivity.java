package com.hfad.scorekeeper_aw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Author: Austin Weaver
 * Score Keeper App allows users to enter two different team names and keep track of each teams score.
 * If the user wants to start over then reset restores everything to its default settings.
 */
public class MainActivity extends AppCompatActivity {

    //totalTeamVariable that hold the total int value of the teams
    private int totalTeam1 = 0;
    private int totalTeam2 = 0;

    //2 Keys that are used to retrieve the scores of the teams that are stored in the bundle
    public static final String TEAM1 = "team1";
    public static final String TEAM2 = "team2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Objects created for each item on the screen so each can be called and changed however needed
        Button btnTeam1 = findViewById(R.id.team1Button);
        Button btnTeam2 = findViewById(R.id.team2Button);
        TextView tvTeam1 = findViewById(R.id.team1Number);
        TextView tvTeam2 = findViewById(R.id.team2Number);
        EditText etTeam1 = findViewById(R.id.team1);
        EditText etTeam2 = findViewById(R.id.team2);
        Button btnReset = findViewById(R.id.reset);

        //If the instance of the screen has nothing saved then dont run the get lines and proceed like
        //its a fresh run
        if(savedInstanceState != null)
        {
            //Sets the int total of team 1 to the value stored in the instance state
            totalTeam1 = Integer.parseInt(savedInstanceState.getString(TEAM1));
            //Sets the team 1 text view to the total of team 1
            tvTeam1.setText("" + totalTeam1);
            //Sets the int total of team 2 to the value stored in the instance state
            totalTeam2 = Integer.parseInt(savedInstanceState.getString(TEAM2));
            //Sets the team 2 text view to the total of team 2
            tvTeam2.setText("" + totalTeam2);

        }

        /**
         * Btn Reset, when clicked resets all the local variables and texts to the starting values
         */
         btnReset.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 totalTeam1 = 0;
                 totalTeam2 = 0;
                 tvTeam1.setText("0");
                 tvTeam2.setText("0");
                 etTeam1.setText("Team 1");
                 etTeam2.setText("Team 2");

             }
         });

        /**
         * btnTeam1, when clicked add one to the total of team 1
         */
        btnTeam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Adds one to the total variable
                totalTeam1 += 1;
                //Sets the textview to that total
                tvTeam1.setText("" + totalTeam1);

            }
        });

        /**
         * btnTeam2, when clicked add one to the total of team 1
         */
        btnTeam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Adds one to the total variable
                totalTeam2 += 1;
                //Sets the textview to that total
                tvTeam2.setText("" + totalTeam2);
            }
        });
    }

    /**
     * When called it saved the current state of the app in the saved instance state bundle.
     * It also stores both teams score so it can be called later on.
     * @param savedInstanceState
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(TEAM1, "" + totalTeam1);
        savedInstanceState.putString(TEAM2, "" + totalTeam2);


    }
}