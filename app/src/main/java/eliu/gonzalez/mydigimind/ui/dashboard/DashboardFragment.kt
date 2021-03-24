package eliu.gonzalez.mydigimind.ui.dashboard

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import eliu.gonzalez.mydigimind.R
import eliu.gonzalez.mydigimind.ui.Task
import eliu.gonzalez.mydigimind.ui.home.HomeFragment
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val btn_time: Button = root.findViewById(R.id.btnTime)

        btn_time.setOnClickListener {
            val cal= Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                cal.set(Calendar.HOUR_OF_DAY,hourOfDay)
                cal.set(Calendar.MINUTE,minute)
                btn_time.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(root.context,timeSetListener,cal.get(Calendar.HOUR_OF_DAY),
            cal.get(Calendar.MINUTE), true).show()

        }



       /* var listdays: ArrayList<String> = ArrayList<String>()
        var days: String = ""
        var name: String = ""
        var time: String = ""
        */



        val btn_save: Button = root.btnSetTime as Button
        val et_title: EditText = root.textName as EditText
        val chMonday: CheckBox = root.row1 as CheckBox
        val chTuesday: CheckBox = root.row2 as CheckBox
        val chWednesday: CheckBox = root.row3 as CheckBox
        val chThursday: CheckBox = root.row4 as CheckBox
        val chFriday: CheckBox = root.row5 as CheckBox
        val chSaturday: CheckBox = root.row6 as CheckBox
        val chSunday: CheckBox = root.row7 as CheckBox

        btn_save.setOnClickListener {
            var title = et_title.text.toString()
            var time = btn_time.text.toString()
            var days = ArrayList<String>()

            if(chMonday.isChecked){
                days.add("Monday")
            }
            if(chTuesday.isChecked){
                days.add("Tuesday")
            }
            if(chWednesday.isChecked){
                days.add("Wednesday")
            }
            if(chThursday.isChecked){
                days.add("Thursday")
            }
            if(chFriday.isChecked){
                days.add("Friday")
            }
            if(chSaturday.isChecked){
                days.add("Saturday")
            }
            if(chSunday.isChecked){
                days.add("Sunday")
            }

            var task = Task(title,days,time)

            HomeFragment.task.add(task)

            Toast.makeText(root.context,"New task added",Toast.LENGTH_SHORT).show()

        }

        return root
    }

}