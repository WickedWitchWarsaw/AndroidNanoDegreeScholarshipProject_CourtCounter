package com.wickedwitchwarsaw.androidudacitycourtcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Baseball extends AppCompatActivity {

    int runsTop = 0;
    int outsTop = 0;
    int runsBottom = 0;
    int outsBottom = 0;

    @BindView(R.id.baseball_team_name_one)
    protected TextView teamOneName;

    @BindView(R.id.baseball_team_name_two)
    protected TextView teamTwoName;

    @BindView(R.id.baseball_runsScored_one)
    protected TextView teamOneRuns;

    @BindView(R.id.baseball_outScored_one)
    protected TextView teamOneOuts;

    @BindView(R.id.baseball_runsScored_two)
    protected TextView teamTwoRuns;

    @BindView(R.id.baseball_outScored_two)
    protected TextView teamTwoOuts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseball);
        ButterKnife.bind(this);

        Intent startBaseball = getIntent();
        String teamNameTop = startBaseball.getStringExtra("TeamNameTop");
        String teamNameBottom = startBaseball.getStringExtra("TeamNameBottom");

        teamOneName.setText(teamNameTop);
        teamTwoName.setText(teamNameBottom);

    }

    @OnClick(R.id.baseball_btn_team_one_runs)
    public void addRunTeamTop(){
        addRunTop(1);
        displayRunsTop(runsTop);
    }

    @OnClick(R.id.baseball_btn_team_one_outs)
    public void addOutTeamTop(){
        addOutTop(1);
        displayOutsTop(outsTop);
    }

    @OnClick(R.id.baseball_btn_team_two_runs)
    public void addRunsTeamBottom(){
        addRunBottom(1);
        displayRunsBottom(runsBottom);
    }

    @OnClick(R.id.baseball_btn_team_two_outs)
    public void addOutTeamBottom(){
        addOutBottom(1);
        displayOutsBottom(outsBottom);
    }



    //RESET METHOD
    @OnClick(R.id.btn_reset_baseball)
    public void resetAllBaseball() {
        runsTop = 0;
        outsTop = 0;
        runsBottom = 0;
        outsBottom = 0;

        displayRunsTop(runsTop);
        displayOutsTop(outsTop);
        displayRunsBottom(runsBottom);
        displayOutsBottom(outsBottom);
    }

    //======================================> DISPLAY METHODS

    public void displayRunsTop(int runsTop) {
        teamOneRuns.setText("" + runsTop);
    }

    public void displayOutsTop(int outsTop) {
        teamOneOuts.setText("" + outsTop);
    }

    public void displayRunsBottom(int runsBottom){
        teamTwoRuns.setText("" + runsBottom);
    }

    public void displayOutsBottom(int outsBottom){
        teamTwoOuts.setText("" + outsBottom);
    }

    //=======================================> ADD RUNS/OUT METHODS

    public void addRunTop(int run){
        runsTop = runsTop + run;
    }

    public void addOutTop(int out){
        outsTop = outsTop + out;
    }

    public void addRunBottom(int run){
        runsBottom = runsBottom + run;
    }

    public void addOutBottom(int out){
        outsBottom = outsBottom + out;
    }


    //==============================>MENU

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
