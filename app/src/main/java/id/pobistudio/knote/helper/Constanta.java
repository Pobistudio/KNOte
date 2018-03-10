package id.pobistudio.knote.helper;

/**
 * Created by KUKUH on 15-Feb-18.
 */

public interface Constanta{

    public static final String TYPE_REQUEST = "mobile_ewarga";

    public static class Preference {

    }

    public static class NoteStatus {
        public static final String ACTIVE = "00";
        public static final String TEMPORARY_TRASH = "01";
        public static final String PERMANENT_TRASH = "02";
    }

    public static class Url {
    }

    public static class Message {
        public static final String ERR_CONNECTION = "Koneksi Tidak Stabil";
        public static final String ERR_SERVER_DOWN = "Server Down";
        public static final String ERR_RESPONSE = "Response Error";
        public static final String ERR_FAIED_DATA = "Failed Data";

        public static final String FAILURE = "Connection Failure";
        public static final String ERROR_RESPONSE = "Error Response";
        public static final String UNSUCCESS_RESPONSE = "Unsuccess Response";
        public static final String ERROR_PARSING = "Error Parsing";
    }

    public static class Config {
        public static final String DATABASE_NAME = "knote.realm";
        public static final int DATABASE_VERSION = 1;
    }

}
