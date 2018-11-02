package com.example.juliodebuen.excercise

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.juliodebuen.excercise.database.DbWorkerThread
import com.example.juliodebuen.excercise.database.FullDatabase
import com.example.juliodebuen.excercise.model.Exercise
import com.example.juliodebuen.excercise.model.RelExerciseRoutine
import com.example.juliodebuen.excercise.model.Routine
import com.facebook.stetho.Stetho
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mDb: FullDatabase? = null
    private lateinit var mDbWorkerThread: DbWorkerThread
    private val mUiHandler = Handler()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Stetho.initialize(
            Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build()
        )
        mDbWorkerThread = DbWorkerThread("dbWorkerThread")
        mDbWorkerThread.start()
        mDb = FullDatabase.getInstance(this)



        actionBtn.setOnClickListener {
            val exercise = Exercise()
            exercise.description = "description"
            exercise.name = "Biceps curl"

            val routine = Routine()
            routine.name = "upper body"
            routine.dayOfWeek = "monday"


            var exerciseId : Long?
            var routineId : Long?

            val task = Runnable {
                exerciseId =  mDb?.exerciseDao()?.insert(exercise)
                routineId = mDb?.routineDao()?.insert(routine)
                val relExerciseRoutine = RelExerciseRoutine()
                relExerciseRoutine.exerciseId = exerciseId
                relExerciseRoutine.routineId = routineId
                mDb?.relExerciseRoutineDao()?.insert(relExerciseRoutine)
            }
            mDbWorkerThread.postTask(task)

        }

        btnOpenExcercise.setOnClickListener {
            startActivity(Intent(this, ExercisesActivity::class.java))
        }
    }

    override fun onDestroy() {
        FullDatabase.destroyInstance()
        mDbWorkerThread.quit()
        super.onDestroy()
    }
}
