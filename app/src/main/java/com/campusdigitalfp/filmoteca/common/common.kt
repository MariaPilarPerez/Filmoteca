package com.campusdigitalfp.filmoteca.common

import android.R.attr.navigationIcon
import android.R.attr.title
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperiorComun(navController: NavHostController, atras: Boolean = true, c_edit: Boolean = false)
{
    TopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary),
            title = {
                  Text(text = "Filmoteca")
                    },
            navigationIcon = {
                if (atras) {
                    IconButton(onClick = {
                        if (c_edit){
                        navController.previousBackStackEntry?.savedStateHandle?.set(
                            "key_result",
                            "RESULT_CANCELED")}
                        navController.popBackStack() })
                    {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Atrás"
                        )
                    }
                }
            }
            )
}

