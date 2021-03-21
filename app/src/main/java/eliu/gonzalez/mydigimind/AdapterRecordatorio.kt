package eliu.gonzalez.mydigimind

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.recordatorio.view.*

class AdapterRecordatorio: BaseAdapter {
    var carrito: Carrito = Carrito()
    var context: Context? = null

    constructor(context: Context, carrito: Carrito){
        this.context=context
        this.carrito=carrito
    }

    override fun getCount(): Int {
        return this.carrito.getlist().size
    }

    override fun getItem(position: Int): Any {
        return this.carrito.getlist()[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var recordatorio = carrito.getlist()[position]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista = inflator.inflate(R.layout.recordatorio,null)
        vista.txtNombreRecordatorio.setText(recordatorio.nombre)
        vista.txtDiasRecordatorio.setText(recordatorio.dias)
        vista.txtTiempoRecordatorio.setText(recordatorio.tiempo)
        return vista
    }
}