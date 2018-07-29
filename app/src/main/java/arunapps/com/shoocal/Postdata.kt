package arunapps.com.shoocal

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Postdata {

    @SerializedName("first_name")
    @Expose
    var first_name: String? = null
    @SerializedName("last_name")
    @Expose
    var last_name: String? = null
    @SerializedName("phone")
    @Expose
    var phone: String? = null
    @SerializedName("address")
    @Expose
    var address: String? = null
    @SerializedName("restau_name")
    @Expose
    var restau_name: String? = null
    @SerializedName("requestby")
    @Expose
    var requestby: Int? = null
}
