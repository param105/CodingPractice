package com.param.codingpractice

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 *
 */
object MainListContent {


   private var listLabels  = arrayOf("Simple Service", "Simple Intent Service", "Messenger Service")
    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<MainListItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    private val ITEM_MAP: MutableMap<String, MainListItem> = HashMap()

    private val COUNT = listLabels.count()

    init {

        for (i in 0 until COUNT) {
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
            listLabels[position],
            makeDetails(position)
        )
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(listLabels[position])
        for (i in 0 until position) {
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
