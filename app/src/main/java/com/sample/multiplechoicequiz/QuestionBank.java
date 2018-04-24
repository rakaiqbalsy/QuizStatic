package com.sample.multiplechoicequiz;

public class QuestionBank {

    //buat array list nya dulu
    private String textPertanyaan [] = {
            "1. Kapan Pertama Kali IF UIN Berdiri?",
            "2. siapa ketua Himatif Periode 2017-2018?",
            "3. siapa Ketua BSO Android sekarang?",
            "4. Apa nama lengkap Atoel?",
            "5. Kapan Atul Lahir?"
    };

    // Pilihan jawaban
    private String pilihanJawaban [][] = {
            {"2000", "1945", "2002", "2006"},
            {"MJ_UHUY", "Arip Zamzami", "Rizki Aditia", "Arip Krismunandar"},
            {"Atoel", "Kang Nicko", "Kang Fadil", "Imeh"},
            {"Zafiratoel Amalia", "Amalia Zafiratoel", "Zafiratul Amalia", "Amalia Zafiratul"},
            {"1960", "1997", "1930", "1947"}
    };

    private String jawabanBenar[] = {"2000", "Arip Zamzami", "Imeh", "Zafiratul Amalia", "1997"};

    //menampung banyak pertanyaan atau jumlah pertanyaan....
    public int getLength(){
        return textPertanyaan.length;
    }

    //method untuk mengambil pertanyaan dari array
    public String getPertanyaan(int a) {
        String soal = textPertanyaan[a];
        return soal;
    }

    //method untuk mengambil jawaban array
    public String getPilihan(int index, int num) {
        String pilihan0 = pilihanJawaban[index][num-1];
        return pilihan0;
    }

    //method untuk mengambil jawaban benar
    public String getJawabanBenar(int a) {
        String answer = jawabanBenar[a];
        return answer;
    }
}