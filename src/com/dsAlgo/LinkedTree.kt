package com.dsAlgo

interface LinkedTree<T> {
    fun insert(data:Int)
    fun delete(any :T)
    fun search(key:Int,node:Node?):Node?
    fun traverse( node: Node?):Unit

}