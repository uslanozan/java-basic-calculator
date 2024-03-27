package com.cybtech.basiccalculator;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTxtBirinciSayi,editTxtIkinciSayi;
    private TextView txtSonuc;
    private String sayi1,sayi2;
    private int sayi1_int,sayi2_int,sonuc;
    private Hesapla hesapla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editTxtBirinciSayi=(EditText)findViewById(R.id.editTextBirinciSayi);
        editTxtIkinciSayi=(EditText)findViewById(R.id.editTextIkinciSayi);
        txtSonuc=(TextView)findViewById(R.id.txtSonuc);

    }

    public void btnHesapla(View v){
        sayi1=editTxtBirinciSayi.getText().toString();
        sayi2=editTxtIkinciSayi.getText().toString();

        if (!TextUtils.isEmpty(sayi1) && !TextUtils.isEmpty(sayi2)){
            sayi1_int=Integer.valueOf(sayi1);
            sayi2_int=Integer.valueOf(sayi2);
            hesapla=new Hesapla(sayi1_int,sayi2_int);

            //Switch-case hata veriyor
            if (v.getId() == R.id.btnTopla) {
                sonuc = hesapla.sonucuGonder("+");
            } else if (v.getId() == R.id.btnCikar) {
                sonuc = hesapla.sonucuGonder("-");
            } else if (v.getId() == R.id.btnCarp) {
                sonuc = hesapla.sonucuGonder("*");
            } else if (v.getId() == R.id.btnBol) {
                sonuc = hesapla.sonucuGonder("/");
            }

            txtSonuc.setText("Sonuç:"+sonuc);

        }else {
            txtSonuc.setText("Girilen Değerler Boş Olamaz");
        }

    }
}