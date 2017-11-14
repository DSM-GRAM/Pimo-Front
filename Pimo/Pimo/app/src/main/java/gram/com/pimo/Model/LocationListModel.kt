package gram.com.pimo.Model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by root1 on 2017. 11. 14..
 */
class LocationListModel: Serializable{

    @SerializedName("name")
    var name = ""

    @SerializedName("longitute")
    var longi : Double = 0.0

    @SerializedName("latitude")
    var lati : Double = 0.0

    @SerializedName("address")
    var address = ""

}