package com.example.pengzhixian.demo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.*
import android.widget.TextView
import android.widget.Toast
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import fragment.MainCategoryFragment
import fragment.MainHomeFragment

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tab_item.view.*
import network.NetManager
import network.PostRequest_Interface
import network.Translation1
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import utils.CommonUtil

class MainActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {
    override fun onTabReselected(tab: TabLayout.Tab?) {
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        viewpager.currentItem=tab!!.position
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTab()
        setItem()
        tab.addOnTabSelectedListener(this)
        request()



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e( "eeee"+resultCode, data.toString()+requestCode)
        if (resultCode == RESULT_OK) {
            if (requestCode == PictureConfig.CHOOSE_REQUEST) {
                Log.e("jinlaile", data.toString())
                val selectList = PictureSelector.obtainMultipleResult(data)
                Log.e("eeee", selectList.size.toString())
                var path = ""
                if (selectList != null && selectList.size > 0) {
                    val localMedia = selectList[0]
                    if (localMedia.isCompressed) {
                        path = localMedia.compressPath
                    } else if (localMedia.isCut) {
                        path = localMedia.cutPath
                    } else {
                        path = localMedia.path
                    }
                }
               var filepath = CommonUtil.amendRotatePhoto(path, this)
                Log.e("eeeepath", filepath)
                //                imageView.setImageBitmap(BitmapFactory.decodeFile(filepath));
            var   bitmap = CommonUtil.createAsciiPic(filepath, this)
//                imageView.setImageBitmap(bitmap)
            }
        }
    }

    private fun initView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.


    }


    fun setTab(){
        /**设置tab的模式*/
        tab.tabMode=TabLayout.MODE_FIXED
        /**
         * 第一种：initdata()!!
         * 第二种使用listof
         */
        val tab1:MainHomeFragment=MainHomeFragment("111111")
        val tab2:MainCategoryFragment=MainCategoryFragment()
        val tab3:Tab1Fragment=Tab1Fragment("333333")
        val tab4:Tab1Fragment=Tab1Fragment("444444")
        var lsit =listOf<Fragment>(tab1,tab2,tab3,tab4)
        viewpager.adapter=KotlinPagerAdapter(lsit,supportFragmentManager)
        //让tab和viewpager关联起来
        tab.setupWithViewPager(viewpager)
    }

    /**
     * 设置tabitem
     * */
    fun setItem() {
        tab.getTabAt(0)?.customView=getTabView(0)
        tab.getTabAt(1)?.customView=getTabView(1)
        tab.getTabAt(2)?.customView=getTabView(2)
        tab.getTabAt(3)?.customView=getTabView(3)
    }

    /**
     * fragment 添加到集合中
     *  使用listof 代替
     * */
    fun initdata() : ArrayList<Fragment> {
        val mList = ArrayList<Fragment>()
        val tab1:Tab1Fragment=Tab1Fragment("111111")
        val tab2:Tab1Fragment=Tab1Fragment("2222222")
        val tab3:Tab1Fragment=Tab1Fragment("333333")
        val tab4:Tab1Fragment=Tab1Fragment("44444")
        var lsit =listOf<Fragment>(tab1,tab2,tab3,tab4)
        mList.add(tab1)
        mList.add(tab2)
        mList.add(tab3)
        mList.add(tab4)
        return mList
    }


    fun getTabView(position: Int): View {
        val view = LayoutInflater.from(this).inflate(R.layout.tab_item, null)
        val iv_head = view.tab_item_text
        val im = view.tab_image
        /*
        *我们可以给库函数 arrayOf() 传递每一项的值来创建Array，arrayOf(1, 2, 3) 创建了一个[1, 2, 3] 这样的数组
        */
        val image = arrayOf(R.mipmap.ic_launcher,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher,R.mipmap.ic_launcher_round)
        val list=listOf<String>("Home","Cate","ShopCar","Me")
        iv_head.text=list[position]
        im.setImageResource(image[position])
        /**
         * 不建议使用这种方式 我刚开始用的是这种  用这种它显示的都是第四个字符串tab4
         * */
//        val asc = Array(4,{"tab1";"tab2";"tab3";"tab4"})
//        iv_head.text=asc[position]
        return view
    }


}

@SuppressLint("ValidFragment")
class Tab1Fragment(var name:String): Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {



       val txt =TextView(context)
        txt.setText(name)
        return txt

    }

}



class KotlinPagerAdapter(var mList : List<Fragment>, fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): android.support.v4.app.Fragment {
        return mList[position]
    }

    override fun getCount(): Int {
        return mList.size
    }

}
    fun request() {

        //步骤4:创建Retrofit对象
        val retrofit = Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build()

        // 步骤5:创建 网络请求接口 的实例
        val request = retrofit.create(PostRequest_Interface::class.java)

        //对 发送请求 进行封装(设置需要翻译的内容)
        val call = request.getCall("hello , I love you? no")

        //步骤6:发送网络请求(异步)
        call.enqueue(object : Callback<Translation1> {

            //请求成功时回调
            override fun onResponse(call: Call<Translation1>, response: Response<Translation1>) {
                // 步骤7：处理返回的数据结果：输出翻译的内容
                println(response.body().translateResult[0][0].getTgt())

            }

            //请求失败时回调
            override fun onFailure(call: Call<Translation1>, throwable: Throwable) {
                println("请求失败")
                println(throwable.message)
            }
        })


}
