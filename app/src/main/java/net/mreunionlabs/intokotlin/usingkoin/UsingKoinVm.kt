package net.mreunionlabs.intokotlin.usingkoin

import android.arch.lifecycle.ViewModel

class UsingKoinVm(private val itemRepo: ItemRepository): ViewModel() {

    fun getHello(): String {
        return itemRepo.getHello()
    }
}