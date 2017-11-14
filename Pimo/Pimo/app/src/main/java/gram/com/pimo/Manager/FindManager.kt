package gram.com.pimo.Manager

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.tasks.Task

/**
 * Created by root1 on 2017. 11. 10..
 */
/* algorithmuser (lat1, lng1)
target (lat2, lng2)
114640 * (lat1 - lat2)^2 + 88000 * (lng1 - lng2)^2 <= 2500
*/
class FindManager(context: Context){

    init {
        findLoc(context)
    }

    @SuppressLint("MissingPermission")
    fun findLoc(context: Context){
        val locationClient = FusedLocationProviderClient(context)
        locationClient.lastLocation.addOnCompleteListener {
            task: Task<Location> ->
            if (task.isSuccessful){
                val lati = task.result.latitude
                val longi = task.result.longitude
            }else{

            }
        }
    }

}