package helpers.util;


import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import pages.common.ui.HomePage;
import pages.common.ui.Post;

import java.util.List;

public class Storage {
    private static final String FILTER_INFO = "filter-information";
    private static final String FAILED_PERMISSION = "failed-permissions";
    private static final String HOME_PAGE = "home-page";
    private static final String POST_PAGE = "post-page";

    public static List<String> getFailedPermissions(){return (List<String>) getStorage().get(FAILED_PERMISSION);}
    public static void flushAll() {
        getStorage().entrySet().clear();
    }

    private static DataStore getStorage() {
        return DataStoreFactory.getScenarioDataStore();
    }

    public static HomePage getHomePage() {
        return (HomePage) getStorage().get(HOME_PAGE);
    }

    public static void setHomePage(HomePage homePage) {
        getStorage().put(HOME_PAGE, homePage);
    }

    public static Post getPostPage() {
        return (Post) getStorage().get(POST_PAGE);
    }

    public static void setPostPage(Post post) {
        getStorage().put(POST_PAGE, post);
    }
}
