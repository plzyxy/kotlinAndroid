package fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.pengzhixian.demo.R
import network.NetManager

@SuppressLint("ValidFragment")
/**
 * Created by pengzhixian on 2018/7/18.
 */
class MainHomeFragment(var title:String) : Fragment() {


     override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

         val view = inflater?.inflate(R.layout.fragment_home_main,null)
         return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}