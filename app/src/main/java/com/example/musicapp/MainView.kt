package com.example.musicapp

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("RestrictedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MainView(){
    val dialogOpen = remember {
        mutableStateOf(false)
    }
    val isFullScreen by remember {
        mutableStateOf(false)
    }
    val modifier = if(isFullScreen) Modifier.fillMaxSize() else Modifier.fillMaxWidth()
    val controller : NavController = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val viewModel : MainViewModel = viewModel()
    val scope : CoroutineScope = rememberCoroutineScope()
    val scaffoldState : ScaffoldState = rememberScaffoldState()
    val currentScreen = remember {
        viewModel.currentScreen.value
    }
    var title = remember{
        mutableStateOf(currentScreen.title)
    }
    val modelSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmValueChange = {it != ModalBottomSheetValue.HalfExpanded}
    )
    val roundedCorner = if(isFullScreen) 0.dp else 12.dp
    val bottomBar : @Composable () -> Unit = {
        if (currentScreen is Screen.DrawerScreen || currentScreen == Screen.BottomScreen.Home){
            BottomNavigation(Modifier.wrapContentSize()) {
                ScreenInBottom.forEach {
                    item ->
                    val isSelected = currentRoute == item.bRoute
                    val tint = if(isSelected) Color.White else Color.Black
                    BottomNavigationItem(selected = currentRoute == item.bRoute,
                        onClick = {
                            controller.navigate(item.bRoute)
                            title.value = item.bTitle
                                  },
                        icon = {
                            Icon(painter = painterResource(id = item.Icon),
                                contentDescription = item.bTitle,
                                tint = tint)
                        },
                        label = {
                            Text(text = item.bTitle,
                                color = tint)
                        },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.Black
                    )
                }
            }
        }
    }
    
    ModalBottomSheetLayout(sheetContent = {
        MoreBottomSheet(modifier = modifier)
    },
        sheetState = modelSheetState,
        sheetShape = RoundedCornerShape(topStart = roundedCorner, topEnd = roundedCorner),
    )
    {
        Scaffold (
            bottomBar = bottomBar,
            topBar = {
                TopAppBar(title = {Text(title.value)},
                    actions = {
                        // the 3  points (MoreVert)
                        IconButton(onClick = {
                                   scope.launch {
                                       if (modelSheetState.isVisible){
                                           modelSheetState.hide()
                                       }else{
                                           modelSheetState.show()
                                       }
                                   }
                        }) {
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            // Open the Drawer
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }) {
                            Icon(imageVector = Icons.Default.AccountCircle,
                            contentDescription = null)
                        }
                    })
            },
            scaffoldState = scaffoldState,
            drawerContent = {
                LazyColumn {
                    items(ScreenInDrawer){
                        item->
                        DrawerItem(selected = currentRoute == item.dRoute , Item = item){
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                            if(item.dRoute == "addAccount"){
                                dialogOpen.value = true
                            }else{
                                controller.navigate(item.dRoute)
                                title.value = item.dTitle
                            }
                        }
                    }
                }

            }

        ){
            Navigation(navController = controller, viewModel = viewModel, pd = it)
            accountDialog(dialog = dialogOpen)
        }
    }

}

@Composable
fun MoreBottomSheet(modifier: Modifier) {
    Box (
        modifier = modifier
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .height(300.dp)

    ){
        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)){
            Row (
                modifier = Modifier.padding(16.dp)
            ){
                Icon(imageVector = Icons.Default.Settings, contentDescription = null,
                    modifier = Modifier.padding(end = 8.dp), tint = MaterialTheme.colorScheme.secondary)
                Text(text = "Settings", color = MaterialTheme.colorScheme.secondary)
            }
            Row (
                modifier = Modifier.padding(16.dp)
            ){
                Icon(imageVector = Icons.Default.Share, contentDescription = null,
                    modifier = Modifier.padding(end = 8.dp),
                    tint = MaterialTheme.colorScheme.secondary)
                Text(text = "Share", color = MaterialTheme.colorScheme.secondary)
            }
            Row (
                modifier = Modifier.padding(16.dp)
            ){
                Icon(painter = painterResource(id = R.drawable.help_24px), contentDescription = null,
                    modifier = Modifier.padding(end = 8.dp),
                    tint = MaterialTheme.colorScheme.secondary)
                Text(text = "Help", color = MaterialTheme.colorScheme.secondary)
            }

        }
    }
}

@Composable
fun DrawerItem(
    selected : Boolean,
    Item : Screen.DrawerScreen,
    onDrawableItemClicked : () -> Unit
){
    val background = if (selected) Color.DarkGray else  Color.White
    Row (modifier = Modifier
        .fillMaxWidth()
        .statusBarsPadding()
        .background(background)
        .padding(vertical = 10.dp, horizontal = 8.dp)
        .clickable {
            onDrawableItemClicked()
        },

    ){
        Icon(painter = painterResource(id = Item.Icon),
            contentDescription = Item.dTitle,
            modifier = Modifier
                .padding(horizontal = 8.dp))
        Text(text = Item.dTitle,
            style = MaterialTheme.typography.bodyLarge)
    }

}

@Composable
fun Navigation(navController: NavController, viewModel: MainViewModel, pd : PaddingValues){
    NavHost(navController = navController as NavHostController,
        startDestination = Screen.DrawerScreen.Account.dRoute,
        modifier = Modifier.padding(pd)) {
        composable(route = Screen.BottomScreen.Home.bRoute){
            homeView()
        }
        composable(route = Screen.BottomScreen.Browse.bRoute){
            Browse()
        }
        composable(route = Screen.BottomScreen.Library.bRoute){
            Library()
        }
        composable(route = Screen.DrawerScreen.Account.dRoute){
            AccountView()
        }
        composable(route = Screen.DrawerScreen.Subscribtion.dRoute){
            SubscriptionView()
        }
    }
}