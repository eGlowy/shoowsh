package com.example.edgarsc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        getStartedBtn.setOnClickListener {
            //explicit intent lai pateiktu kur konkrēti doties.
            //implicit intent pasaka jebkuru aplikāciju ar kaut kādu kritēriju vērt vaļā (piemēram epasta apps, browseri uz linkiem u.t.t)
            val leagueIntent = Intent(this, LeagueActivity::class.java)
            startActivity(leagueIntent)
        }
    }
}
