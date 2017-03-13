package com.lab.nigue.parouimpar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class PlayerActivity extends AppCompatActivity {

    private EditText etPlayer;
    private Spinner spSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        etPlayer = (EditText)findViewById(R.id.etPlayer);
        spSexo = (Spinner)findViewById(R.id.spSexo);
    }

    public void Jogar(View view) {
        Intent i = new Intent(this, GameActivity.class);
        i.putExtra("PLAYER", etPlayer.getText().toString());
        i.putExtra("SEXO", spSexo.getSelectedItem().toString());
        startActivity(i);
        finish();
    }
}
