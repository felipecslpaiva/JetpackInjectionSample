package gg.paiva.jetpackexploration.session

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import gg.paiva.jetpackexploration.R
import gg.paiva.jetpackexploration.databinding.FragmentFirstBinding
import gg.paiva.jetpackexploration.weather.WeatherViewModel
import gg.paiva.jetpackexploration.weather.models.Weather
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private val weatherViewModel: WeatherViewModel by viewModel()
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_first, container, false)
        binding.viewmodel = weatherViewModel
        weatherViewModel.weather.observe(this, observer)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private val observer = Observer<Weather> {
//        binding.temperature.text = "Temperature at ${it.name} is ${it.temp.temp} celcius"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}