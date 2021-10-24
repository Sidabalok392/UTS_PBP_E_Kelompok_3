package com.example.easy_learning.model;

import com.example.easy_learning.R;

import java.util.ArrayList;

public class PelajaranSMA {
    public ArrayList<SMA> listsma;
    public PelajaranSMA() {
        listsma=new ArrayList<>();
        listsma.add(IPA);
        listsma.add(Matematika);
        listsma.add(Bahasa_Indonesia);
    }

    public static SMA IPA = new SMA(R.drawable.ipa,"Ilmu Pengetahuan Alam","Paket SMA (10-12) Reguler 1 Tahun Ajaran + BONUS +\n\n+Ribuan video pembelajaran & animasi menarik+\n+Latihan soal & video pembahasan+\n\n+[Bonus] Tanya Tutor+\n+[Bonus] Live Class+\n+[Bonus] Tryout Ujian Nasional");

    public static SMA Matematika = new SMA(R.drawable.math,"Matematika","Paket SMA (10-12) Reguler 1 Tahun Ajaran + BONUS +\n\n+Ribuan video pembelajaran & animasi menarik+\n+Latihan soal & video pembahasan+\n\n+[Bonus] Tanya Tutor+\n+[Bonus] Live Class+\n+[Bonus] Tryout Ujian Nasional");

    public static SMA Bahasa_Indonesia = new SMA(R.drawable.bahasa,"Bahasa Indonesia & Inggris","Paket SMA (10-12) Reguler 1 Tahun Ajaran + BONUS +\n\n+Ribuan video pembelajaran & animasi menarik+\n+Latihan soal & video pembahasan+\n\n+[Bonus] Tanya Tutor+\n+[Bonus] Live Class+\n+[Bonus] Tryout Ujian Nasional");
}
