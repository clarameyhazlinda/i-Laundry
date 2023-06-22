package com.si6a.i_laundry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.si6a.i_laundry.databinding.ActivityInputBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InputActivity extends AppCompatActivity {
    private ActivityInputBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityInputBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = binding.etName.getText().toString();
                String nomor_hp = binding.etPhone.getText().toString();
                String jenis_barang = binding.etBarang.getText().toString();
                String jumlah_barang = binding.etJumlah.getText().toString();
                String harga = binding.etHarga.getText().toString();

                boolean bolehUnggah = true;

                if (TextUtils.isEmpty(nama)) {
                    bolehUnggah = false;
                    binding.etName.setError("Konten tidak boleh kosong!");
                }

                if (bolehUnggah) {
                    String userId = Utilities.getValue(InputActivity.this, "xUserId");
                    addUnggah(nama, nomor_hp, jenis_barang, jumlah_barang, harga, userId);
                }
            }
        });
    }

    private void addUnggah(String nama, String nomor_hp, String jenis_barang, String jumlah_barang, String harga, String userId) {
        binding.progressBar.setVisibility(View.VISIBLE);
        APIService api = Utilities.getRetrofit().create(APIService.class);
        Call<ValueNoData> call = api.addUnggah(nama, nomor_hp, jenis_barang, jumlah_barang, harga, userId);
        call.enqueue(new Callback<ValueNoData>() {
            @Override
            public void onResponse(Call<ValueNoData> call, Response<ValueNoData> response) {
                binding.progressBar.setVisibility(View.GONE);
                if (response.code() == 200) {
                    int success = response.body().getSuccess();
                    String message = response.body().getMessage();

                    if (success == 1) {
                        Toast.makeText(InputActivity.this, message, Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(InputActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(InputActivity.this, "Response " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ValueNoData> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                System.out.println("Retrofit Error : " + t.getMessage());
                Toast.makeText(InputActivity.this, "Retrofit Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
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