package com.example.amantesdegames_bl;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView w = findViewById(R.id.web);
        w.setWebViewClient(new WebViewClient());
        w.setWebChromeClient(new WebChromeClient());
        //habilitando a execução do JS
        WebSettings conf = w.getSettings();
        conf.setJavaScriptEnabled(true);

        w.addJavascriptInterface(new Ponte(this),"Chamada");

        w.loadUrl("file:///android_asset/index.html");
    }

    public class Ponte {
        Context contexto;


        public Ponte(Context contexto) {
            this.contexto = contexto;
        }


        @JavascriptInterface
        public void envia(String name, String email, String password) {

            try {
                BancoDeDados bd = new BancoDeDados(this.contexto);
                bd.insereUser(name, email, password);
                Toast.makeText(this.contexto, "Conta salvada", Toast.LENGTH_SHORT).show();
            } catch (Exception ex) {
                Toast.makeText(this.contexto, "Erro na criação:"+ex.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        public String result;

        @JavascriptInterface
        public void consultar() {
            BancoDeDados bd = new BancoDeDados(this.contexto);
            ArrayList<String> resultado =  bd.consulta();
            String mensagem = "";
            for (int i=0; i< resultado.size(); i++) {
                mensagem += resultado.get(i);
            }
            result = mensagem;

        }

        @JavascriptInterface
        public String getResult() {
            consultar();
            return result;
        }
    }
}
