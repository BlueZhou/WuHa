package com.pisces.android.framworkerlibrary.net;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jam on 2017/2/17 下午5:31.
 * Describe:
 */

public class ApiModel<T> {

//    private T

//    {
//        "ServiceProvider":Array[1],
//            "ErrorCode":0,
//            "Message":"SUCCESS",
//            "DebugMessage":"NONE",
//            "CurrentPageIndex":1,
//            "NumberOfTitlesFound":4,
//            "NumberOfResultsPerPage":1,
//            "TotalNumberOfPages":4
//    }

    public T datas;
    public int errorCode = 0;
    public String message = "SUCCESS";
    public String debugMessage = "NONE";


}
