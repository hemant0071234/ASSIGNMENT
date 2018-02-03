package helpers.util;


import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;

import java.util.List;

public class Storage {
    private static final String FILTER_INFO = "filter-information";
    private static final String FAILED_PERMISSION = "failed-permissions";

    public static List<String> getFailedPermissions(){return (List<String>) getStorage().get(FAILED_PERMISSION);}
    public static void flushAll() {
        getStorage().entrySet().clear();
    }

    private static DataStore getStorage() {
        return DataStoreFactory.getScenarioDataStore();
    }
}
