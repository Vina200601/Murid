package com.example.murid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET ("bins/g4iq9")
    Call <List<Murid>> getMurid();
}
