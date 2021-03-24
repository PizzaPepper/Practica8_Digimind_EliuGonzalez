package eliu.gonzalez.mydigimind.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import eliu.gonzalez.mydigimind.R

class AdapterTask:BaseAdapter {
    var task = ArrayList<Task>()
    var context: Context? = null

    constructor(context: Context,task: ArrayList<Task>){
        this.context=context
        this.task=task
    }

    override fun getCount(): Int {
        return task.size
    }

    override fun getItem(position: Int): Any {
        return task[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var task= task[position]
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.task_view,null)

        var tv_tilte: TextView = view.findViewById(R.id.tv_title)
        var tv_time: TextView = view.findViewById(R.id.tv_time)
        var tv_days: TextView = view.findViewById(R.id.tv_days)

        tv_tilte.setText(task.title)
        tv_time.setText(task.time)
        tv_days.setText(task.days.toString())

        return view
    }
}