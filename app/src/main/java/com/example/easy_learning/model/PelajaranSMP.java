package com.example.easy_learning.model;

import com.example.easy_learning.R;

import java.util.ArrayList;

public class PelajaranSMP {
    public ArrayList<SMP> listsmp;
    public PelajaranSMP() {
        listsmp=new ArrayList<>();
        listsmp.add(IPA);
        listsmp.add(Matematika);
        listsmp.add(Bahasa_Indonesia);
    }

    public static SMP IPA = new SMP(R.drawable.ipa,"Ilmu Pengetahuan Alam","Paket SMP (7-9) Reguler 1 Tahun Ajaran + BONUS +\n\n+Ribuan video pembelajaran & animasi menarik+\n+Latihan soal & video pembahasan+\n\n+[Bonus] Tanya Tutor+\n+[Bonus] Live Class+\n+[Bonus] Tryout Ujian Nasional");

    public static SMP Matematika = new SMP(R.drawable.math,"Matematika","Paket SMP (7-9) Reguler 1 Tahun Ajaran + BONUS +\n\n+Ribuan video pembelajaran & animasi menarik+\n+Latihan soal & video pembahasan+\n\n+[Bonus] Tanya Tutor+\n+[Bonus] Live Class+\n+[Bonus] Tryout Ujian Nasional");

    public static SMP Bahasa_Indonesia = new SMP(R.drawable.bahasa,"Bahasa Indonesia & Inggris","Paket SMP (7-9) Reguler 1 Tahun Ajaran + BONUS +\n\n+Ribuan video pembelajaran & animasi menarik+\n+Latihan soal & video pembahasan+\n\n+[Bonus] Tanya Tutor+\n+[Bonus] Live Class+\n+[Bonus] Tryout Ujian Nasional");
}
