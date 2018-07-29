package arunapps.com.shoocal

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Apiservice {

    @POST("/democalltesting")
    @FormUrlEncoded
    fun savePost(@Field("first_name") first_name: String,
                 @Field("last_name") last_name: String,
                 @Field("phone") phone: String,
                 @Field("address") address: String,
                 @Field("restau_name") restau_name: String,
                 @Field("requestby") requestby: Int?
    ): Call<Postdata>
}