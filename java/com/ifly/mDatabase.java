package com.ifly;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.lang.annotation.Target;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {TargetTable.class,DoneTable.class,ScheduleTable.class}, version = 4, exportSchema = false)
public abstract class mDatabase extends RoomDatabase {

    public abstract TargetDao targetDao();
    public abstract DoneDao doneDao();
    public abstract ScheduleDao scheduleDao();

    private static volatile mDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static mDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (mDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            mDatabase.class, "ifly_database")
                            .addCallback(DatabaseCallback)
                            .fallbackToDestructiveMigration()
                            .createFromAsset("schedule_db.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback DatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                TargetDao dao = INSTANCE.targetDao();
                DoneDao doneDao = INSTANCE.doneDao();
                ScheduleDao scheduleDao = INSTANCE.scheduleDao();

            });
        }
    };
}