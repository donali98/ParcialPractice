package com.donali.parcialpractice


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.donali.parcialpractice.helpers.ActivityHelper
import java.net.URI


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val URL = "url"


class InfoFragment : Fragment() {

    lateinit var ivSprite: ImageView
    lateinit var activityHelper: ActivityHelper
    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityHelper = context as ActivityHelper
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_info, container, false)
        ivSprite = view.findViewById(R.id.iv_sprite)
        val url = URI(arguments!!.getString(URL))
        val segments = url.path.split("/")
        val pokeId = segments[segments.size - 2].toLong()
        activityHelper.getSharedViewModel().retreivePokemonInfo(pokeId)
            //        Picasso.get().load(arguments!!.getString(URL)).into(ivSprite)

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
