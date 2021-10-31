package com.example.viewmodellivedate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

//step 4: return to my activity
class MainActivity : AppCompatActivity() {

    //4-1) create variable of type myViewModel class
    lateinit var myViewModelM: myViewModel

    //step 2: design part & declaring my views
    lateinit var btn:Button
    lateinit var tvNum:TextView
    lateinit var tvBoolean: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //step 2
        btn=findViewById(R.id.button)
        tvNum=findViewById(R.id.tvNumber)
        tvBoolean=findViewById(R.id.tvBoolean)

        //4-2) instantiate myViewModel
        /*This provider will check if there is an instance of the same class already created,
        if so, it will return it with all the data up-to-date,if a ViewModel has not been created yet, it will be created for us.
        This ensures each time a configuration change or any similar event happens,
        that we won’t lose the current state of our data nor we will create a new instance of the ViewModel each time*/
        myViewModelM= ViewModelProvider(this)
            .get(myViewModel::class.java)

        //4-3) create observer and react properly to any change that occurs to the data store on the ViewModel by MutableLiveData
        //this observer will actually observe when mutableLiveData get set so it update text view
        myViewModelM.currentNumber.observe(this, Observer {
            //it keyword provides us with currently updated value
            tvNum.text=it.toString()
        })
        myViewModelM.currentBoolean.observe(this, Observer {
            //it keyword provides us with currently updated value
            tvBoolean.text=it.toString()
        })

        incrementNum()
    }

    fun incrementNum(){
        btn.setOnClickListener(){
            /* ++myViewModel.number will increment number variable in model class,
            so when we tutn the screen it will stay there (in screen) and in currentNumber variable as well  */
            myViewModelM.currentNumber.value= ++myViewModelM.number
            /* for the boolean i will take the number and check if it even
            */
            myViewModelM.currentBoolean.value= myViewModelM.number % 2==0
        }
    }
}