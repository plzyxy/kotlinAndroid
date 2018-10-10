package app

import android.app.Application
import android.content.Context
import android.os.Handler
import android.os.Message

/**
 * Created by pengzhixian on 2018/7/30.
 */
class DemoApp:Application(){

    companion object {
        private var mHandler: Handler? = null

        private var application: DemoApp? = null
        private var mcontext: Context? = null
        var angle: Float = 0.toFloat()
            fun instance()= application!!

        fun getContext()= mcontext!!
        fun getHandler(): Handler? {
            if (mHandler == null) {
                synchronized(DemoApp::class.java) {
                    if (mHandler == null) {
                        mHandler = Handler(Handler.Callback { msg ->
                            when (msg.what) {
                                0 -> this.angle = msg.obj as Float
                            }
                            false
                        })
                    }
                }
            }
            return this!!.mHandler
        }
    }




    override fun onCreate() {
        super.onCreate()
        application = this
        mcontext = applicationContext
    }









}