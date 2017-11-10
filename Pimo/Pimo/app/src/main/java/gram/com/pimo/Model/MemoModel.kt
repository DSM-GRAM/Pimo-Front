package gram.com.pimo.Model

import com.google.gson.annotations.SerializedName

/**
 * Created by root1 on 2017. 11. 10..
 */

data class MemoModel(@SerializedName("longitute")var longi: String,
                     @SerializedName("latitude")var lati: String,
                     @SerializedName("title")var title: String,
                     @SerializedName("content")var content: String,
                     @SerializedName("_id")var id: String)