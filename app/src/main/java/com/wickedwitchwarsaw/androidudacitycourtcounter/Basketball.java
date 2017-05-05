package com.wickedwitchwarsaw.androidudacitycourtcounter;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Basketball extends AppCompatActivity {

    int pointsLeft = 0;
    int pointsRight = 0;

    @BindView(R.id.points_left)
    protected TextView textViewPointsLeft;

    @BindView(R.id.points_right)
    protected TextView textViewPointsRight;

    @BindView(R.id.basketball_team_name_one)
    protected TextView teamNameOne;

    @BindView(R.id.basketball_team_name_two)
    protected TextView teamNameTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball);
        ButterKnife.bind(this);

        Intent startBasketball = getIntent();
        String teamLeftName = startBasketball.getStringExtra("TeamLeftName");
        String teamRightName = startBasketball.getStringExtra("TeamRightName");
        teamNameOne.setText(teamLeftName);
        teamNameTwo.setText(teamRightName);

    }

    //=============================>LEFT

    @OnClick(R.id.btn_1point_left)
    public void addOnePointLeft() {
        addPointsLeft(1);
        displayPointsLeft(pointsLeft);
    }

    @OnClick(R.id.btn_2point_left)
    public void addTwoPointsLeft() {
        addPointsLeft(2);
        displayPointsLeft(pointsLeft);
    }

    @OnClick(R.id.btn_3point_left)
    public void addThreePointsLeft() {
        addPointsLeft(3);
        displayPointsLeft(pointsLeft);
    }


    //=============================>RIGHT

    @OnClick(R.id.btn_1point_right)
    public void addOnePointRight() {
        addPointsRight(1);
        displayPointsRight(pointsRight);
    }

    @OnClick(R.id.btn_2point_right)
    public void addTwoPointsRight() {
        addPointsRight(2);
        displayPointsRight(pointsRight);
    }

    @OnClick(R.id.btn_3point_right)
    public void addThreePointsRight() {
        addPointsRight(3);
        displayPointsRight(pointsRight);
    }

    @OnClick(R.id.btn_reset_basketball)
    public void resetPoints() {
        pointsRight = 0;
        pointsLeft = 0;
        displayPointsRight(pointsRight);
        displayPointsLeft(pointsLeft);
    }


    public void displayPointsLeft(int score) {
        textViewPointsLeft.setText("" + score);
    }

    public void displayPointsRight(int score) {
        textViewPointsRight.setText("" + score);
    }


    public void addPointsLeft(int addedPoints) {
        pointsLeft = pointsLeft + addedPoints;
    }

    public void addPointsRight(int addedPoints) {
        pointsRight = pointsRight + addedPoints;
    }

    //==============================> MENU <==============================//

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuMain) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
