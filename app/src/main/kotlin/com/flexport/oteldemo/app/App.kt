/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.flexport.oteldemo.app

import com.flexport.oteldemo.utilities.StringUtils

import org.apache.commons.text.WordUtils

fun main() {
    val tokens = StringUtils.split(MessageUtils.getMessage())
    val result = StringUtils.join(tokens)
    println(WordUtils.capitalize(result))
}
