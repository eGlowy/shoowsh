package com.example.edgarsc.Contoller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.edgarsc.Utilities.EXTRA_LEAGUE
import com.example.edgarsc.R
import com.example.edgarsc.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var selectedSkill = ""
    var league = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
    }

    fun onBallerClicked(view: View){
        begginerSkillBtn.isChecked = false
        selectedSkill = "baller"
    }

    fun onBegginerClicked(view: View){
        ballerSkilllBtn.isChecked = false
        selectedSkill = "begginer"
    }

    fun onSkillFinishClicked(view: View){
        if (selectedSkill != "")
        {
            var finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE,league)
            finishActivity.putExtra(EXTRA_SKILL, selectedSkill)
            startActivity(finishActivity)
        } else
        {
            Toast.makeText(this,"Please select your skill.", Toast.LENGTH_SHORT).show()
        }
    }
}
