package com.example.pengzhixian.demo

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import kotlinx.android.synthetic.main.activity_pictoacsll.*
import kotlinx.android.synthetic.main.fragment_home_category.*
import utils.CommonUtil

/**
 * Created by pengzhixian on 2018/9/7.
 */
class PicToAcsllActivity : AppCompatActivity() {

    var filepath = ""
    var bitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pictoacsll)

//        image.setImageResource()
//        imageView = findViewById(R.id.image)
        bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)

    }

    fun doPick(view: View) {
        CommonUtil.choosePhoto(this, PictureConfig.CHOOSE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == PictureConfig.CHOOSE_REQUEST) {
                val selectList = PictureSelector.obtainMultipleResult(data)
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
                filepath = CommonUtil.amendRotatePhoto(path, this)
                Log.e("lujing", filepath)
                image_res.setImageBitmap(BitmapFactory.decodeFile(filepath));
                bitmap = CommonUtil.createAsciiPic(filepath, this)
                image.setImageBitmap(bitmap)
            }
        }
    }


}