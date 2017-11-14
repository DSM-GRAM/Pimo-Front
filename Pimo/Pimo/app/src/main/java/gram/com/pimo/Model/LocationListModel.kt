package gram.com.pimo.Model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by root1 on 2017. 11. 14..
 */
class LocationListModel: Serializable{

    @SerializedName("name")
    var name = ""

    @SerializedName("logitute")
    var longi = ""

    @SerializedName("latitude")
    var lati = ""

}