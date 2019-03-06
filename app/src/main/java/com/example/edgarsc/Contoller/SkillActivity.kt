package com.example.edgarsc.Contoller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.edgarsc.Model.Player
import com.example.edgarsc.R
import com.example.edgarsc.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var selectedSkill = ""
    var league = ""
    lateinit var player : Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    fun onBallerClicked(view: View){
        begginerSkillBtn.isChecked = false
        player.skill = "baller"
    }

    fun onBegginerClicked(view: View){
        ballerSkilllBtn.isChecked = false
        player.skill = "begginer"
    }

    fun onSkillFinishClicked(view: View){
        if (player.skill != "")
        {
            var finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)

            startActivity(finishActivity)
        } else
        {
            Toast.makeText(this,"Please select your skill.", Toast.LENGTH_SHORT).show()
        }
    }
}
