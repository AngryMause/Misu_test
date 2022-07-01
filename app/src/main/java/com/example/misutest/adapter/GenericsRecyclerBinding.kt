package com.example.misutest.adapter

import android.view.View

interface GenericsRecyclerBinding<T> {
    fun bindingData(item:T,view:View)
}