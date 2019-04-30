package com.example.myapplication.vo

/**
 * @Author : YFL  is Creating a porject in zhujie
 * @Package com.example.myapplication.vo
 * @Email : yufeilong92@163.com
 * @Time :2019/4/30 14:40
 * @Purpose :
 */
data class Demo(
    val `data`: Data
)

data class Data(
    val coming: MutableList<Coming>,
    val hot: MutableList<Any>,
    val movieIds: MutableList<Int>,
    val stid: String
)

data class Coming(
    val bingeWatch: Int,
    val boxInfo: String,
    val cat: String,
    val civilPubSt: Int,
    val comingTitle: String,
    val desc: String,
    val dir: String,
    val dur: Int,
    val effectShowNum: Int,
    val followst: Int,
    val fra: String,
    val frt: String,
    val globalReleased: Boolean,
    val haspromotionTag: Boolean,
    val headLineShow: Boolean,
    val headLinesVO: MutableList<Any>,
    val id: Int,
    val img: String,
    val isMark: Boolean,
    val late: Boolean,
    val localPubSt: Int,
    val mk: Double,
    val movieType: Int,
    val nm: String,
    val pn: Int,
    val preShow: Boolean,
    val proScore: Double,
    val proScoreNum: Int,
    val pubDate: Long,
    val pubDesc: String,
    val pubShowNum: Int,
    val recentShowDate: Int,
    val recentShowNum: Int,
    val rt: String,
    val sc: Double,
    val scm: String,
    val scoreLabel: String,
    val showCinemaNum: Int,
    val showInfo: String,
    val showNum: Int,
    val showst: Int,
    val snum: Int,
    val star: String,
    val ver: String,
    val videoId: Int,
    val videoName: String,
    val videourl: String,
    val vnum: Int,
    val vodPlay: Boolean,
    val weight: Double,
    val wish: Int,
    val wishst: Int,
     val title:String
)