package adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.pengzhixian.demo.R
import network.bean.ShopHotBean2
import utils.UIUtils
import java.util.ArrayList

/**
 * Created by pengzhixian on 2018/7/30.
 */
class ListShopAdapter(var mContext: Context, list: List<ShopHotBean2.DataBean.HotVendorBean.ListBean>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
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
            val view = LayoutInflater.from(mContext).inflate(R.layout.layout_hot_header, parent, false)
            return HeadViewHolder(view)

        } else if (viewType == 222) {
            val view = LayoutInflater.from(mContext).inflate(R.layout.main_fragment_recycle_item, parent, false)
            return HotItemViewHolder(view)
        }


        return null
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {




        if (holder is HotItemViewHolder) {
            var num=position-1

            val lp = RecyclerView.LayoutParams(UIUtils.getScreenWidth(mContext)/2, RelativeLayout.LayoutParams.WRAP_CONTENT)
            holder.item_layut.layoutParams= ViewGroup.LayoutParams(lp)
            val lpchild = RelativeLayout.LayoutParams(UIUtils.getScreenWidth(mContext)/2-UIUtils.dp2px(mContext,36f), UIUtils.getScreenWidth(mContext)/2-UIUtils.dp2px(mContext,36f))
            holder.img_view.layoutParams=lpchild

            holder.txt_view.text = list[num].gname
            Glide.with(mContext).load(list[num].gimg).into(holder.img_view);

        }


    }

    override fun getItemCount(): Int {
        return list.size+1
    }

    override fun getItemViewType(position: Int): Int {
        //                        return super.getItemViewType(position);
        return if (position  == 0) {
            111
        } else {
            222
        }


    }

    inner class HotItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var img_view: ImageView
        internal var txt_view: TextView
        internal var item_layut: RelativeLayout
        internal var item_container: RelativeLayout



        init {
            item_layut=itemView.findViewById(R.id.item_layut)
            item_container=itemView.findViewById(R.id.item_container)
            img_view = itemView.findViewById(R.id.img_view)
            txt_view = itemView.findViewById(R.id.txt_view)


        }
    }
    inner class HeadViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        internal var img_view: ImageView
//        internal var txt_view: TextView
//        internal var item_layut: RelativeLayout
//        internal var item_container: RelativeLayout



        init {
//            item_layut=itemView.findViewById(R.id.item_layut)
//            item_container=itemView.findViewById(R.id.item_container)
//            img_view = itemView.findViewById(R.id.img_view)
//            txt_view = itemView.findViewById(R.id.txt_view)


        }
    }

}


