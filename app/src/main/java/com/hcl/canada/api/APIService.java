package com.hcl.canada.api;

import com.hcl.canada.models.AboutResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("s/2iodh4vg0eortkl/facts.json")
    Call<AboutResponse> getAboutContent();
}
