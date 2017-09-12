package pb.coe.pbhackathon;

import android.app.Application;

import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.config.Configuration;

import org.greenrobot.eventbus.EventBus;

import pb.coe.pbhackathon.rest.RestFactory;

/**
 * Created by chetan on 11/09/17.
 * App Delegation for basic component
 */

public class AppDelegate {
    private static final AppDelegate instance = new AppDelegate();
    private EventBus eventBus;

    public static AppDelegate get() {
        return instance;
    }

    private RestFactory restFactory;
    private JobManager jobManager;

    private AppDelegate() {}

    public void init(Application app) {
        _initRestFactory(app);
        _buildJobManager(app);
        _buildEventBus(app);
    }

    private void _buildEventBus(Application app) {
        eventBus = EventBus.builder()
                .logNoSubscriberMessages(false)
                .sendNoSubscriberEvent(false)
                .build();
    }

    private void _initRestFactory(Application app) {
        restFactory = new RestFactory(BuildConfig.BASE_URL, BuildConfig.APP_KEY, BuildConfig.SECRET);
    }

    private void _buildJobManager(Application app) {
        Configuration configuration = new Configuration.Builder(app)
                .minConsumerCount(1)//always keep at least one consumer alive
                .maxConsumerCount(3)//up to 3 consumers at a time
                .loadFactor(3)//3 jobs per consumer
                .consumerKeepAlive(120)//wait 2 minute
                .build();
        jobManager = new JobManager(app, configuration);
    }

    public JobManager getJobManager() {
        return jobManager;
    }

    public RestFactory getRestFactory() {
        return restFactory;
    }

    public EventBus getEventBus() {
        return eventBus;
    }
}
