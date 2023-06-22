package com.si6a.i_laundry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.si6a.i_laundry.databinding.ActivityDetailUnggahBinding;

public class DetailUnggahActivity extends AppCompatActivity {
    private ActivityDetailUnggahBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailUnggahBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Unggah unggah = getIntent().getParcelableExtra("EXTRA_DATA");
        String nama = unggah.getNama();
        String nomor_hp = unggah.getNomor_hp();
        String jenis_barang = unggah.getJenis_barang();
        String jumlah_barang = unggah.getJumlah_barang();
        String harga = unggah.getHarga();

        binding.tvName.setText("Nama : " + nama);
        binding.tvPhone.setText("Nomor HP : " + nomor_hp);
        binding.tvBarang.setText("Jenis Barang : " + jenis_barang);
        binding.tvJumlah.setText("Jumlah Barang : " + jumlah_barang);
        binding.tvHarga.setText("Harga : " + harga);

    }
}