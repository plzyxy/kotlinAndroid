package demowidget

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.support.v7.widget.RecyclerView
import android.view.View
import interfaces.OnViewPagerListener

/**
 * Created by pengzhixian on 2018/9/19.
 */
class LinLayoutManger: LinearLayoutManager, RecyclerView.OnChildAttachStateChangeListener {


    constructor(context: Context) : super(context)

    constructor(context: Context, @RecyclerView.Orientation orientation: Int,
                reverseLayout: Boolean) : super(context, orientation, reverseLayout) {
        pagerSpaner = PagerSnapHelper()
    }

    var pagerSpaner: PagerSnapHelper? = null
    var viewPagerListener: OnViewPagerListener? = null
    var diffY = 0

    override fun onAttachedToWindow(view: RecyclerView) {
        super.onAttachedToWindow(view)
        view.addOnChildAttachStateChangeListener(this)
        pagerSpaner!!.attachToRecyclerView(view)
    }


    override fun onChildViewDetachedFromWindow(view: View?) {
        val position = getPosition(view)
        if (0 < diffY) {
            viewPagerListener?.onPageRelease(true, position)
        } else {
            viewPagerListener?.onPageRelease(false, position)
        }
    }

    override fun onChildViewAttachedToWindow(view: View?) {

        val position = getPosition(view)
        if (0 == position) {
            viewPagerListener?.onPageSelected(position, false)
        }


    }

    override fun onScrollStateChanged(state: Int) {
        if (RecyclerView.SCROLL_STATE_IDLE == state) {
            val view = pagerSpaner!!.findSnapView(this)
            val position = getPosition(view)
            viewPagerListener?.onPageSelected(position, position == itemCount - 1)
        }
        super.onScrollStateChanged(state)
    }

    public fun setOnViewPagerListener(listener: OnViewPagerListener) {
        viewPagerListener = listener
    }

    override fun scrollVerticallyBy(dy: Int, recycler: RecyclerView.Recycler?, state: RecyclerView.State?): Int {
        diffY = dy
        return super.scrollVerticallyBy(dy, recycler, state)
    }

}