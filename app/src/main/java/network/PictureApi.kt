package network

import network.bean.ImageBean
import retrofit2.Call

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by pengzhixian on 2018/7/19.
 */
interface PictureApi {
    @POST("197-1")
    @FormUrlEncoded
    fun getPicture(@Field("showapi_appid") showapi_appid: String,
                   @Field("showapi_sign") showapi_sign: String,
                   @Field("num") num: Int) : Call<ImageBean>



    
}