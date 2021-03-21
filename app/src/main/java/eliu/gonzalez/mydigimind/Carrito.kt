package eliu.gonzalez.mydigimind

import java.io.Serializable

class Carrito: Serializable {
    var recordatorio: ArrayList<Recordatorio> = ArrayList<Recordatorio>()

    constructor(){
        recordatorio=ArrayList<Recordatorio>()
    }

    fun getlist():ArrayList<Recordatorio> = this.recordatorio

    fun setlist(list: ArrayList<Recordatorio>): Unit {
      this.recordatorio=list
    }

    fun agregar(p: Recordatorio): Boolean = recordatorio.add(p)

}