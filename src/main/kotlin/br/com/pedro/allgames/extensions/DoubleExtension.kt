package br.com.pedro.allgames.extensions

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun Double.apenasDuasCasasDecimais():Double{
   return DecimalFormat("#.00", DecimalFormatSymbols(Locale.US))
       .format(this)
       .toDouble()
}