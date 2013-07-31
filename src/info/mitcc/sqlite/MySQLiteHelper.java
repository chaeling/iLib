package info.mitcc.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {
	public static final String DATABASE_NAME = "ilib.db";
	public static final int VERSION = 1;
	public static final String TABLE_NAME = "mitcc";
	public static final String ID = "id";
	public static final String SEARCH_RECORD = "search_record";
	public MySQLiteHelper(Context context) {
		super(context,DATABASE_NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		String SQL_createTable = "CREATE TABLE " + TABLE_NAME + "(" + ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT," + SEARCH_RECORD + " search_record );";
		db.execSQL(SQL_createTable);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}

}
