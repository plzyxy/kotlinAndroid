package network

import network.bean.ImageBean
import network.bean.ShopHotBean2
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by pengzhixian on 2018/7/19.
 */
interface ShopHotApi {
//https://api.teayork.com/goods/hot

        @POST("goods/hot")
        fun getHotShop() : Call<ShopHotBean2>



}