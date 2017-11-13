package gram.com.pimo.Model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable

/**
 * Created by root1 on 2017. 11. 10..
 */

class MemoModel: Serializable, RealmObject(){

    @SerializedName("longitute")
    var longi: String = ""

    @SerializedName("latitude")
    var lati: String = ""

    @SerializedName("title")
    var title: String = ""

    @SerializedName("content")
    var content: String = ""

    @PrimaryKey
    @SerializedName("_id")
    var id: String = ""

    @SerializedName("address")
    val address: String = ""

}