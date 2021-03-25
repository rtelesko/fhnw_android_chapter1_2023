package com.example.lotteryimage;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /* Resource Manager for drawables: https://developer.android.com/studio/write/resource-manager
    Basic knowledge about resolution and support different pixel densities: https://developer.android.com/training/multiscreen/screendensities
    What is a high resolution image?
    A high-resolution image is anything that has at least 300 dpi high resolution with a larger pixel dimension,
    for example, 5000 x 4000 pixels.
    */

    // GUI control
    private ImageView ivSimpleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ivSimpleImageView = findViewById(R.id.ivSimpleImageView);
        // We can also set an image resource programmatically into the ImageView by using the setImageResource() method
        // ivSimpleImageView.setImageResource(R.drawable.lottery);
        // setContentDescription() allows you to associate a textual description to the view
        // The docs state that it's primarily used to support accessibility
        // ivSimpleImageView.setContentDescription("A lottery picture");
    }
}
