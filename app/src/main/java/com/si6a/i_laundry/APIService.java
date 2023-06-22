package com.si6a.i_laundry;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {
    @FormUrlEncoded
    @POST("auth/login")
    Call<ValueData<User>> login(@Field("username") String username,
                                @Field("password") String password);

    @FormUrlEncoded
    @POST("auth/register")
    Call<ValueData<User>> register(@Field("username") String username,
                                   @Field("password") String password);

    @GET("post")
    Call<ValueData<List<Unggah>>> getUnggah();

    @FormUrlEncoded
    @POST("post")
    Call<ValueNoData> addUnggah(@Field("nama") String nama,
                                @Field("nomor_hp") String nomor_hp,
                                @Field("jenis_barang") String jenis_barang,
                                @Field("jumlah_barang") String jumlah_barang,
                                @Field("harga") String harga,
                                @Field("user_id") String userId);

    @FormUrlEncoded
    @PUT("post")
    Call<ValueNoData> updateUnggah(@Field("nama") String nama,
                                   @Field("nomor_hp") String nomor_hp,
                                   @Field("jenis_barang") String jenis_barang,
                                   @Field("jumlah_barang") String jumlah_barang,
                                   @Field("harga") String harga,
                                   @Field("user_id") String userId);

    @DELETE("post/{id}")
    Call<ValueNoData> deleteUnggah(@Path("id") String id);
}
