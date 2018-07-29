package arunapps.com.shoocal

object Api {

    val BASE_URL = "http://api.shoocal.com/test/manager/"

    val apiService: Apiservice
        get() = Client.getClient(BASE_URL).create(Apiservice::class.java)
}