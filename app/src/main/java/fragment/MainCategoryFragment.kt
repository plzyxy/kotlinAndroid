package fragment

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.pengzhixian.demo.R
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import utils.CommonUtil

/**
 * Created by pengzhixian on 2018/8/10.
 */
class  MainCategoryFragment : Fragment(){

    var imageView: ImageView? = null
    @SuppressLint("WrongViewCast")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

//        CommonUtil.choosePhoto(context as Activity?,1)
        val view = inflater?.inflate(R.layout.fragment_home_category,null)
       var txt = view.findViewById<Button>(R.id.txt_title)
        txt.setOnClickListener(View.OnClickListener {
//            CommonUtil.choosePhoto(context as Activity?,1)
            this.startActivity(Intent(context, com.example.pengzhixian.demo.PicToAcsllActivity::class.java))

        })
         imageView = view.findViewById<ImageView>(R.id.img_view)

        return view
    }




}