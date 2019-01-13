package net.mreunionlabs.intokotlin.koin

import net.mreunionlabs.intokotlin.usingkoin.ItemRepository
import net.mreunionlabs.intokotlin.usingkoin.ItemRepositoryImpl
import net.mreunionlabs.intokotlin.usingkoin.UsingKoinVm
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {

    // single instance of the repository
    single<ItemRepository> { ItemRepositoryImpl() }

    viewModel { UsingKoinVm(get()) }
}