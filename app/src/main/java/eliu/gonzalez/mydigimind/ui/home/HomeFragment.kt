package eliu.gonzalez.mydigimind.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import eliu.gonzalez.mydigimind.AdapterRecordatorio
import eliu.gonzalez.mydigimind.Carrito
import eliu.gonzalez.mydigimind.R
import eliu.gonzalez.mydigimind.Recordatorio
import eliu.gonzalez.mydigimind.ui.dashboard.DashboardFragment
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    var carrito: Carrito=Carrito()
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        var bundle: Bundle? = arguments

        if(bundle!=null){
            carrito = bundle?.getSerializable("list") as Carrito
            Toast.makeText(this.context,carrito.toString(),Toast.LENGTH_SHORT).show()
        }
        var adapter: AdapterRecordatorio= AdapterRecordatorio(root.context,carrito)
        root.lista.adapter= adapter

        return root
    }
}