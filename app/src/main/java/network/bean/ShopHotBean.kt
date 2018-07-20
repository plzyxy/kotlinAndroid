package network.bean

/**
 * Created by pengzhixian on 2018/7/19.
 */


data class ShopHotBean(
    val code: Int,
    val message: String,
    val data: Data
)

data class Data(
    val hot_vendor: List<HotVendor>
)

data class HotVendor(
    val customer_id: Int,
    val vendor_name: String,
    val user_type: Int,
    val bg_image: String,
    val list: List<X>
)

data class X(
    val goods_id: Int,
    val gname: String,
    val gimg: String,
    val gprice: String,
    val silver_price: String,
    val gold_price: String
//    val promotion: List<Any>
)



//data class Any(
//        val promotion_type:String
//)