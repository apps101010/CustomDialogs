package com.example.customdialogs

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val snackbtn = findViewById<Button>(R.id.snackbtn)
        val dialogBtn = findViewById<Button>(R.id.dialogbtn)
        val customBtn = findViewById<Button>(R.id.custombtn)
        val progressBtn = findViewById<Button>(R.id.progressbtn)

        snackbtn.setOnClickListener {
            Snackbar.make(it,"You have clicked image button", Snackbar.LENGTH_SHORT).show()
        }

        dialogBtn.setOnClickListener {
            alertDialogFunction()
        }

        customBtn.setOnClickListener {
            customAlertDialog()
        }

        progressBtn.setOnClickListener {
            customProgressDialog()
        }

        
    }

    private fun customProgressDialog() {
        val customProgressDialog = Dialog(this)
         customProgressDialog.setContentView(R.layout.progress_dialog)
        customProgressDialog.show()
    }

    private fun customAlertDialog() {
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.dialog_custom)
        customDialog.findViewById<Button>(R.id.submitbtn).setOnClickListener {
            Toast.makeText(this,"Submit button clicked",Toast.LENGTH_SHORT).show()
            customDialog.dismiss()
        }
        customDialog.findViewById<Button>(R.id.cancelbtn).setOnClickListener {
            Toast.makeText(this,"Cancel button is clicked",Toast.LENGTH_SHORT).show()
            customDialog.dismiss()
        }

        customDialog.show()

    }

    private fun alertDialogFunction() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("This is alert dialog. which is used to show dialog")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        builder.setPositiveButton("Yes"){ dialogInterface, which ->
            Toast.makeText(this,"Yes button is clicked",Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }

        builder.setNeutralButton("Cancel"){ dialogInterface, which ->
            Toast.makeText(this,"Cancel button is clicked",Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }

        builder.setNegativeButton("No"){ dialogInterface, which ->
            Toast.makeText(this,"No button is clicked",Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
}