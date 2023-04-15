package com.myra_winter.hiltblueprint.ui.authenticated.books

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(

) : ViewModel() {


    //https://github.com/manueldidonna/waves-timer-animation/blob/main/app/src/main/java/com/manueldidonna/wavestimeranimation/TimerCard.kt

// prints all files you save in you app in files
//    File("/data/user/0/Packagename/files").walk().forEach {
//        println(it)
//    }


//    override val document: LiveData<ENUM>
//        get() {
//            return liveData {
//                Log.d("TESTING", "livedata doc")
//                TestRepository.getSomethingFromSomeWhere.fold(
//                    onSuccess = {
//                        Log.d("TESTING", "onSuccess")
//                        emit(ENUM.YES(it))
//                    },
//                    onFailure = {
//                        emit(ENUM.NO)
//                    }
//                )
//            }
//        }

//    val data = CoroutineScope(Dispatchers.IO).async rt@ {
//        return@rt work()
//    }.await()

}