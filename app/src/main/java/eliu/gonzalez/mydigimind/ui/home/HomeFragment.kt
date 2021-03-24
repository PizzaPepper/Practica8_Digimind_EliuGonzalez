package eliu.gonzalez.mydigimind.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import eliu.gonzalez.mydigimind.R
import eliu.gonzalez.mydigimind.ui.AdapterTask
import eliu.gonzalez.mydigimind.ui.Task

class HomeFragment : Fragment() {

    private var adapter: AdapterTask? = null
    private lateinit var homeViewModel: HomeViewModel

    companion object{
        var task = ArrayList<Task>()
        var first = false
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        if(first==false){
            fillTasks()
            first=true
        }


        adapter = AdapterTask(root.context,task)

        val gridview: GridView = root.findViewById(R.id.gridview)

        gridview.adapter = adapter


        return root
    }

    fun fillTasks(){
        task.add(Task("Practice 1", arrayListOf("Tuesday"),"17:30"))
        task.add(Task("Practice 2", arrayListOf("Monday","Sunday"),"17:40"))
        task.add(Task("Practice 3", arrayListOf("Wednesday"),"14:00"))
        task.add(Task("Practice 4", arrayListOf("Saturday"),"11:00"))
        task.add(Task("Practice 5", arrayListOf("Friday"),"13:00"))
        task.add(Task("Practice 6", arrayListOf("Thursday"),"10:40"))
        task.add(Task("Practice 7", arrayListOf("Monday"),"12:00"))

    }
}