package com.example.scienceproject2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;



public class defenseScreen extends AppCompatActivity {

    public void LaunchHomeScreen() {
        Intent homeScreen = new Intent(this, MainActivity.class);
        startActivity(homeScreen);
    }

    public void LaunchAttackScreen() {
        Intent attackScreen = new Intent(this, attackScreen.class);
        startActivity(attackScreen);
    }

    public void LaunchDefenseScreen() {
        Intent defenseScreen = new Intent(this, defenseScreen.class);
        startActivity(defenseScreen);
    }

    FloatingActionButton backToHome, goToAttack, goToDefense;
    ExtendedFloatingActionButton mAddFab;
    TextView directToHomeActionText, DirectToAttackActionText, DirectToDefenseActionText;
    // to check whether sub FABs are visible or not
    Boolean isAllFabsVisible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defense_screen);
        mAddFab = findViewById(R.id.add_fab);
        backToHome = findViewById(R.id.direct_to_home_fab);
        goToAttack = findViewById(R.id.direct_to_attack_fab);
        goToDefense = findViewById(R.id.direct_to_defense_fab);
        directToHomeActionText =
                findViewById(R.id.direct_to_home_action_text);
        DirectToAttackActionText =
                findViewById(R.id.direct_to_attack_action_text);
        DirectToDefenseActionText =
                findViewById(R.id.direct_to_defense_action_text);
        // Now set all the FABs and all the action name
        // texts as GONE
        backToHome.setVisibility(View.GONE);
        goToAttack.setVisibility(View.GONE);
        goToDefense.setVisibility(View.GONE);
        directToHomeActionText.setVisibility(View.GONE);
        DirectToAttackActionText.setVisibility(View.GONE);
        DirectToDefenseActionText.setVisibility(View.GONE);
        // make the boolean variable as false, as all the
        // action name texts and all the sub FABs are
        // invisible
        isAllFabsVisible = false;
        // Set the Extended floating action button to
        // shrinked state initially
        mAddFab.shrink();
        // We will make all the FABs and action name texts
        // visible only when Parent FAB button is clicked So
        // we have to handle the Parent FAB button first, by
        // using setOnClickListener you can see below
        mAddFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!isAllFabsVisible) {
                            // when isAllFabsVisible becomes
                            // true make all the action name
                            // texts and FABs VISIBLE.
                            backToHome.show();
                            goToAttack.show();
                            goToDefense.show();
                            directToHomeActionText
                                    .setVisibility(View.VISIBLE);
                            DirectToAttackActionText
                                    .setVisibility(View.VISIBLE);
                            DirectToDefenseActionText
                                    .setVisibility(View.VISIBLE);
                            // Now extend the parent FAB, as
                            // user clicks on the shrinked
                            // parent FAB
                            mAddFab.extend();
                            // make the boolean variable true as
                            // we have set the sub FABs
                            // visibility to GONE
                            isAllFabsVisible = true;
                        } else {
                            // when isAllFabsVisible becomes
                            // true make all the action name
                            // texts and FABs GONE.
                            backToHome.hide();
                            goToAttack.hide();
                            goToDefense.hide();
                            directToHomeActionText
                                    .setVisibility(View.GONE);
                            DirectToAttackActionText
                                    .setVisibility(View.GONE);
                            DirectToDefenseActionText
                                    .setVisibility(View.GONE);
                            // Set the FAB to shrink after user
                            // closes all the sub FABs
                            mAddFab.shrink();
                            // make the boolean variable false
                            // as we have set the sub FABs
                            // visibility to GONE
                            isAllFabsVisible = false;
                        }
                    }
                });
        // below is the sample action to handle add person
        // FAB. Here it shows simple Toast msg. The Toast
        // will be shown only when they are visible and only
        // when user clicks on them
        goToAttack.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText
                                (defenseScreen
                                                .this, "Navigated to Attacker's Perspective...",
                                        Toast.LENGTH_SHORT).show();
                        LaunchAttackScreen();
                    }
                });

        goToDefense.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText
                                (defenseScreen
                                                .this, "Navigated to Defender's Perspective...",
                                        Toast.LENGTH_SHORT).show();
                        LaunchDefenseScreen();
                    }
                });
        // below is the sample action to handle add alarm
        // FAB. Here it shows simple Toast msg The Toast
        // will be shown only when they are visible and only
        // when user clicks on them
        backToHome.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText

                                (defenseScreen
                                                .this, "Navigated back to Information page...",
                                        Toast.LENGTH_SHORT).show();
                        LaunchHomeScreen();
                    }
                });
    }
}