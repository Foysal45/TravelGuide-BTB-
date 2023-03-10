package com.btb.explorebangladesh.presentation.activities.auth


import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.ui.NavigationUI
import com.btb.explorebangladesh.activity.findNavController
import com.btb.explorebangladesh.databinding.ActivityAuthBinding
import com.btb.explorebangladesh.presentation.activities.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AuthActivity : BaseActivity<ActivityAuthBinding>() {

    private val navController by lazy {
        findNavController(binding.navHostAuthFragment.id)
    }

    private val viewModel by viewModels<AuthViewModel>()

    override fun initializeViewBinding() = ActivityAuthBinding.inflate(layoutInflater)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.elevation = 0f
        navController.addOnDestinationChangedListener { _, destination, _ ->
            supportActionBar?.let {
                title = destination.label
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }


}