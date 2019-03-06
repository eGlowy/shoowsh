package com.example.edgarsc.Contoller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.edgarsc.Model.Player
import com.example.edgarsc.R
import com.example.edgarsc.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("","")

    //Saglabā player state , lai apgriežot ierīci nepazūd current state aktivitātei
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    //kad pagriež device notiek resotre aktivitātei un saglabāto player state padod jaunajai aktivitātes instancei, lai netiktu pazaudēti dati
    //If statement priekš safe call , lai pārliecinātos ka dati tiešām ir, ja nav tad nedara neko un turpina no nulles.
    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun onMensClicked(view: View){
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked= false
        player.league = "mens"
    }

    fun onWomensClicked(view: View){
        mensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked= false
        player.league = "womens"
    }

    fun onCoedClicked(view: View){
        mensLeagueBtn.isChecked = false
        womensLeagueBtn.isChecked = false
        player.league = "co-ed"
    }

    fun leagueNextClicked(view: View)
    {
        if (player.league != "")
        {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        }
        else
        {
            Toast.makeText(this,"Please select a league.",Toast.LENGTH_SHORT).show()
        }
    }


}
