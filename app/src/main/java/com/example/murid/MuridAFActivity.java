package com.example.murid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MuridAFActivity extends AppCompatActivity {
    private TextView Nama,Alamat,Nama2,Alamat2,Nama3,Alamat3;
    private ApiInterface apiInterface;
    private List<Murid>murids;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_murid_af);

        Nama=(TextView)findViewById(R.id.Nama);
        Alamat=(TextView)findViewById(R.id.Alamat);
        Nama2=(TextView)findViewById(R.id.Nama2);
        Alamat2=(TextView)findViewById(R.id.Alamat2);
        Nama3=(TextView)findViewById(R.id.Nama3);
        Alamat3=(TextView)findViewById(R.id.Alamat3);

        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call <List<Murid>>call = apiInterface.getMurid();
        call.enqueue(new Callback<List<Murid>>() {
            @Override
            public void onResponse(Call<List<Murid>> call, Response<List<Murid>> response) {
                murids=response.body();
                Nama.setText(murids.get(0).getNama());
                Alamat.setText(murids.get(0).getAlamat());
                Nama2.setText(murids.get(1).getNama());
                Alamat2.setText(murids.get(1).getAlamat());
                Nama3.setText(murids.get(2).getNama());
                Alamat3.setText(murids.get(2).getAlamat());

            }

            @Override
            public void onFailure(Call<List<Murid>> call, Throwable t) {

            }
        });

    }
}
