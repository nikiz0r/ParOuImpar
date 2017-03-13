package com.lab.nigue.parouimpar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private TextView tvPlayer, tvSexo;
    private EditText etJogadaAdv, etSuaJogada;
    private RadioGroup rgJogada;
    private int selectedPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tvPlayer = (TextView)findViewById(R.id.tvPlayer);
        tvSexo = (TextView)findViewById(R.id.tvSexo);
        etJogadaAdv = (EditText)findViewById(R.id.etJogadaAdv);
        etSuaJogada = (EditText)findViewById(R.id.etSuaJogada);
        rgJogada = (RadioGroup)findViewById(R.id.rgJogada);

        if (getIntent() != null){
            tvPlayer.setText(getIntent().getStringExtra("PLAYER"));
            tvSexo.setText(getIntent().getStringExtra("SEXO"));
        }
    }

    public void Jogar(View view) {
        switch (rgJogada.getCheckedRadioButtonId()){
            case R.id.rbImpar:
                selectedPlay = 1;
                break;
            case R.id.rbPar:
                selectedPlay = 0;
                break;
            default:
                selectedPlay = 0;
        }

        int jogadaPlayer = Integer.parseInt(etSuaJogada.getText().toString());
        if (selectedPlay == 0){
            if (jogadaPlayer % 2 == 0)
                etJogadaAdv.setText("1");
            else
                etJogadaAdv.setText("0");
        }else{
            if (jogadaPlayer % 2 == 0)
                etJogadaAdv.setText("0");
            else
                etJogadaAdv.setText("1");
        }

        VerificaVitoria();
    }

    public void VerificaVitoria(){
        int soma = Integer.parseInt(etJogadaAdv.getText().toString())
                + Integer.parseInt(etSuaJogada.getText().toString());

        if ((selectedPlay == 0 && soma % 2 == 0) || (selectedPlay == 1 && soma % 2 == 1)){
            Toast.makeText(this, "Você ganhou!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Você perdeu!", Toast.LENGTH_SHORT).show();
        }
    }
}
