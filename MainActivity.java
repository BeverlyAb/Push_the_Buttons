package com.example.ba004737953.abadinesbuttons;

import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static RadioGroup radio_g;
    private static RadioButton radio_select;
    private static Button button_submit;

    private static ImageView imgView;
    private static Button button_surprise;

    private int current_image_index;
    int[] images ={R.mipmap.ic_launcher,R.mipmap.joke};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickListenerButton();
        buttonClick();
    }

    public void buttonClick() {
        imgView = (ImageView)findViewById(R.id.imageView);
        button_surprise = (Button)findViewById(R.id.button2);
        button_surprise.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            current_image_index++;
                            current_image_index = current_image_index % images.length;
                            imgView.setImageResource(images[current_image_index]);
                        }
                    }
        );
    }



    public void onClickListenerButton() {
        radio_g = (RadioGroup)findViewById(R.id.rg_level);
        button_submit = (Button)findViewById(R.id.button1);

        button_submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int selected_id = radio_g.getCheckedRadioButtonId();
                        radio_select = (RadioButton)findViewById(selected_id);
                        Toast.makeText(MainActivity.this,
                                radio_select.getText().toString(),Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
} // BA
