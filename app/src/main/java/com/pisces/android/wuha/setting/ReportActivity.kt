package com.pisces.android.wuha.setting

import android.os.Bundle

import com.pisces.android.framworkerlibrary.core.JBaseActivity
import com.pisces.android.wuha.R

/**
 * Created by Chris Li on 2017/9/1.
 * 举报投诉界面
 */

class ReportActivity : JBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
        setToolbarTitle("举报投诉")
    }
}
