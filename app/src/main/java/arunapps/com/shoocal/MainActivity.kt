package arunapps.com.shoocal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import javax.security.auth.callback.Callback
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val array = arrayOf("Owner", "Manager", "Other")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, array)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        val service:Apiservice=Api.apiService
        button.setOnClickListener {
            val fn=editText.text.toString()
            val ln=editText2.text.toString()
            val mob=editText3.text.toString()
            val address=editText4.text.toString()
            val rn=editText5.text.toString()
            val rt=spinner.selectedItem.toString()
            if(fn.isNotEmpty() && ln.isNotEmpty() && mob.isNotEmpty() && address.isNotEmpty() && rn.isNotEmpty() && rt.isNotEmpty()){
                var rti:Int
                if(rt.equals("Owner")){
                    rti=1
                }else if(rt.equals("Manager")){
                    rti=2
                }else{
                    rti=3
                }
                service.savePost(fn,ln,mob,address,rn,rti).enqueue(object :Callback<Postdata>() {
                    fun onResponse(call: Call<Postdata>, response: Response<Postdata>) {

                        if (response.isSuccessful()) {
                            Toast.makeText(applicationContext,"Success",Toast.LENGTH_LONG).show()
                        }
                    }

                    fun onFailure(call: Call<Postdata>, t: Throwable) {
                        Toast.makeText(applicationContext,"Failed to send data",Toast.LENGTH_LONG).show()
                    }
                })
            }else {
                Toast.makeText(applicationContext, "All fields are required to proceed", Toast.LENGTH_LONG).show()
            }
        }
    }

}
