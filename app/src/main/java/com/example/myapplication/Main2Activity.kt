package com.example.myapplication

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import com.example.myapplication.adapter.MyRecyclcerAdapter
import com.example.myapplication.vo.Coming
import com.example.myapplication.vo.Demo
import com.example.myapplication.vo.NameBean
import com.google.gson.Gson
import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.StringCallback
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    /**
     * 联网请求所需的url
     */
    var url =
        "http://api.meituan.com/mmdb/movie/v2/list/rt/order/coming.json?ci=1&limit=12&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=xiaomi&utm_medium=android&utm_term=6.8.0&utm_content=868030022327462&net=255&dModel=MI%205&uuid=0894DE03C76F6045D55977B6D4E32B7F3C6AAB02F9CEA042987B380EC5687C43&lat=40.100673&lng=116.378619&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463704714271&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=1a0b4a9b-44ec-42fc-b110-ead68bcc2824&__skcy=sXcDKbGi20CGXQPPZvhCU3%2FkzdE%3D"
    var mData: Demo? = null
    var mAdapter: MyRecyclcerAdapter? = null
    var coming: MutableList<Coming>? = null
    var mTitleBean: MutableList<NameBean>? = null
    var mHandler: Handler = Handler {
        if (it.what == 2) {
            mData = it.obj as Demo
            coming = mData!!.data.coming
        }
        addListView(coming);
        initAdapter()
        if (mAdapter != null)
            mAdapter!!.notifyDataSetChanged()
        Toast.makeText(mContext, "请求成功", Toast.LENGTH_SHORT).show()
        false
    }
    var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initView()

        getDataFromnet()

    }

    fun initAdapter() {

        if (mData == null) {
            coming = mutableListOf()
        } else {
            coming = mData!!.data.coming
        }

        mAdapter = MyRecyclcerAdapter(mContext!!, coming!!)
        val gridlayoutmanager = GridLayoutManager(mContext, 1)
        gridlayoutmanager.orientation = GridLayoutManager.VERTICAL
        rv_content.layoutManager = gridlayoutmanager
        rv_content.adapter = mAdapter
         rv_content.addItemDecoration(object :SectionDecoration(mTitleBean,mContext,object :SectionDecoration.DecorationCallback{
             override fun getGroupId(position: Int): String {
                 if(mTitleBean!!.get(position).name!=null) {
                     return mTitleBean!!.get(position).name;
                 }
                 return "-1";
             }

             override fun getGroupFirstLine(position: Int): String {
                 if(mTitleBean!!.get(position).name!=null) {
                     return mTitleBean!!.get(position).name
                 }
                 return "";
             }

         }){

         })


    }
    fun addListView(coming: MutableList<Coming>?){
        mTitleBean= mutableListOf()
        for(item  in 0 until coming!!.size){
            val title = coming[item].comingTitle
            var bundle=NameBean()
            bundle.name=title
            mTitleBean!!.add(bundle)
        }
    }

    fun initView() {
        mContext = this
    }

    fun getDataFromnet() {
        OkGo.get<String>(url)
            .execute(object : StringCallback() {
                override fun onSuccess(response: Response<String>?) {
                    val toString = response!!.body().toString()
                    val gson = Gson().fromJson<Demo>(toString, Demo::class.java)
                    var message = Message()
                    message.what = 2
                    message.obj = gson
                    mHandler.sendMessage(message)
                }

                override fun onError(response: Response<String>?) {
                    super.onError(response)
                    Toast.makeText(mContext, "请求失败", Toast.LENGTH_SHORT).show()
                }

            })

    }


}
