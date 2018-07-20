package network.bean

import com.google.gson.annotations.SerializedName

/**
 * Created by pengzhixian on 2018/7/19.
 */
data class ImageBean(
        @SerializedName("showapi_res_code") var showapiResCode: Int,
        @SerializedName("showapi_res_error") var showapiResError: String,
        @SerializedName("showapi_res_body") var showapiResBody: ShowapiResBody
)

data class ShowapiResBody(
        @SerializedName("newslist") var newslist: List<Newslist>,
        @SerializedName("code") var code: Int,
        @SerializedName("msg") var msg: String
)

data class Newslist(
        @SerializedName("title") var title: String,
        @SerializedName("picUrl") var picUrl: String,
        @SerializedName("description") var description: String,
        @SerializedName("ctime") var ctime: String,
        @SerializedName("url") var url: String
)