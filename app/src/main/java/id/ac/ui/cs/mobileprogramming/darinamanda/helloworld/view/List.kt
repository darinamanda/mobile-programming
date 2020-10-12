package id.ac.ui.cs.mobileprogramming.darinamanda.helloworld.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import id.ac.ui.cs.mobileprogramming.darinamanda.helloworld.R
import id.ac.ui.cs.mobileprogramming.darinamanda.helloworld.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.list_fragment.*

class List : Fragment() {

    private lateinit var viewModel: ListViewModel
    private val listAdapter = ListAdapter(arrayListOf())

    companion object {
        fun newInstance() = List()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refesh()

        itemsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.powerpuffs.observe(this, Observer { powerpuff ->
            powerpuff?.let {
                itemsList.visibility = View.VISIBLE
                listAdapter.updateList(powerpuff)
            }
        })

        viewModel.error.observe(this, Observer { isError ->
            isError?.let {
                listError.visibility = if (it) View.VISIBLE else View.GONE
            }

        })

        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                loadingView.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    listError.visibility = View.GONE
                    itemsList.visibility = View.GONE
                }
            }
        })
    }
}