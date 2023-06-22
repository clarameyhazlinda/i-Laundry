package com.si6a.i_laundry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.si6a.i_laundry.databinding.ActivityUpdateUnggahBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateUnggahActivity extends AppCompatActivity {
    private ActivityUpdateUnggahBinding binding;
    private com.si6a.i_laundry.Unggah unggah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUpdateUnggahBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        unggah = getIntent().getParcelableExtra("EXTRA_DATA");
        String id = unggah.getId();

        binding.etName.setText(unggah.getNama());
        binding.etPhone.setText(unggah.getNomor_hp());
        binding.etBarang.setText(unggah.getJenis_barang());
        binding.etJumlah.setText(unggah.getJumlah_barang());
        binding.etHarga.setText(unggah.getHarga());
        binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = binding.etName.getText().toString();
                String nomor_hp = binding.etPhone.getText().toString();
                String jenis_barang = binding.etBarang.getText().toString();
                String jumlah_barang = binding.etJumlah.getText().toString();
                String harga = binding.etHarga.getText().toString();


                boolean bolehUpdate = true;

                if (TextUtils.isEmpty(nama)) {
                    bolehUpdate = false;
                    binding.etName.setError("Konten tidak boleh kosong");
                }

                if (bolehUpdate) {
                    updateUnggah(nama, nomor_hp, jenis_barang, jumlah_barang, harga, id);
                }
            }
        });
    }

    private void updateUnggah(String nama, String nomor_hp, String jenis_barang, String jumlah_barang, String harga, String Id) {
        binding.progressBar.setVisibility(View.VISIBLE);
        APIService api = Utilities.getRetrofit().create(APIService.class);
        Call<ValueNoData> call = api.updateUnggah(nama, nomor_hp, jenis_barang, jumlah_barang, harga, Id);
        call.enqueue(new Callback<ValueNoData>() {
            @Override
            public void onResponse(Call<ValueNoData> call, Response<ValueNoData> response) {
                binding.progressBar.setVisibility(View.GONE);
                if (response.code() == 200) {
                    int success = response.body().getSuccess();
                    String message = response.body().getMessage();

                    if (success == 1) {
                        Toast.makeText(UpdateUnggahActivity.this, message, Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(UpdateUnggahActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(UpdateUnggahActivity.this, "Response " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ValueNoData> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                System.out.println("Retrofit Error : " + t.getMessage());
                Toast.makeText(UpdateUnggahActivity.this, "Retrofit Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}