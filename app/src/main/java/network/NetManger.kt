package network

import android.util.Log
import network.bean.ImageBean
import network.bean.ShopHotBean2

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by pengzhixian on 2018/7/19.
 */
 open class NetManager {
    var retrofit = Retrofit.Builder()
//            .baseUrl("http://route.showapi.com/")   //基地址
            .baseUrl("https://api.teayork.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
   open fun getPicture(num: Int, success: (ImageBean) -> Unit, fail: (String) -> Unit) {
        var pictureApi: PictureApi = retrofit.create(PictureApi::class.java)
        var call: Call<ImageBean> = pictureApi.getPicture("42684", "f6527e909abc4edea350ec8b9a9db0f5", num)
        call.enqueue(object : Callback<ImageBean> {
            override fun onResponse(call: Call<ImageBean>?, response: Response<ImageBean>) {

                Log.e("test",""+response.body())
                success(response.body()!!)
            }
            override fun onFailure(call: Call<ImageBean>?, t: Throwable?) {
                Log.e("test",""+t.toString())
                fail(t.toString())
            }
        })
    }


    open fun getHotShop( success: (ShopHotBean2) -> Unit, fail: (String) -> Unit) {
        var hotShopApi: ShopHotApi = retrofit.create(ShopHotApi::class.java)
        var call: Call<ShopHotBean2> = hotShopApi.getHotShop()
        call.enqueue(object : Callback<ShopHotBean2> {
            override fun onResponse(call: Call<ShopHotBean2>?, response: Response<ShopHotBean2>) {

                Log.e("test",""+response.body())
                success(response.body()!!)
            }
            override fun onFailure(call: Call<ShopHotBean2>?, t: Throwable?) {
                Log.e("test",""+t.toString())
                fail(t.toString())
            }
        })
    }


}


