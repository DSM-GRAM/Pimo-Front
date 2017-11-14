package gram.com.pimo.Connector

import com.google.gson.JsonObject
import gram.com.pimo.Model.LocationListModel
import gram.com.pimo.Model.MemoModel
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by root1 on 2017. 11. 7..
 */
interface Api {

    @POST("auth")
    @FormUrlEncoded
    fun signIn(@Field("id")id: String, @Field("pw")pw: String): Call<JsonObject>

    @POST("sign_up")
    @FormUrlEncoded
    fun signUp(@Field("id")id: String, @Field("pw")pw: String): Call<Void>

    @POST("add_memo")
    @FormUrlEncoded
    fun addMemo(@Header("Authorization")token: String, @Field("title")title: String, @Field("content")content: String, @Field("latitude")latitude: Double, @Field("longitute")longitute: Double): Call<MemoModel>

    @DELETE("delete_memo")
    fun deleteMemo(@Header("Authorization")token: String, @Query("_id")id: String): Call<Void>

    @GET("load_memo")
    fun loadMemo(@Header("Authorization")token: String): Call<Array<MemoModel>>

    @POST("update_memo")
    fun updateMemo(@Header("Authorization")token: String, @Field("_id")id: String, @Field("title")title: String, @Field("content")content: String, @Field("latitude")latitude: Double, @Field("longitute")longitute: Double): Call<MemoModel>

    @GET("search_location")
    fun searchLocation(@Query("search")key: String): Call<Array<LocationListModel>>


}