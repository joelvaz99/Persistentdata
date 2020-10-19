package ipvc.estg.persistentdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Abrir o ficheiro file1 em modo privado
        val sharedPref: SharedPreferences = getSharedPreferences  (
              getString (R.string.preference_file_key), Context.MODE_PRIVATE )

        // Passar um valor default (boolean-false) ao soundvalue
        val soundvalue = sharedPref.getBoolean(getString(R.string.sound),false)
        Log.d("****SHAREDPREF", "Read $soundvalue")

        //verificar se o valor do soundvalue is true
        if(soundvalue) {
            findViewById<CheckBox>(R.id.checkBox).isChecked=true
        }
    }
     fun checkboxclicked (view: View){
         if (view is CheckBox){
             val sharedPref: SharedPreferences = getSharedPreferences  (
                     getString (R.string.preference_file_key),Context.MODE_PRIVATE )
             with(sharedPref.edit()){
                 putBoolean(getString(R.string.sound), view.isChecked)
                 commit()
             }
             Log.d("***SHAREDPREF", "Changed to ${view.isChecked}")
         }


     }
}