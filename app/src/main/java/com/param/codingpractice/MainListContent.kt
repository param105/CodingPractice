package com.param.codingpractice

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object MainListContent {


   var listLables  = arrayOf("Simple Service",
   "Simple Intent Service")
    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<MainListItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, MainListItem> = HashMap()

    private val COUNT = listLables.count()

    init {

        for (i in 0..COUNT -1) {
            addItem(
                createDummyItem(
                    i
                )
            )
        }
    }

    private fun addItem(item: MainListItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun createDummyItem(position: Int): MainListItem {
        return MainListItem(
            position.toString(),
            listLables[position],
            makeDetails(position)
        )
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(listLables[position])
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class MainListItem(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }
}
