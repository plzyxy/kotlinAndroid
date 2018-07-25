package fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.example.pengzhixian.demo.R
import network.NetManager
import network.bean.ShopHotBean2
import okhttp3.Call
import org.json.JSONException
import java.util.ArrayList

@SuppressLint("ValidFragment")
/**
 * Created by pengzhixian on 2018/7/18.
 */
class MainHomeFragment(var title:String) : Fragment() {
    internal var listShopApapter: MainHomeFragment.ListShopApapter? = null

lateinit var recycleview:RecyclerView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

         val view = inflater?.inflate(R.layout.fragment_home_main,null)
              recycleview = view!!.findViewById(R.id.recycle_view)
            recycleview.layoutManager=LinearLayoutManager(context)
        var list = ArrayList<ShopHotBean2.DataBean.HotVendorBean.ListBean> ()
        listShopApapter=ListShopApapter(context,list)
        if(listShopApapter!=null){
            recycleview.adapter=listShopApapter

        }

//            R.id.recycle_view






         return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        NetManager().getHotShop(
//                10, //网络请求 5条数据 num表示网络请求返回的数据数量
                {
                    if(listShopApapter!=null){
                        listShopApapter!!.setData(it.data.hot_vendor[0].list)
                    }

                    print(it.data.hot_vendor) }, //成功的回掉接口
                {
//                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                } //失败的回掉接口
        )

    }

//    class ListAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){
//        override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        }
//
//        override fun getItemCount(): Int {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        }
//
//        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        }
//
//    }


    internal inner class ListShopApapter(var mContext: Context, list: List<ShopHotBean2.DataBean.HotVendorBean.ListBean>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        var list: List<ShopHotBean2.DataBean.HotVendorBean.ListBean> = ArrayList()

        init {
            this.list = list
            this.mContext=mContext

        }
        fun setData(list: List<ShopHotBean2.DataBean.HotVendorBean.ListBean>){
            this.list = list
            notifyDataSetChanged()

        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
            if (viewType == 111) {
                val view = LayoutInflater.from(mContext).inflate(R.layout.main_fragment_recycle_item, parent, false)
                return HeadViewHolder(view)

            } else if (viewType == 222) {
                val view = LayoutInflater.from(mContext).inflate(R.layout.main_fragment_recycle_item, parent, false)
                return HeadViewHolder(view)
            }


            return null
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            if (holder is HeadViewHolder) {


                holder.txt_view.text = list[position].gname
                Glide.with(context).load(list[position].gimg).into(holder.img_view);

            }


        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun getItemViewType(position: Int): Int {
            //                        return super.getItemViewType(position);
            return if (position / 2 == 0) {
                111
            } else {
                222
            }


        }

        inner class HeadViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            internal var img_view: ImageView
            internal var txt_view: TextView


            init {
                img_view = itemView.findViewById(R.id.img_view)
                txt_view = itemView.findViewById(R.id.txt_view)


            }
        }

    }





}