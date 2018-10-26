package com.example.admin.yougohcalculadora;


import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.String;
import java.util.ArrayList;
import java.util.Random;


public class TelaCalculadora extends AppCompatActivity {
    private SQLiteDatabase bancoDuelista;
    private static final int UI_ANIMATION_DELAY = 30;
    private final Handler mHideHandler = new Handler();
    private View apresentaOptions;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @Override
        public void run() {
            apresentaOptions.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };

    private TextView lifePoint, nomePlayer1, nomePlayer2, nomePlayer3, nomePlayer4, LPplayer1, LPplayer2, LPplayer3, LPplayer4;

    private Boolean operadorAtivo = true;

    Button botao0, botao1, botao2, botao3, botao4, botao5, botao6, botao7, botao8, botao9, botao500, botao1000;
    Button deletar, botaoSomar, botaoSubtrair, botaoResultado1, botaoResultado2, botaoOkay, botaoCancelar;

    //String para delete e altera nome
    String delete, alteraNome;

    //Ativadores dos players
    Duelista duelista1, duelista2, duelista3, duelista4;

    //declaração das imageView dos players, recompor e dado;
    ImageView imagemP1, imagemP2, imagemP3, imagemP4, recomporLP;
    //view animação dado
    View animacao_dado;

    //Layout de menu e Layout Geral;
    View menu, layoutGeral, optionsID;
    //visibilidade do menu;
    int resultado;
    // string para tamanho do lp
    String LPtamanho;
    // editor de nome
    EditText editarNomePlayer;
    //Array de duelista
    ArrayList<Duelista> listaDuelista;    ArrayList<ImageView> listaDeImagem;    ArrayList<TextView> listaDeHps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tela_calculadora);

        editarNomePlayer = findViewById(R.id.EditNomePlayer);

        apresentaOptions = findViewById(R.id.layoutId);
        layoutGeral = findViewById(R.id.layoutGeralId);

        botao0 = findViewById(R.id.botao0);        botao1 = findViewById(R.id.botao1id);
        botao2 = findViewById(R.id.botao2id);        botao3 = findViewById(R.id.botao3id);
        botao4 = findViewById(R.id.botao4id);        botao5 = findViewById(R.id.botao5id);
        botao6 = findViewById(R.id.botao6id);        botao7 = findViewById(R.id.botao7id);
        botao8 = findViewById(R.id.botao8id);        botao9 = findViewById(R.id.botao9id);
        botao500 = findViewById(R.id.botao500id);        botao1000 = findViewById(R.id.botao1000id);
        botaoSomar = findViewById(R.id.botaoSomar);        botaoSubtrair = findViewById(R.id.botaoSubtrair);
        deletar = findViewById(R.id.deleteButton);
        botaoResultado1 = findViewById(R.id.idResultado1);
        botaoResultado2 = findViewById(R.id.idResultado2);
        botaoOkay = findViewById(R.id.botaoOkay);
        botaoCancelar = findViewById(R.id.botaoCancelar);


        // setando os clicks

        botao0.setOnClickListener(clickBotao);        botao1.setOnClickListener(clickBotao);
        botao2.setOnClickListener(clickBotao);        botao3.setOnClickListener(clickBotao);
        botao4.setOnClickListener(clickBotao);        botao5.setOnClickListener(clickBotao);
        botao6.setOnClickListener(clickBotao);        botao7.setOnClickListener(clickBotao);
        botao8.setOnClickListener(clickBotao);        botao9.setOnClickListener(clickBotao);
        botao1000.setOnClickListener(clickBotao);        botao500.setOnClickListener(clickBotao);
        deletar.setOnClickListener(clickBotao);
        botaoSomar.setOnClickListener(clickBotao);        botaoSubtrair.setOnClickListener(clickBotao);
        botaoResultado1.setOnClickListener(clickBotao);        botaoResultado2.setOnClickListener(clickBotao);
        botaoOkay.setOnClickListener(clickBotao);
        botaoCancelar.setOnClickListener(clickBotao);
        layoutGeral.setOnClickListener(clickBotao);

        //instanciaçao dos botoes dos players

        imagemP1 = findViewById(R.id.player1id); imagemP2 = findViewById(R.id.player2id);
        imagemP3 = findViewById(R.id.player3id); imagemP4 = findViewById(R.id.player4id);


        nomePlayer1 = findViewById(R.id.nameP1);        nomePlayer2 = findViewById(R.id.nameP2);
        nomePlayer3 = findViewById(R.id.nameP3);        nomePlayer4 = findViewById(R.id.nameP4);
        recomporLP = findViewById(R.id.recompor);

        //instanciação do Lifepoints
        LPplayer1 = findViewById(R.id.lifePointsP1);        LPplayer2 = findViewById(R.id.lifePointsP2);
        LPplayer3 = findViewById(R.id.lifePointsP3);        LPplayer4 = findViewById(R.id.lifePointsP4);
        animacao_dado = findViewById(R.id.animacao_dado);

        LPplayer1.setOnClickListener(clickBotao);        LPplayer2.setOnClickListener(clickBotao);
        LPplayer3.setOnClickListener(clickBotao);        LPplayer4.setOnClickListener(clickBotao);

        //instanciação do visor
        lifePoint = findViewById(R.id.visorId);

        imagemP1.setOnLongClickListener(clickLongo);        imagemP2.setOnLongClickListener(clickLongo);
        imagemP3.setOnLongClickListener(clickLongo);        imagemP4.setOnLongClickListener(clickLongo);

        imagemP1.setOnClickListener(clickBotao);        imagemP2.setOnClickListener(clickBotao);
        imagemP3.setOnClickListener(clickBotao);        imagemP4.setOnClickListener(clickBotao);
        recomporLP.setOnClickListener(clickBotao);
        animacao_dado.setOnClickListener(clickBotao);

        duelista1 = new Duelista();        duelista2 = new Duelista();
        duelista3 = new Duelista();        duelista4 = new Duelista();
        //layoutGeral.setOnLongClickListener(clickLongo);
        menu = findViewById(R.id.menuId);
        optionsID = findViewById(R.id.optionsId);
        layoutGeral.setOnLongClickListener(Options);
        editarNomePlayer = findViewById(R.id.EditNomePlayer);

        duelista1 = new Duelista();        duelista2 = new Duelista();
        duelista4 = new Duelista();        duelista3 = new Duelista();

        //ArrayList Duelista
        listaDuelista = new ArrayList<>();
        listaDuelista.add(duelista1);        listaDuelista.add(duelista2);
        listaDuelista.add(duelista3);        listaDuelista.add(duelista4);
        //adiciona as imagens dos players em uma arraylist
        listaDeImagem = new ArrayList<>();
        listaDeImagem.add(imagemP1);        listaDeImagem.add(imagemP2);
        listaDeImagem.add(imagemP3);        listaDeImagem.add(imagemP4);
        //adicionar os lps dos players em uma arraylist;
        listaDeHps = new ArrayList<>();
        listaDeHps.add(LPplayer1);        listaDeHps.add(LPplayer2);
        listaDeHps.add(LPplayer3);        listaDeHps.add(LPplayer4);
        //instancia o banco de dados;
        bancoDuelista = openOrCreateDatabase("BancoDuelista",MODE_PRIVATE, null);
        //criar as tabelas
        bancoDuelista.execSQL("CREATE TABLE IF NOT EXISTS duelista(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nome VARCHAR NOT NULL , vitorias INTEGER NOT NULL, derrotas INTEGER NOT NULL, imagem BLOB)");
    }

    private View.OnLongClickListener Options = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            if (optionsID.getVisibility() == View.INVISIBLE) {
                optionsID.setVisibility(View.VISIBLE);
            } else {
                optionsID.setVisibility(View.INVISIBLE);
            }
            return false;
        }
    };
    private View.OnLongClickListener clickLongo = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            if (menu.getVisibility() == View.INVISIBLE) {
                menu.setVisibility(View.VISIBLE);
            } else {
                menu.setVisibility(View.INVISIBLE);
            }
            return false;
        }
    };

    private View.OnClickListener clickBotao;
    {
        clickBotao = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.botao0:
                        apertaNumero(botao0,lifePoint);
                        break;
                    case R.id.botao1id:
                        apertaNumero(botao1,lifePoint);
                        break;
                    case R.id.botao2id:
                        apertaNumero(botao2,lifePoint);
                        break;
                    case R.id.botao3id:
                        apertaNumero(botao3,lifePoint);
                        break;
                    case R.id.botao4id:
                        apertaNumero(botao4,lifePoint);
                        break;
                    case R.id.botao5id:
                        apertaNumero(botao5,lifePoint);
                        break;
                    case R.id.botao6id:
                        apertaNumero(botao6,lifePoint);
                        break;
                    case R.id.botao7id:
                        apertaNumero(botao7,lifePoint);
                        break;
                    case R.id.botao8id:
                        apertaNumero(botao8,lifePoint);
                        break;
                    case R.id.botao9id:
                        apertaNumero(botao9,lifePoint);
                        break;
                    case R.id.botao1000id:
                        apertaNumero(botao1000,lifePoint);
                        break;
                    case R.id.botao500id:
                        apertaNumero(botao500,lifePoint);
                        break;
                    case R.id.botaoSomar:
                        LPtamanho = lifePoint.getText().toString();
                        if (operadorAtivo | LPtamanho.length() <= 0) {
                            Toast.makeText(getApplicationContext(), "Tente colocar um número antes.", Toast.LENGTH_SHORT).show();
                        } else {
                            apertaNumero(botaoSomar,lifePoint);
                            operadorAtivo = true;
                        }
                        break;
                    case R.id.botaoSubtrair:
                        LPtamanho = lifePoint.getText().toString();
                        if (operadorAtivo | LPtamanho.length() <= 0) {
                            Toast.makeText(getApplicationContext(), "Tente colocar um número antes.", Toast.LENGTH_SHORT).show();
                        } else {
                            apertaNumero(botaoSubtrair,lifePoint);
                            operadorAtivo = true;
                        }
                        break;
                    case R.id.deleteButton:
                        delete = lifePoint.getText().toString();
                        char ultimoDigito;
                        if (delete.length() > 0) {
                            delete = delete.substring(0, delete.length() - 1);
                            if(delete.length() > 0){
                                ultimoDigito = delete.charAt(delete.length() - 1 );

                                if(ultimoDigito == '-' || ultimoDigito == '+'){
                                    operadorAtivo = true;
                                }
                            }
                            lifePoint.setText(delete);
                        }
                        break;
                    case R.id.lifePointsP1:

                        ativarPlayer(duelista1,listaDuelista,listaDeImagem,lifePoint);
                        break;
                    case R.id.lifePointsP2:
                        ativarPlayer(duelista2,listaDuelista,listaDeImagem,lifePoint);
                        break;
                    case R.id.lifePointsP3:
                        ativarPlayer(duelista3,listaDuelista,listaDeImagem,lifePoint);
                        break;
                    case R.id.lifePointsP4:
                        ativarPlayer(duelista4,listaDuelista,listaDeImagem,lifePoint);
                        break;
                    case R.id.botaoOkay:
                        alteraNome = editarNomePlayer.getText().toString();
                        if (duelista1.isAtivo()) {
                            duelista1.setNome(alteraNome);
                            nomePlayer1.setText(duelista1.getNome());
                        } else if (duelista2.isAtivo()) {
                            duelista2.setNome((alteraNome));
                            nomePlayer2.setText(duelista2.getNome());
                        } else if (duelista3.isAtivo()) {
                            duelista3.setNome((alteraNome));
                            nomePlayer3.setText(duelista3.getNome());
                        } else if (duelista4.isAtivo()) {
                            duelista4.setNome((alteraNome));
                            nomePlayer4.setText(duelista4.getNome());
                        }
                        menu.setVisibility(View.INVISIBLE);
                        editarNomePlayer.setText("");
                        hide();

                        break;
                    case R.id.botaoCancelar:
                        menu.setVisibility(View.INVISIBLE);
                        hide();
                        break;
                    case R.id.player1id:
                        ativarPlayer(duelista1, listaDuelista,listaDeImagem,lifePoint);
                        break;
                    case R.id.player2id:
                        ativarPlayer(duelista2,listaDuelista,listaDeImagem,lifePoint);
                        break;
                    case R.id.player3id:
                        ativarPlayer(duelista3,listaDuelista,listaDeImagem,lifePoint);
                        break;
                    case R.id.player4id:
                        ativarPlayer(duelista4, listaDuelista,listaDeImagem,lifePoint);
                        break;
                    case R.id.layoutGeralId:
                        hide();
                        break;
                    // Setando os resultados
                    case R.id.idResultado1:
                        if (lifePoint.getText().toString().indexOf("+") > 0) {
                            resultado = somar(lifePoint.getText().toString());
                            lifePoint.setText(String.valueOf(resultado));
                            operadorAtivo = false;
                            //verifica qual player está ativo;
                            resultadoCalculo(lifePoint,listaDuelista,listaDeHps);
                        }
                        if (lifePoint.getText().toString().indexOf("-") > 0) {
                            resultado = diminuir(lifePoint.getText().toString());
                            lifePoint.setText(String.valueOf(resultado));
                            //verifica qual player está ativo;
                            resultadoCalculo(lifePoint,listaDuelista,listaDeHps);
                        }
                        break;
                    case R.id.idResultado2:
                        if (lifePoint.getText().toString().indexOf("+") > 0) {
                            resultado = somar(lifePoint.getText().toString());
                            lifePoint.setText(String.valueOf(resultado));
                            operadorAtivo = false;

                            // verifica qual player está ativo.
                            resultadoCalculo(lifePoint,listaDuelista,listaDeHps);
                        }
                        if (lifePoint.getText().toString().indexOf("-") > 0) {
                            resultado = diminuir(lifePoint.getText().toString());
                            lifePoint.setText(String.valueOf(resultado));

                            // verifica qual player está ativo.
                            resultadoCalculo(lifePoint,listaDuelista,listaDeHps);
                        }
                        break;
                    case R.id.recompor:
                        recomporLifesPoints(listaDuelista, listaDeHps);
                        break;
                    case R.id.animacao_dado:
                        jogarDado(animacao_dado);
                        break;
                    default:

                }
            }
        };
    }

    private void hide() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @Override
    protected void onStart() {
        super.onStart();
        hide();
    }

    public int somar(String recebeNum) {
        int soma = 0;
        String[] somaNum = recebeNum.split("\\+");
        for (String aSomaNum : somaNum) {
            String num = aSomaNum;
            if (num.indexOf("-") > 0) {
                num = String.valueOf(diminuir(num));
            }
            soma = soma + Integer.parseInt(num);
        }
        return soma;
    }

    public int diminuir(String recebeNum) {
        int diminuido = 0;
        String[] diminuirNum = recebeNum.split("-");
        for (int i = 0; i < diminuirNum.length; i++) {
            String num = diminuirNum[i];
            if (i == 0) {
                diminuido = Integer.parseInt(num);
            } else {
                diminuido = diminuido - Integer.parseInt(num);
            }
        }
        return diminuido;
    }

    public void ativarPlayer(Duelista duelAtivar, ArrayList<Duelista> lista, ArrayList<ImageView> listaImagens, TextView lp) {
        try {
            for (int i = 0; i < lista.size() & i < listaImagens.size(); i++) {
                if (duelAtivar.equals(lista.get(i))) {
                    duelAtivar.setAtivo(true);
                    listaImagens.get(i).setAlpha(1.0f);
                    lp.setText(duelAtivar.getLifepoint());
                } else {
                    lista.get(i).setAtivo(false);
                    listaImagens.get(i).setAlpha(0.62f);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        operadorAtivo = false;
    }

    public void recomporLifesPoints(ArrayList<Duelista> listaPlayers, ArrayList<TextView> listaDeHps) {
        for(int i = 0; i < listaPlayers.size() & i < listaDeHps.size(); i++){
            listaPlayers.get(i).setLifepoint(getString(R.string.lifepoint));
            listaDeHps.get(i).setText(getString(R.string.lifepoint));
        }
    }

     public void resultadoCalculo(TextView lp, ArrayList<Duelista> listaPlayers, ArrayList<TextView> listaDeHp) {
         for(int i = 0; i < listaPlayers.size(); i++){
             if(listaPlayers.get(i).isAtivo()){
                 listaPlayers.get(i).setLifepoint(lp.getText().toString());
                 listaDeHp.get(i).setText(listaPlayers.get(i).getLifepoint());
             }
         }
    }

    public void jogarDado(View dado) {
        try {
            for (int i = 0; i < 6; i++) {
                Random numeroDado = new Random();
                int numConvertido = numeroDado.nextInt(6) + 1;

                //faz calculo para negaticar resultado

                PropertyValuesHolder animX = PropertyValuesHolder.ofFloat("scaleX", 1f, 2.5f, 1f);
                PropertyValuesHolder animY = PropertyValuesHolder.ofFloat("scaleY", 1f, 2.5f, 1f);

                ObjectAnimator.ofPropertyValuesHolder(dado, animX, animY).setDuration(1500).start();

                if (numConvertido == 1) {
                    dado.setBackgroundResource(R.drawable.animacao_dado1);
                    AnimationDrawable animationDado1 = (AnimationDrawable) dado.getBackground();
                    animationDado1.run();
                }
                if (numConvertido == 2) {
                    dado.setBackgroundResource(R.drawable.animacao_dado2);
                    AnimationDrawable animationDado1 = (AnimationDrawable) dado.getBackground();
                    animationDado1.run();
                }
                if (numConvertido == 3) {
                    dado.setBackgroundResource(R.drawable.animacao_dado3);
                    AnimationDrawable animationDado1 = (AnimationDrawable) dado.getBackground();
                    animationDado1.run();

                }
                if (numConvertido == 4) {
                    dado.setBackgroundResource(R.drawable.animacao_dado4);
                    AnimationDrawable animationDado1 = (AnimationDrawable) dado.getBackground();
                    animationDado1.run();
                }
                if (numConvertido == 5) {
                    dado.setBackgroundResource(R.drawable.animacao_dado5);
                    AnimationDrawable animationDado1 = (AnimationDrawable) dado.getBackground();
                    animationDado1.run();

                }
                if (numConvertido == 6) {
                    dado.setBackgroundResource(R.drawable.animacao_dado6);
                    AnimationDrawable animationDado1 = (AnimationDrawable) dado.getBackground();
                    animationDado1.run();

                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void apertaNumero(Button botao, TextView lifePoint){
        lifePoint.setText(lifePoint.getText() + botao.getText().toString());
        operadorAtivo = false;
    }
    public void criarDuelista(Duelista duelista){
       bancoDuelista.execSQL("INSERT INTO duelista(nome,vitorias,derrotas,imagem) VALUES ('" + duelista.getNome()
               +"','" +duelista.getVitorias() + "','" + duelista.getDerrotas() + ")");
    }
    public void removerDuelista(){

    }
    public void selecionarDuelista(){

    }public void atualizarDuelista(){

    }public void listarDuelistas(){

    }
}
