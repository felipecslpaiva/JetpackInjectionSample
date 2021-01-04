package gg.paiva.jetpackexploration.map

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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
import gg.paiva.jetpackexploration.extensions.loadUrl
import gg.paiva.jetpackexploration.map.models.CameraModelRoot
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MapFragment : Fragment(), OnMapReadyCallback {
    private val mapViewModel: MapViewModel by viewModel()
    private lateinit var binding: FragmentMapBinding
    private lateinit var supportMapFragment: SupportMapFragment
    private lateinit var googleMap: GoogleMap
    private var isFirst: Boolean = true
    companion object{
        const val DEFAULT_ZOOM : Float = 12F
    }
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

    //Map Callback
    override fun onMapReady(currentGoogleMap: GoogleMap) {
        googleMap = currentGoogleMap
        mapViewModel.CameraModelRoot.observe(this, observer)
    }

    @SuppressLint("SetTextI18n")
    private val observer = Observer<CameraModelRoot> {
        //If there's a content update remove the previous ones
        googleMap.clear()
        //adding new markers
        addMarkers(googleMap, it)
    }

    //Could move this to a use case
    private fun addMarkers(googleMap: GoogleMap, cameraModelRoot: CameraModelRoot) {
        //Going over as many region lists we do have
        for (camerasList in cameraModelRoot.itemsList){
            //Going over as the cameras for that specific region
            for (camera in camerasList.cameras){
                //Camera Markers
                val marker = MarkerOptions()
                    .position(LatLng(camera.location.latitude, camera.location.longitude))
                    .title(camera.camera_id)
                    .snippet(camera.image)
                googleMap.addMarker(marker)
                googleMap.setOnMarkerClickListener{ showImage(it) }

                //Zoom in to the first camera
                if(isFirst){
                    val cameraPosition: CameraPosition = CameraPosition.Builder()
                        .target(LatLng(camera.location.latitude, camera.location.longitude))
                        .zoom(DEFAULT_ZOOM)
                        .build()
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
                    isFirst = false
                }
            }
        }
    }

    //Could move this to a extension class to be reused
    private fun showImage(marker: Marker): Boolean {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this.context)
        val factory = LayoutInflater.from(this.context)
        val view: View = factory.inflate(R.layout.dialog_preview, null)
        val imageView = view.findViewById(R.id.dialog_imageview) as ImageView
        imageView.loadUrl(marker.snippet, imageView)
        alertDialog.setView(view)
        alertDialog.setNeutralButton("Close", DialogInterface.OnClickListener { _, _ -> })
        alertDialog.show()
        return true
    }
}