package com.example.drivekitquickstart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.drivequant.drivekit.core.DriveKit
import com.drivequant.drivekit.permissionsutils.PermissionsUtilsUI
import com.drivequant.drivekit.permissionsutils.permissions.listener.PermissionViewListener
import com.drivequant.drivekit.tripanalysis.DriveKitTripAnalysis
import com.example.drivekitquickstart.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(32.dp)
                ) {
                    Image(painterResource(R.drawable.ic_drivequant_logo),"DriveQuant company logo")
                    Introduction()
                    AskForPermissions()
                    ConfigureDriveKit()
                }
            }
        }
    }
}

@Composable
fun Introduction() {
    Text(text = "Welcome to the DriveKit Quickstart Android app!")
    Text(
        text = "Authorize runtime permissions and configure DriveKit by clicking on the buttons below and then you are ready make your first trips in vehicle!",
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun AskForPermissions() {
    val context = LocalContext.current
    Button(
        onClick = {
            PermissionsUtilsUI.showPermissionViews(context, object : PermissionViewListener {
                override fun onFinish() {}
            })
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
        ), modifier = Modifier.fillMaxWidth()
    ) {
        Text("Ask for permissions")
    }
}

@Composable
fun ConfigureDriveKit() {
    Button(
        onClick = {
            configureDriveKit()
        }, colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
        ), modifier = Modifier.fillMaxWidth()
    ) {
        Text("Configure DriveKit")
    }
}

fun configureDriveKit() {
    DriveKit.setApiKey("YOUR_API_KEY_HERE")
    DriveKit.setUserId("YOUR_USER_ID_HERE")
    DriveKitTripAnalysis.activateAutoStart(activate = true)
}