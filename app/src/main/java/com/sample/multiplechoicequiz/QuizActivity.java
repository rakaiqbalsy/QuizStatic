package com.sample.multiplechoicequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    //konsep pholimorphism :D
    private QuestionBank LibraryPertanyaan = new QuestionBank();
    private TextView nScoreView;   // Untuk menampilkan skor saat ini
    private TextView nQuestionView;  //menampilkan jawaban
    private Button nPilihanA; // jawaban A
    private Button nPilihanB; // jawaban B
    private Button nPilihanC; //jawaban C
    private Button nPilihanD; //jawaban D

    private String nAnswer;  // untuk cek jawaban benar atau tidaknya
    private int nScore = 0;  // Score Awal
    private int NoPertanyaan = 0; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        //
        nScoreView = (TextView)findViewById(R.id.score);
        nQuestionView = (TextView)findViewById(R.id.pertanyaan);
        nPilihanA = (Button)findViewById(R.id.pilA);
        nPilihanB = (Button)findViewById(R.id.pilB);
        nPilihanC = (Button)findViewById(R.id.pilC);
        nPilihanD = (Button)findViewById(R.id.pilD);
        updatePertanyaan();

        updateScore(nScore);
    }

    private void updatePertanyaan(){
        //Untuk selalu update petanyaan jika masih dipertanyaan ke 1 dan belum ke yang lain akan mengerjakan kondisi if
        if(NoPertanyaan<LibraryPertanyaan.getLength() ){


            nQuestionView.setText(LibraryPertanyaan.getPertanyaan(NoPertanyaan));
            nPilihanA.setText(LibraryPertanyaan.getPilihan(NoPertanyaan, 1));
            nPilihanB.setText(LibraryPertanyaan.getPilihan(NoPertanyaan, 2));
            nPilihanC.setText(LibraryPertanyaan.getPilihan(NoPertanyaan, 3));
            nPilihanD.setText(LibraryPertanyaan.getPilihan(NoPertanyaan, 4));
            nAnswer = LibraryPertanyaan.getJawabanBenar(NoPertanyaan);
            NoPertanyaan++;
       }
        else {
            Toast.makeText(QuizActivity.this, "Pertanyaan Terakhir", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QuizActivity.this, HighestScoreActivity.class);
            intent.putExtra("score", nScore); // put Score yang nanti di get ke Activity HighScore
            startActivity(intent);
        }
    }

    private void updateScore(int point) {
        nScoreView.setText("" + nScore+"/"+LibraryPertanyaan.getLength());
    }

    public void onClick(View view) {
        Button answer = (Button) view;
        // Menambah Score
        if (answer.getText() == nAnswer){
            nScore = nScore + 1;
             Toast.makeText(QuizActivity.this, "Benar!", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(QuizActivity.this, "Salah!", Toast.LENGTH_SHORT).show();

        updateScore(nScore);
        updatePertanyaan();
    }
 }