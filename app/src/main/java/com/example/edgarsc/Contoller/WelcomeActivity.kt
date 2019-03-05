package com.example.edgarsc.Contoller

import android.content.Intent
import android.os.Bundle
import com.example.edgarsc.R
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
