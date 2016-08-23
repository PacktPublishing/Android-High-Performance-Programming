public class ExampleOpenHelper extends SQLiteOpenHelper {

   private static final int DATABASE_VERSION = 2;
   private static final String EXAMPLE_TABLE_NAME = "example";
   private static final String EXAMPLE_TABLE_CREATE =
           "CREATE TABLE " + EXAMPLE_TABLE_NAME + " (" +
           KEY_WORD + " TEXT, " +
           KEY_DEFINITION + " TEXT);";

   ExampleOpenHelper (Context context) {
      super(context, DATABASE_NAME, null, DATABASE_VERSION);
   }

   @Override
   public void onCreate(SQLiteDatabase db) {
      db.execSQL(EXAMPLE_TABLE_CREATE);
   }
}
