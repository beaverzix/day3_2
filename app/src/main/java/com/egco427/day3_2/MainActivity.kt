package com.egco427.day3_2

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.row_main.*
import kotlinx.android.synthetic.main.row_main.view.*
import java.security.AccessControlContext
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val redColor = Color.parseColor("#FF0000")
        val listView =findViewById<ListView>(R.id.mainListView)
        //listView.setBackgroundColor(redColor)

        listView.adapter = myCustomAdapter(this)
        listView.setOnItemClickListener{adapterView,view,position,id->
            val item = adapterView.getItemAtPosition(position) as String
            Toast.makeText(this,"${item} $position",Toast.LENGTH_LONG).show()
        }
    }

    private class myCustomAdapter(context: Context):BaseAdapter(){
        private val mContext: Context
        private val names = arrayListOf<String>("Ahmed","Bobin","Sophia","Jmal","Domique","Johan","Qtie","Hitam","Ahmed","Bobin","Sophia","Jmal","Domique","Johan","Qtie","Hitam","Ahmed","Bobin","Sophia","Jmal","Domique","Johan","Qtie","Hitam","Ahmed","Bobin","Sophia","Jmal","Domique","Johan","Qtie","Hitam","Ahmed","Bobin","Sophia","Jmal","Domique","Johan","Qtie","Hitam","Ahmed","Bobin","Sophia","Jmal","Domique","Johan","Qtie","Hitam")
        init {
            mContext = context
        }

        override fun getCount(): Int {
            return names.size
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return names[position]
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            //val textView = TextView(mContext)
            val whiteColor = Color.parseColor("#FFFFFF")
            val greyColor = Color.parseColor("#E0E0E0")
            val rewMain: View
            if (convertView==null) {
                val layoutInflater = LayoutInflater.from(viewGroup!!.context)
                rewMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)
                val viewHolder = ViewHolder(rewMain.nameText,rewMain.positionText)
                rewMain.tag = viewHolder
            }
            else{
                rewMain = convertView
            }
            val viewHolder = rewMain.tag as ViewHolder
            viewHolder.nameText.text = names.get(position)
            viewHolder.positionText.text = "Row Number: $position"
            //rewMain.nameText.text = names.get(position)
            //rewMain.positionText.text = "Row Number: $position"
            if(position.rem(2)==0){
                rewMain.setBackgroundColor(whiteColor)
            }
            else{
                rewMain.setBackgroundColor(greyColor)
            }
            //textView.text = "Hello World "+position.toString()
            return rewMain
        }
        private class ViewHolder(val nameText: TextView,val positionText : TextView){}
    }
}
