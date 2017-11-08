package gram.com.pimo.Connector

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by root1 on 2017. 11. 7..
 */
interface Api {

    @POST("auth")
    @FormUrlEncoded
    fun signUp(@Field("id")id: String, @Field("pw")pw: String): Call<JsonObject>

    @POST("sign_up")
    @FormUrlEncoded
    fun signIn(@Field("id")id: String, @Field("pw")pw: String): Call<Void>


}