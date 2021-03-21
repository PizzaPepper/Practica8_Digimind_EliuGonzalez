package eliu.gonzalez.mydigimind.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TableRow
import android.widget.TextView
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import eliu.gonzalez.mydigimind.Carrito
import eliu.gonzalez.mydigimind.MainActivity
import eliu.gonzalez.mydigimind.R
import eliu.gonzalez.mydigimind.Recordatorio
import eliu.gonzalez.mydigimind.ui.home.HomeFragment
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import kotlinx.android.synthetic.main.recordatorio.*
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

        var listdays: ArrayList<String> = ArrayList<String>()
        var days: String = ""
        var name: String = ""
        var time: String = ""


        var btn: Button = root.btnSetTime as Button
        var ch1: CheckBox = root.row1 as CheckBox
        var ch2: CheckBox = root.row2 as CheckBox
        var ch3: CheckBox = root.row3 as CheckBox
        var ch4: CheckBox = root.row4 as CheckBox
        var ch5: CheckBox = root.row5 as CheckBox
        var ch6: CheckBox = root.row6 as CheckBox
        var ch7: CheckBox = root.row7 as CheckBox

        btn.setOnClickListener {
            if (listdays.size != 0) {
                name = root.textName.text.toString()
                time = root.textTime.text.toString()
                if (listdays.size == 7) {
                    days = "Everyday"
                } else {
                    days = listdays.toString().removePrefix("[").removeSuffix("]")
                }
                var list: Carrito = Carrito()
                list.agregar(Recordatorio(days, time, name))

                var bundle: Bundle= Bundle()
                bundle.putSerializable("list",list)
                //val navController = findNavController(R.id.nav_host_fragment)

                Navigation.findNavController(requireView()).navigate(R.id.navigation_home,bundle)

                //HomeFragment().carrito.agregar(Recordatorio(days, time, name))

            }
        }

        ch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                listdays.add("Mon")
            } else {
                listdays.remove("Mon")
            }
        }

        ch2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                listdays.add("Thu")
            } else {
                listdays.remove("Thu")
            }
        }

        ch3.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                listdays.add("Wed")
            } else {
                listdays.remove("Wed")
            }
        }

        ch4.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                listdays.add("Thu")
            } else {
                listdays.remove("Thu")
            }
        }

        ch5.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                listdays.add("Fri")
            } else {
                listdays.remove("Fri")
            }
        }

        ch6.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                listdays.add("Sat")
            } else {
                listdays.remove("Sat")
            }
        }

        ch7.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                listdays.add("Sun")
            } else {
                listdays.remove("Sun")
            }
        }

        return root
    }

}