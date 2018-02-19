package robots;

import com.hcl.canada.R;

import utils.RoboUtils;

public class AboutListRobot {

    public static class Eyes {
        public Eyes seesSwipeRefreshLayout() {
            RoboUtils.seesViewWithId(R.id.swipe_refresh_layout);
            return this;
        }

        public Eyes seesListRecyclerView() {
            RoboUtils.seesViewWithId(R.id.about_recycler_view);
            return this;
        }

        public Eyes doesNotSeeNoContentView() {
            RoboUtils.doesNotSeesViewWithId(R.id.no_content_available);
            return this;
        }

        public Eyes doesNotSeeListRecyclerView() {
            RoboUtils.doesNotSeesViewWithId(R.id.about_recycler_view);
            return this;
        }

        public Eyes seesNoContentView() {
            RoboUtils.seesViewWithId(R.id.no_content_available);
            return this;
        }
    }
}
