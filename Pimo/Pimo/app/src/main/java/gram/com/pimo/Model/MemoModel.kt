package gram.com.pimo.Model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable

/**
 * Created by root1 on 2017. 11. 10..
 */

open class MemoModel: Serializable, RealmObject(){

    @SerializedName("longitute")
    var longi: Double = 0.0

    @SerializedName("latitude")
    var lati: Double = 0.0

    @SerializedName("title")
    var title: String = ""

    @SerializedName("content")
    var content: String = ""

    @PrimaryKey
    @SerializedName("_id")
    var id: String = ""

    @SerializedName("address")
    var address: String = ""

}