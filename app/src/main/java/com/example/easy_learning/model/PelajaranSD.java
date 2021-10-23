package com.example.easy_learning.model;

import com.example.easy_learning.R;

import java.util.ArrayList;

public class PelajaranSD {
    public ArrayList<SD> listsd;
    public PelajaranSD() {
        listsd=new ArrayList<>();
        listsd.add(IPA);
        listsd.add(Matematika);
        listsd.add(Bahasa_Indonesia);
    }

    public static SD IPA = new SD(R.drawable.ipa,"Ilmu Pengetahuan Alam","Paket SD (1-6) Reguler 1 Tahun Ajaran + BONUS +\n\n+Ribuan video pembelajaran & animasi menarik+\n+Latihan soal & video pembahasan+\n\n+[Bonus] Tanya Tutor+\n+[Bonus] Live Class+\n+[Bonus] Tryout Ujian Nasional");

    public static SD Matematika = new SD(R.drawable.math,"Matematika","Paket SD (1-6) Reguler 1 Tahun Ajaran + BONUS +\n\n+Ribuan video pembelajaran & animasi menarik+\n+Latihan soal & video pembahasan+\n\n+[Bonus] Tanya Tutor+\n+[Bonus] Live Class+\n+[Bonus] Tryout Ujian Nasional");

    public static SD Bahasa_Indonesia = new SD(R.drawable.bahasa,"Bahasa Indonesia & Inggris","Paket SD (1-6) Reguler 1 Tahun Ajaran + BONUS +\n\n+Ribuan video pembelajaran & animasi menarik+\n+Latihan soal & video pembahasan+\n\n+[Bonus] Tanya Tutor+\n+[Bonus] Live Class+\n+[Bonus] Tryout Ujian Nasional");


}
