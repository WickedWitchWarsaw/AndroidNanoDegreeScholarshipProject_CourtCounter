package com.wickedwitchwarsaw.androidudacitycourtcounter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.spinnerSportsList)
    protected Spinner spinnerDropdownList;

    @BindView(R.id.editTextTeamOne)
    protected EditText teamNameOne;

    @BindView(R.id.editTextTeamTwo)
    protected EditText teamNameTwo;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayAdapter<CharSequence> sportsDropdownList = ArrayAdapter.createFromResource
                (this, R.array.sportsList, R.layout.view_spinner_dropdown);
        sportsDropdownList.setDropDownViewResource(R.layout.view_spinner_item);
        spinnerDropdownList.setAdapter(sportsDropdownList);
    }

    @OnClick(R.id.btn_enter)
    public void enterSport(View view) {
        String selectedSport = (String) spinnerDropdownList.getSelectedItem();

        if (selectedSport.equals("Basketball")) {
            startBasketballIntent(this);
        }
        if (selectedSport.equals("Baseball")) {
            startBaseballIntent(this);
        }
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

    //=============================>INTENT BASKETBALL

    public void startBasketballIntent(Context context){
        Intent startBasketball = new Intent(context, Basketball.class);

        String teamOne = teamNameOne.getText().toString();
        String teamTwo = teamNameTwo.getText().toString();

        startBasketball.putExtra("TeamLeftName", teamOne);
        startBasketball.putExtra("TeamRightName", teamTwo);

        context.startActivity(startBasketball);
    }

    //==============================>INTENT BASEBALL

    public void startBaseballIntent(Context context){
        Intent startBaseball = new Intent(context, Baseball.class);

        String teamOne = teamNameOne.getText().toString();
        String teamTwo = teamNameTwo.getText().toString();

        startBaseball.putExtra("TeamNameTop", teamOne);
        startBaseball.putExtra("TeamNameBottom", teamTwo);

        context.startActivity(startBaseball);
    }

}
