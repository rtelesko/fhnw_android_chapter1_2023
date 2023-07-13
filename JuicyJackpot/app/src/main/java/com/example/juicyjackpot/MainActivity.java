package com.example.juicyjackpot;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Runnable {

    private ImageView slot1, slot2, slot3;
    private Button spinButton, stopButton, finishButton;

    private EditText nickname;

    // Using Handler for simulating the slot machine
    private final Handler handler = new Handler();

    private String[] fruits = {"cherry", "diamond", "horseshoe", "lemon", "seven", "watermelon"};
    private Random random;

    private int fruit1Index, fruit2Index, fruit3Index;

    private boolean gameIsLaunched = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slot1 = findViewById(R.id.slot1);
        slot2 = findViewById(R.id.slot2);
        slot3 = findViewById(R.id.slot3);
        spinButton = findViewById(R.id.launch_button);
        stopButton = findViewById(R.id.stop_button);
        finishButton = findViewById(R.id.finish_button);
        nickname = findViewById(R.id.nickname_edit_text);

        spinButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        finishButton.setOnClickListener(this);

        random = new Random();
    }

    @Override
    public void onStop() {
        super.onStop();
        handler.removeCallbacks(this);
    }

    // Start the slot machine
    @Override
    public void onClick(View v) {
        if (v == spinButton) {
            if (validateNickname(nickname.getText().toString())) {
                launchGame();
            } else Toast.makeText(this, "Please enter valid nickname!", Toast.LENGTH_SHORT).show();
        } else if (v == stopButton) {
            if (gameIsLaunched == true) {
                stopGame();
                analyseGameResult();
            } else Toast.makeText(this, "No game to stop!", Toast.LENGTH_SHORT).show();
        } else if (v == finishButton) {
            finish();
        }
    }

    // Launch the game
    private void launchGame() {
        gameIsLaunched = true;
        handler.postDelayed(this, 100);
    }


    // Stop the game
    public void stopGame() {
        gameIsLaunched = false;
        handler.removeCallbacks(this);
        nickname.setText("");
    }

    private int getFruitImageResource(int index) {
        switch (index) {
            case 0:
                return R.drawable.cherry;
            case 1:
                return R.drawable.diamond;
            case 2:
                return R.drawable.horseshoe;
            case 3:
                return R.drawable.lemon;
            case 4:
                return R.drawable.seven;
            default:
                return R.drawable.watermelon;
        }
    }

    @Override
    public void run() {
        fruit1Index = random.nextInt(fruits.length);
        fruit2Index = random.nextInt(fruits.length);
        fruit3Index = random.nextInt(fruits.length);
        slot1.setImageResource(getFruitImageResource(fruit1Index));
        slot2.setImageResource(getFruitImageResource(fruit2Index));
        slot3.setImageResource(getFruitImageResource(fruit3Index));
        handler.postDelayed(this, (100));
    }

    // Validation of name
    public boolean validateNickname(String txt) {
        String regex = "[a-zA-Z0-9]+";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }

    // Analysing the result of the game
    public void analyseGameResult() {
        if (fruit1Index == fruit2Index && fruit2Index == fruit3Index)
            Toast.makeText(this, "Congratulations! You won!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Try again!", Toast.LENGTH_SHORT).show();
    }
}