package com.gxd.component.retrofit;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

public interface BaseApis {

    @GET
    Observable<ResponseBody> get(@Url String url);

    @DELETE
    Observable<ResponseBody> delete(@Url String url);

    @POST
    Observable<ResponseBody> post(@Url String url, @QueryMap Map<String, String> map);

    @PUT
    Observable<ResponseBody> put(@Url String url, @QueryMap Map<String, String> map);

    @POST
    Observable<ResponseBody> postFile(@Url String url, @Body MultipartBody multipartBody);


    @POST
    Observable<ResponseBody> postMoreFile(@Url String url, @Body MultipartBody multipartBody);

    @Multipart
    @POST
    Observable<ResponseBody> postMoreImage(@Url String url, @QueryMap Map<String, String> map, @Part MultipartBody.Part[] parts);

}
