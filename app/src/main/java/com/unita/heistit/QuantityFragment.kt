package com.unita.heistit

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.unita.heistit.adapters.get_items_adapter
import com.unita.heistit.models.get_items
import kotlinx.android.synthetic.main.activity_items.*
import kotlin.math.E


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuantityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuantityFragment : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_quantity, container, false)
        var et_quantity= v.findViewById<EditText>(R.id.et_quantity)
        var btn_quantity=v.findViewById<Button>(R.id.btn_qty)
        btn_quantity.setOnClickListener()
        {
            var url:String="http://192.168.100.201/HeistIt/add_temp_order.php?id_item="+UserSession.get_items_id+"&mobile="+UserSession.mobile+"&quantity="+et_quantity.text.toString()
            var rq: RequestQueue = Volley.newRequestQueue(activity)
            var sr = StringRequest(Request.Method.GET , url , {
                response ->

                var i = Intent(activity, OrderActivity::class.java)
                startActivity(i)


            },
                {
                    error ->
                    Toast.makeText(activity, error.message, Toast.LENGTH_LONG).show()
                }
            )
            rq.add(sr)



        }

        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuantityFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuantityFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}