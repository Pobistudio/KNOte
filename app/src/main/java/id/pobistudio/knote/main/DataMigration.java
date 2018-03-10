package id.pobistudio.knote.main;

import id.pobistudio.knote.helper.Constanta;
import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

/**
 * Created by kukuh on 16/02/18.
 */

public class DataMigration implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

        //Mengambil schema
        RealmSchema schema = realm.getSchema();

        //membuat schema baru jika versi 0
        if (oldVersion == Constanta.Config.DATABASE_VERSION) {

            schema.create("Note")
                    .addField("id", int.class)
                    .addField("title", String.class)
                    .addField("description", String.class)
                    .addField("createdAt", String.class)
                    .addField("updatedAt", String.class)
                    .addField("noteStatus", String.class);

            schema.create("NoteReminder")
                    .addField("id", int.class)
                    .addField("noteId", String.class)
                    .addField("reminderNote", String.class);

            oldVersion++;
        }

    }
}
