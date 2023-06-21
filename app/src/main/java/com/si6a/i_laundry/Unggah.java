package com.si6a.i_laundry;

import android.os.Parcel;
import android.os.Parcelable;

public class Unggah implements Parcelable {
    private String id;
    private String nama;
    private String nomor_hp;
    private String jenis_barang;
    private String jumlah_barang;
    private String harga;
    private String user_id;
    private String created_date;
    private String modified_date;
    private String username;

    protected Unggah(Parcel in) {
        id = in.readString();
        nama = in.readString();
        nomor_hp = in.readString();
        jenis_barang = in.readString();
        jumlah_barang = in.readString();
        harga = in.readString();
        user_id = in.readString();
        created_date = in.readString();
        modified_date = in.readString();
        username = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nama);
        dest.writeString(nomor_hp);
        dest.writeString(jenis_barang);
        dest.writeString(jumlah_barang);
        dest.writeString(harga);
        dest.writeString(user_id);
        dest.writeString(created_date);
        dest.writeString(modified_date);
        dest.writeString(username);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Unggah> CREATOR = new Creator<Unggah>() {
        @Override
        public Unggah createFromParcel(Parcel in) {
            return new Unggah(in);
        }

        @Override
        public Unggah[] newArray(int size) {
            return new Unggah[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomor_hp() {
        return nomor_hp;
    }

    public void setNomor_hp(String nomor_hp) {
        this.nomor_hp = nomor_hp;
    }

    public String getJenis_barang() {
        return jenis_barang;
    }

    public void setJenis_barang(String jenis_barang) {
        this.jenis_barang = jenis_barang;
    }

    public String getJumlah_barang() {
        return jumlah_barang;
    }

    public void setJumlah_barang(String jumlah_barang) {
        this.jumlah_barang = jumlah_barang;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getModified_date() {
        return modified_date;
    }

    public void setModified_date(String modified_date) {
        this.modified_date = modified_date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
