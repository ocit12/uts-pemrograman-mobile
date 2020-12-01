package com.uts.katalogsepatu;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import com.uts.katalogsepatu.sepatu.Sepatu;
import com.uts.katalogsepatu.sepatu.Sport;
import com.uts.katalogsepatu.sepatu.Kantor;
import com.uts.katalogsepatu.sepatu.Pesta;

public class DataProvider {
    private static List<Sepatu> sepatus = new ArrayList<>();

    private static List<Sport> initDataSport(Context ctx) {
        List<Sport> sports = new ArrayList<>();
        sports.add(new Sport("adiddas alphabounce ", "Rp175.000",
                "Heroes Celtic\n" +
                        "Original Made in Indonesia\n" +
                        "Material : High Quality Synthetic Suede\n" +
                        "Outsole : Rubber\n" +
                        "Ukuran : 39, 40, 41, 42, 43\n" +
                        "Warna : Hitam, Abu-abu Muda, Tan", R.drawable.adiddas_alphabounce));
        sports.add(new Sport("cevany jester", "Rp180.000",
                "Model : Cevany Jester\n" +
                        "Bahan : Kulit Suede\n" +
                        "Ukuran : 39, 40, 41, 42, 43\n" +
                        "Warna : Hitam, Coklat Tua, Tan, Navy\n" +
                        "Produk Original Indonesia", R.drawable.cevany_jester));
        sports.add(new Sport("adiddas human x supreme", "Rp160.000",
                "Adidas Human x Supreme\n" +
                        "Made in Vietnam\n" +
                        "Ukuran : 40, 41, 42, 43, 44 (Setara 39-43)\n" +
                        "Warna : Hitam, Putih, Navy, Abu-abu\n", R.drawable.adiddas_human_x_supreme));
        return sports;
    }

    private static List<Pesta> initDataPesta(Context ctx) {
        List<Pesta> pestas = new ArrayList<>();
        pestas.add(new Pesta("Heels Pesta/Selop Pengantin/KCL_300 - Hitam", "Rp500.000",
                "Bahan kulit sisik glitter lembut tebal.\n" +
                        "Tapak lapis busa empuk.\n" +
                        "Bahan sol kaca import.", R.drawable.pesta1));
        pestas.add(new Pesta("Sepatu Wanita Sepatu Pesta hak tahu sepatu gliter wanita SP182", "Rp50.000 ",
                "Bahan:gliter\n" +
                        "Tinggi:7cm\n" +
                        "Size:37-40", R.drawable.pesta2));
        pestas.add(new Pesta("sepatu pesta anak perempuan import mickey gold", "Rp84.000",
                "Ukuran Insole :\n" +
                        "size 26 =====>15,5 cm\n" +
                        "size 27 =====>16 cm\n" +
                        "size 28 =====>16,5 cm\n" +
                        "size 29 =====>17 cm\n" +
                        "size 30 =====>17,5 cm", R.drawable.pesta3));
        return pestas;
    }
    private static List<Kantor> initDataKantor(Context ctx) {
        List<Kantor> kantors = new ArrayList<>();
        kantors.add(new Kantor("Sepatu Kerja Pantofel Kantor Black Big Size 44 & 45", "Rp000.000",
                "Ukuran sepatu:\n" +
                        "\n" +
                        "Size 44\n" +
                        "\n" +
                        "Size 45 (bagi kaki yg size 46 bisa juga pakai size ini)\n", R.drawable.kantor1));
        kantors.add(new Kantor("sepatu pantofel pdh kilap tni satpam Security dinas kantor", "Rp200.000 ",
                "iBahan : Semi Kulit\n" +
                        "\n" +
                        "Warna : Hitam Mengkilap (glosy)\n" +
                        "\n" +
                        "Model :Tali variasi\n" +
                        "\n" +
                        "Size : 39 s.d 44\n" +
                        "\n" +
                        "Sol/Tapak : pvc", R.drawable.kanto2));
        kantors.add(new Kantor("Sepatu Pria Kerja Kantor Pantofel Kulit Sapi Asli Hitam", "Rp130.000",
                "Detail Produk \n" +
                        "Upper : kulit sapi berkualitas \n" +
                        "Inner : bahan ferrari\n" +
                        "Outsol : karet \n" +
                        "Insol : busa empuk + bahan ferrari\n" +
                        "Ukuran : 39-43\n" +
                        "Warna : hitam, cokelat", R.drawable.kantor3));
        return kantors;
    }

    private static void initAllHps(Context ctx) {
        sepatus.addAll(initDataKantor(ctx));
        sepatus.addAll(initDataPesta(ctx));
        sepatus.addAll(initDataSport(ctx));
    }

    public static List<Sepatu> getAllHp(Context ctx) {
        if (sepatus.size() == 0) {
            initAllHps(ctx);
        }
        return sepatus;
    }

    public static List<Sepatu> getHpsByTipe(Context ctx, String merek) {
        List<Sepatu> hpsByType = new ArrayList<>();
        if (sepatus.size() == 0) {
            initAllHps(ctx);
        }
        for (Sepatu h : sepatus) {
            if (h.getMerek().equals(merek)) {
                hpsByType.add(h);
            }
        }
        return hpsByType;
    }

}
