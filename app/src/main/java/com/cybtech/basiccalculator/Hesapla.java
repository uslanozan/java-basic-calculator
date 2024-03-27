package com.cybtech.basiccalculator;

public class Hesapla {
    private int gelenSayi1,gelenSayi2;

    public Hesapla(int gelenSayi1, int gelenSayi2) {
        this.gelenSayi1 = gelenSayi1;
        this.gelenSayi2 = gelenSayi2;
    }


    public int sonucuGonder(String islemTuru){
        switch (islemTuru){
            case "+":
                return gelenSayi1+gelenSayi2;
            case "-":
                return gelenSayi1-gelenSayi2;
            case "*":
                return gelenSayi1*gelenSayi2;
            case "/":
                return gelenSayi1/gelenSayi2;
            default:
                return 0;
        }
    }
}
