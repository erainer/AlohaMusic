package net.androidbootcamp.alohamusic;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayMusic extends AppCompatActivity {

    Button button1, button2;
    MediaPlayer mpUkulele, mpDrums;
    int playing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        button1 = (Button) findViewById(R.id.btnUkulele);
        button2 = (Button) findViewById(R.id.btnDrums);
        mpUkulele = MediaPlayer.create(this, R.raw.ukulele);
        mpDrums = MediaPlayer.create(this,R.raw.drums);
        playing = 0;
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(playing){
                    case 0:
                        mpUkulele.start();
                        playing = 1;
                        button1.setText("Pause Ukulele Song");
                        button2.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        mpUkulele.pause();
                        playing = 0;
                        button1.setText("Play Ukulele Song");
                        button2.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(playing){
                    case 0:
                        mpDrums.start();
                        playing = 1;
                        button2.setText("Pause Drum Song");
                        button1.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        mpDrums.pause();
                        playing = 0;
                        button2.setText("Play Drum Song");
                        button1.setVisibility(View.VISIBLE);
                        break;

                }
            }
        });

    }


}
