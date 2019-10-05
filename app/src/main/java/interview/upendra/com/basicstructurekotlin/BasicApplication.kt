package interview.upendra.com.basicstructurekotlin

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics

class BasicApplication: Application() {

    var firebaseAnalytics:FirebaseAnalytics?=null;

    override fun onCreate() {
        super.onCreate()

        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }

}