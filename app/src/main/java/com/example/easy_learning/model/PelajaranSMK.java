package com.example.easy_learning.model;


import com.example.easy_learning.R;

import java.util.ArrayList;

public class PelajaranSMK {
    public ArrayList<SMK> listsmk;
    public PelajaranSMK() {
        listsmk=new ArrayList<>();
        listsmk.add(IPA);
        listsmk.add(Matematika);
        listsmk.add(Bahasa_Indonesia);
    }

    public static SMK IPA = new SMK(R.drawable.ipa,"Ilmu Pengetahuan Alam","Paket SMK (10-12) Reguler 1 Tahun Ajaran + BONUS +\n\n+Ribuan video pembelajaran & animasi menarik+\n+Latihan soal & video pembahasan+\n\n+[Bonus] Tanya Tutor+\n+[Bonus] Live Class+\n+[Bonus] Tryout Ujian Nasional");

    public static SMK Matematika = new SMK(R.drawable.math,"Matematika","Paket SMK (10-12) Reguler 1 Tahun Ajaran + BONUS +\n\n+Ribuan video pembelajaran & animasi menarik+\n+Latihan soal & video pembahasan+\n\n+[Bonus] Tanya Tutor+\n+[Bonus] Live Class+\n+[Bonus] Tryout Ujian Nasional");

    public static SMK Bahasa_Indonesia = new SMK(R.drawable.bahasa,"Bahasa Indonesia & Inggris","Paket SMK (10-12) Reguler 1 Tahun Ajaran + BONUS +\n\n+Ribuan video pembelajaran & animasi menarik+\n+Latihan soal & video pembahasan+\n\n+[Bonus] Tanya Tutor+\n+[Bonus] Live Class+\n+[Bonus] Tryout Ujian Nasional");
}
