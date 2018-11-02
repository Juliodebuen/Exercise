package com.example.juliodebuen.excercise

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.DialogInterface
import android.graphics.Color
import android.support.v7.app.AlertDialog
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.juliodebuen.excercise.model.Exercise
import kotlinx.android.synthetic.main.activity_exercises.*
import kotlinx.android.synthetic.main.dialog.view.*
import java.util.*


class ExercisesActivity : AppCompatActivity() {
    var rutina: ArrayList<Exercise>? = null
    var adapter: RoutineAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercises)

        btnAdd.setOnClickListener {
            showAlertDialog()
        }

        sDia.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, resources.getStringArray(R.array.dias).toList())

    }

    fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val view = inflater.inflate(R.layout.dialog, null)

        view.sSeries.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, resources.getStringArray(R.array.series).toList())
        view.sWeight.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, resources.getStringArray(R.array.peso).toList())
        // de.eName = view.findViewById(R.id.eName)
        //de.sSeries = view.findViewById(R.id.sSeries)
        //de.eReps = view.findViewById(R.id.eReps)
        //de.eWeight = view.findViewById(R.id.eWeight)
        //de.sSeries?.adapter = loadAdapter(resources.getStringArray(R.array.series)/*Arrays.asList(resources.getStringArray(R.array.series))*/)
        //de.sSeries!!.setSelection(de.sSeries!!.count)
       // de.sWeight = view.findViewById(R.id.sWeight)
      /*  val weightAdapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_dropdown_item,
            Arrays.asList(resources.getStringArray(R.array.peso))
        )*/
//        de.sWeight!!.adapter = weightAdapter

        builder.setView(view)
        builder.setPositiveButton(getString(R.string.aceptar)) { dialog, which ->
  /*          val excercise = Exercise(
                null,
                de.eName!!.text.toString(),
               // de.sSeries!!.selectedItem.toString(),
                //de.eReps!!.text.toString(),
                //de.eWeight!!.text.toString() + de.sWeight!!.selectedItem, 1
                "descripcion",
                null
            )
            rutina?.add(excercise)
            adapter?.notifyDataSetChanged()*/
        }
        builder.setNegativeButton(getString(R.string.cancelar), null)
        builder.show()
        //val alertDialog = builder.create()
        //alertDialog.show()
    }

    private fun loadAdapter(list: List<String>): ArrayAdapter<String> {
        return object : ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list) {

            override fun getView(position: Int, convertView: View, parent: ViewGroup): View {

                val v = super.getView(position, convertView, parent)
                if (position == count) {
                    (v.findViewById(android.R.id.text1) as TextView).gravity = Gravity.CENTER_VERTICAL
                    (v.findViewById(android.R.id.text1) as TextView).text = getItem(position)
                    (v.findViewById(android.R.id.text1) as TextView).setTextColor(Color.BLACK)
                }
                return v
            }

            override fun getCount(): Int {
                return super.getCount() - 1 // you dont display last item. It is used as hint.
            }
        }
    }
}
