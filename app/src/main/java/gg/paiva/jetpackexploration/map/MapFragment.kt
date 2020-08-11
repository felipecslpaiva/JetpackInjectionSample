package gg.paiva.jetpackexploration.map

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import gg.paiva.jetpackexploration.R
import gg.paiva.jetpackexploration.databinding.FragmentMapBinding
import gg.paiva.jetpackexploration.map.models.CameraModelRoot
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MapFragment : Fragment(), OnMapReadyCallback{
    private val mapViewModel: MapViewModel by viewModel()
    private lateinit var binding: FragmentMapBinding
    private lateinit var supportMapFragment: SupportMapFragment
    private lateinit var googleMap: GoogleMap
    private var isFirst: Boolean = true

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_map, container, false)
        binding.viewmodel = mapViewModel
        supportMapFragment = SupportMapFragment()
        childFragmentManager.beginTransaction()
            .replace(R.id.support_fragment, supportMapFragment)
            .commitAllowingStateLoss()
        supportMapFragment.getMapAsync(this)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private val observer = Observer<CameraModelRoot> {
        Log.d("" , it.toString())
        supportMapFragment.getMapAsync(OnMapReadyCallback { mMap ->
            googleMap = mMap
            addMarkers(googleMap, it)
        })
    }

    private fun addMarkers(googleMap: GoogleMap?, cameraModelRoot: CameraModelRoot) {
        for (camerasList in cameraModelRoot.itemsList){
            for (camera in camerasList.cameras){
                var marker = MarkerOptions()
                    .position(LatLng(camera.location.latitude, camera.location.longitude))
                    .title(camera.camera_id)
                    .snippet(camera.image)
                googleMap?.addMarker(marker)
                googleMap?.setOnMarkerClickListener {
                    marker -> showImage(marker)
                }

                if(isFirst){
                    val cameraPosition: CameraPosition = CameraPosition.Builder()
                        .target(LatLng(camera.location.latitude, camera.location.longitude))
                        .zoom(12F).build()
                    googleMap?.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
                    isFirst = false
                }
            }
        }
    }

    private fun showImage(marker: Marker?): Boolean {
        val alertadd: AlertDialog.Builder = AlertDialog.Builder(this.context)
        val factory = LayoutInflater.from(this.context)
        val view: View = factory.inflate(R.layout.dialog_preview, null)
        Glide
            .with(this.supportMapFragment)
            .load(marker?.snippet)
            .centerCrop()
            .into(view.findViewById(R.id.dialog_imageview))
        alertadd.setView(view)
        alertadd.setNeutralButton("Close", DialogInterface.OnClickListener { dlg, sumthin -> })
        alertadd.show()
        return true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onMapReady(currentGoogleMap: GoogleMap?) {
        googleMap = currentGoogleMap!!
        mapViewModel.CameraModelRoot.observe(this, observer)
    }
}