package id.ac.ui.cs.mobileprogramming.darinamanda.helloworld.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import id.ac.ui.cs.mobileprogramming.darinamanda.helloworld.R
import id.ac.ui.cs.mobileprogramming.darinamanda.helloworld.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.detail_fragment.*

class Detail : Fragment() {

    companion object {
        fun newInstance() = Detail()
    }

    private lateinit var viewModel: DetailViewModel
    private var powerpuffId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            powerpuffId = DetailArgs.fromBundle(it).id
        }

        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        viewModel.fetch(powerpuffId)

        observeViewModel()

    }

    fun observeViewModel() {
        viewModel.powerpuff.observe(this, Observer { powerpuff ->
            powerpuff?.let {
                powerpuffImage.setImageResource(powerpuff.image)
                powerpuffName.text = powerpuff.name
                powerpuffType.text = powerpuff.type
            }
        })
    }


}