package gram.com.pimo.Connector

import com.google.gson.JsonObject
import gram.com.pimo.Model.MemoModel
import retrofit2.http.*

import retrofit2.Call
import retrofit2.http.*

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

    @POST("add_memo")
    @FormUrlEncoded
    fun addMemo(@Field("title")title: String, @Field("content")content: String, @Field("latitude")latitude: String, @Field("longitute")longitute: String): Call<JsonObject>

    @DELETE("delete_memo")
    fun deleteMemo(@Query("_id")id: String): Call<Void>

    @GET("load_memo")
    fun loadMemo(): Call<Array<MemoModel>>

    @POST("update_memo")
    fun updateMemo(): Call<MemoModel>


}