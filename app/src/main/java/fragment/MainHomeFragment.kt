package fragment

import adapter.ListShopAdapter
import android.annotation.SuppressLint
import android.graphics.Rect
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.recyclerview.R.attr.spanCount
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import app.DemoApp
import com.example.pengzhixian.demo.R
import network.NetManager
import network.bean.ShopHotBean2
import okio.Timeout
import java.util.ArrayList

@SuppressLint("ValidFragment")
/**
 * Created by pengzhixian on 2018/7/18.
 */
class MainHomeFragment(var title:String) : Fragment() {
    internal var listShopAdapter: ListShopAdapter? = null

lateinit var recycleview:RecyclerView
    lateinit var swiperefreshlayout:SwipeRefreshLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

         val view = inflater?.inflate(R.layout.fragment_home_main,null)
              recycleview = view!!.findViewById(R.id.recycle_view)
        swiperefreshlayout = view!!.findViewById(R.id.swiperefreshlayout)



        var listb = ArrayList<ShopHotBean2.DataBean.HotVendorBean.ListBean> ()
        listShopAdapter = ListShopAdapter(this!!.context!!,listb)
        if(listShopAdapter !=null){
            recycleview.adapter= listShopAdapter

        }

//            R.id.recycle_view

        initListenner()


        val layoutManager = GridLayoutManager(activity, 2)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {



            override fun getSpanSize(position: Int): Int {
                return if (position == 0) {
                    1
                } else if (position == listShopAdapter!!.getItemCount() - 1) {
                    2
                } else {
                    1
                }
            }
        }


//        recycleview.addItemDecoration(GridItemDecoration())
        recycleview.layoutManager= layoutManager




         return view
    }

    private fun initListenner() {
        swiperefreshlayout.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {

          var  runnable: Runnable  =  Runnable() {
                  kotlin.run {

                        swiperefreshlayout.isRefreshing=false


                  }
            }


            DemoApp.getHandler()!!.postDelayed(runnable,2000)

        })


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        NetManager().getHotShop(
//                10, //网络请求 5条数据 num表示网络请求返回的数据数量
                {
                    if(listShopAdapter !=null){
                        listShopAdapter!!.setData(it.data.hot_vendor[0].list)
                    }

                    print(it.data.hot_vendor) }, //成功的回掉接口
                {
                    Toast.makeText(DemoApp.getContext(), it.toString(), Toast.LENGTH_SHORT).show()
                } //失败的回掉接口
        )

    }

    class GridItemDecoration : RecyclerView.ItemDecoration() {

      override  fun getItemOffsets(outRect: Rect, child: View, parent: RecyclerView, state: RecyclerView.State) {
            super.getItemOffsets(outRect, child, parent, state)

            val pos = parent.getChildAdapterPosition(child)
            val column = pos % spanCount + 1// 计算这个child 处于第几列

            outRect.top = 30
            outRect.bottom = 30
            //注意这里一定要先乘 后除  先除数因为小于1然后强转int后会为0
            outRect.left =
//                    UIUtils.dp2px(DemoApp.getContext(),18f)
                    (column - 1) * 60 / spanCount //左侧为(当前条目数-1)/总条目数*divider宽度
            outRect.right =
//                    UIUtils.dp2px(DemoApp.getContext(),18f)
                    (spanCount - column) * 30 / spanCount//右侧为(总条目数-当前条目数)/总条目数*divider宽度
        }

    }


}