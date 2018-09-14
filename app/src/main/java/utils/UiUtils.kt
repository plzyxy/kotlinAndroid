package utils

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.StateListDrawable
import android.os.Build
import android.os.Handler
import android.text.TextUtils
import android.widget.Button
import app.DemoApp
import com.example.pengzhixian.demo.R
import java.lang.reflect.Field
import android.view.WindowManager



@Suppress("DEPRECATION")
/**
 * Created by pengzhixian on 2018/7/30.
 */
class UIUtils {

//    fun setSelectorDrawable(mContext: Context, cbButton: Button) {
//
//        val drawable = StateListDrawable()
//
//        //选中
//        drawable.addState(intArrayOf(android.R.attr.state_checked), mContext.resources.getDrawable(R.drawable.popu_goodstails_radiorb_unselect))
//
//        //未选中
//        drawable.addState(intArrayOf(-android.R.attr.state_checked), mContext.resources.getDrawable(R.drawable.popu_goodsdetals_rb_select))
//
//
//        cbButton.setBackgroundDrawable(drawable)
//
//    }

    companion object {
        //获取上下文
        /**
         * 获取上下文
         * @return
         */
        val context: Context?
            get() = DemoApp.getContext()

        /**
         * 获取String类型的数据
         * @param resId
         * @return
         */
        fun getString(resId: Int): String {
            return context!!.resources.getString(resId)

        }

        /**
         * 获取占位符之类的string字符串
         * @param resId
         * @param formatArgs
         * @return
         */
        fun getString(resId: Int, vararg formatArgs: Any): String {
            return context!!.resources.getString(resId, *formatArgs)

        }

        /**
         * 获取屏幕宽高
         * @param context
         * @return
         */
        fun getScreenWidth(context: Context): Int {
            return (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.width
        }

        fun getScreenHeight(context: Context): Int {
            return (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.height
        }

        /**
         * 获取颜色
         * @param resId
         * @return
         */
        fun getColor(resId: Int): Int {
            return resources.getColor(resId)

        }

        /**
         * 获取handler
         * @return
         */
        val mainHandler: Handler
            get() = DemoApp.getHandler()!!

        /**
         * 在主线程中执行任务
         * @param task
         */
        fun post(task: Runnable) {
            mainHandler.post(task)
        }

        /**
         * 延时执行任务
         * @param task
         * @param delayMillis
         */
        fun postDelayed(task: Runnable, delayMillis: Long?) {
            mainHandler.postDelayed(task, delayMillis!!)
        }

        /**
         * 移除任务
         * @param task
         */
        fun removeCallbacks(task: Runnable) {
            mainHandler.removeCallbacks(task)
        }

        /**
         * 获得资源
         * @return
//         */
        val resources: Resources
            get() = context!!.resources

        /**
         * px转换成dp
         * @param px
         * @return
//         */
//        fun px2dp(px: Int): Int {
//            //dp = px * 160 /dpi
//            val dpi = resources.displayMetrics.densityDpi
//            return (px * 160.0 / dpi + 0.5f).toInt()
//
//        }

        /**
         * dp 转换成 px
         * @param dp
         * @return
//         */
//        fun dp2px(dp: Int): Int {
//            //px = dp * dpi /160.0
//            val dpi = resources.displayMetrics.densityDpi
//            return (dp * dpi / 160.0 + 0.5f).toInt()
//
//        }

        /**
         * sp 转换成 px
         * @param context
         * @param spValue
         * @return
         */
        fun sp2px(context: Context, spValue: Float): Int {
            val fontScale = context.resources.displayMetrics.scaledDensity
            return (spValue * fontScale + 0.5f).toInt()
        }

        /**
         * px 转换成 sp
         * @param context
         * @param pxValue
         * @return
         */
        fun px2sp(context: Context, pxValue: Float): Int {
            val fontScale = context.resources.displayMetrics.scaledDensity
            return (pxValue / fontScale + 0.5f).toInt()
        }


        /**
         * 获得包名
         *
         * @return
         */
        val packageName: String
            get() = context!!.packageName

        /**
         * 获得字符串数组
         * @param
         * @return
         */
        fun getStringArray(resId: Int): Array<String> {
            return resources.getStringArray(resId)
            // TODO Auto-generated method stub

        }


        /***
         * 获取url 指定name的value;
         * @param url
         * @param name
         * @return
         */
        fun getValueByName(url: String, name: String): String {
            var result = ""
            val index = url.indexOf("?")
            val temp = url.substring(index + 1)
            val keyValue = temp.split("&".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            for (str in keyValue) {
                if (str.contains(name)) {
                    result = str.replace(name + "=", "")
                    break
                }
            }
            return result
        }


        /**
         * 判断手机格式是否正确
         * @param mobiles
         * @return
         * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
         * 联通：130、131、132、152、155、156、185、186
         * 电信：133、153、180、189、（1349卫通）
         * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
         */
        fun isMobileNO(mobiles: String): Boolean {
            //"[1]"代表第1位为数字1，"[34578]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
            //String telRegex = "[1][34578]\\d{9}" ;
            val telRegex = "^1\\d{10}$"
            return if (TextUtils.isEmpty(mobiles))
                false
            else
                mobiles.matches(telRegex.toRegex())
        }


        /**
         * 实现文本复制功能
         *
         * @param text
         */
        fun copyText(context: Context, text: String) {
            // 得到剪贴板管理器
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
                val cmb = context
                        .getSystemService(Context.CLIPBOARD_SERVICE) as android.text.ClipboardManager
                cmb.text = text.trim { it <= ' ' }
            } else {
                val cmb = context
                        .getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
                cmb.text = text.trim { it <= ' ' }
            }
        }

        /**
         * 状态栏高度
         *
         * @param context
         * @return
         */
        fun getStatusBarHeight(context: Context): Int {
            var c: Class<*>?
            var obj: Any?
            var field: Field?
            var x: Int
            var statusBarHeight: Int
            try {
                c = Class.forName("com.android.internal.R\$dimen")
                obj = c!!.newInstance()
                field = c.getField("status_bar_height")
                x = Integer.parseInt(field!!.get(obj).toString())
                statusBarHeight = context.resources.getDimensionPixelSize(x)

            } catch (e1: Exception) {
                statusBarHeight = 0
                e1.printStackTrace()
            }

            return statusBarHeight
        }


        /**
         * dp2px
         */
        fun dp2px(context: Context, dpValue: Float): Int {
            val scale = context.resources.displayMetrics.density
            return (dpValue * scale + 0.5f).toInt()
        }
    }


}
