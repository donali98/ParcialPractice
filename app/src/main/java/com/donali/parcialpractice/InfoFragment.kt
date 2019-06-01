package com.donali.parcialpractice


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val URL = "url"


class InfoFragment : Fragment() {

    lateinit var ivSprite:ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_info, container, false)
        ivSprite = view.findViewById(R.id.iv_sprite)
        Picasso.get().load(arguments!!.getString(URL)).into(ivSprite)
        return view
    }
    companion object {

        fun newInstance(param1: String) =
            InfoFragment().apply {
                arguments = Bundle().apply {
                    putString(URL, param1)
                }
            }
    }

}
