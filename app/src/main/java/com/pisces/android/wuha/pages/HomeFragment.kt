package com.pisces.android.wuha.pages

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pisces.android.framworkerlibrary.core.JBaseFragment
import com.pisces.android.framworkerlibrary.widget.adapter.TabAdapter
import com.pisces.android.wuha.PlaceHolderFragment
import com.pisces.android.wuha.R
import kotlinx.android.synthetic.main.home_frag.*

/**
 * Created by Jam on 2017/8/24.
 */
class HomeFragment:JBaseFragment() {


    private val tabs by lazy { arrayListOf("医疗", "服务") }

    private val fragments by lazy { tabs.mapTo(ArrayList<JBaseFragment>()) { PlaceHolderFragment.newInstance(it) } }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.home_frag,container,false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vp_home.run { adapter = TabAdapter(childFragmentManager,fragments,tabs) }
        tab_home.run {
            setupWithViewPager(vp_home)
        }
    }
}