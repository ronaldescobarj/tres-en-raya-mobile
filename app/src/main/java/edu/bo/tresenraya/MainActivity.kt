package edu.bo.tresenraya

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var board = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)

    fun checkWinner(player: Int): Boolean {
        if (board[0] == player && board[1] == player && board[2] == player)
            return true;
        if (board[3] == player && board[4] == player && board[5] == player)
            return true
        if (board[6] == player && board[7] == player && board[8] == player)
            return true
        if (board[0] == player && board[3] == player && board[6] == player)
            return true
        if (board[1] == player && board[4] == player && board[7] == player)
            return true
        if (board[2] == player && board[5] == player && board[8] == player)
            return true
        if (board[0] == player && board[4] == player && board[8] == player)
            return true
        if (board[2] == player && board[4] == player && board[6] == player)
            return true
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setBackgroundColor(Color.parseColor("#ff0000"))
        button2.setBackgroundColor(Color.parseColor("#0000ff"))

    }

    fun disable(position: Int) {
        if (position == 0) {
            btn11.isEnabled = false;
            btn11.isClickable = false;
            btn11.setBackgroundColor(Color.parseColor("#0000ff"))
        }
        if (position == 1) {
            btn12.isEnabled = false;
            btn12.isClickable = false;
            btn12.setBackgroundColor(Color.parseColor("#0000ff"))

        }
        if (position == 2) {
            btn13.isEnabled = false;
            btn13.isClickable = false;
            btn13.setBackgroundColor(Color.parseColor("#0000ff"))

        }
        if (position == 3) {
            btn21.isEnabled = false;
            btn21.isClickable = false;
            btn21.setBackgroundColor(Color.parseColor("#0000ff"))

        }
        if (position == 4) {
            btn22.isEnabled = false;
            btn22.isClickable = false;
            btn22.setBackgroundColor(Color.parseColor("#0000ff"))
        }
        if (position == 5) {
            btn23.isEnabled = false;
            btn23.isClickable = false;
            btn23.setBackgroundColor(Color.parseColor("#0000ff"))
        }
        if (position == 6) {
            btn31.isEnabled = false;
            btn31.isClickable = false;
            btn31.setBackgroundColor(Color.parseColor("#0000ff"))
        }
        if (position == 7) {
            btn32.isEnabled = false;
            btn32.isClickable = false;
            btn32.setBackgroundColor(Color.parseColor("#0000ff"))
        }
        if (position == 8) {
            btn33.isEnabled = false;
            btn33.isClickable = false;
            btn33.setBackgroundColor(Color.parseColor("#0000ff"))
        }
    }

    fun enable(position: Int) {
        if (position == 0) {
            btn11.isEnabled = true;
            btn11.isClickable = true;
            btn11.setBackgroundColor(Color.parseColor("#888c8d"))
        }
        if (position == 1) {
            btn12.isEnabled = true;
            btn12.isClickable = true;
            btn12.setBackgroundColor(Color.parseColor("#888c8d"))
        }
        if (position == 2) {
            btn13.isEnabled = true;
            btn13.isClickable = true;
            btn13.setBackgroundColor(Color.parseColor("#888c8d"))
        }
        if (position == 3) {
            btn21.isEnabled = true;
            btn21.isClickable = true;
            btn21.setBackgroundColor(Color.parseColor("#888c8d"))
        }
        if (position == 4) {
            btn22.isEnabled = true;
            btn22.isClickable = true;
            btn22.setBackgroundColor(Color.parseColor("#888c8d"))
        }
        if (position == 5) {
            btn23.isEnabled = true;
            btn23.isClickable = true;
            btn23.setBackgroundColor(Color.parseColor("#888c8d"))
        }
        if (position == 6) {
            btn31.isEnabled = true;
            btn31.isClickable = true;
            btn31.setBackgroundColor(Color.parseColor("#888c8d"))
        }
        if (position == 7) {
            btn32.isEnabled = true;
            btn32.isClickable = true;
            btn32.setBackgroundColor(Color.parseColor("#888c8d"))
        }
        if (position == 8) {
            btn33.isEnabled = true;
            btn33.isClickable = true;
            btn33.setBackgroundColor(Color.parseColor("#888c8d"))
        }
    }

    fun computerTurn() {
        var hasPlayed = false;
        while(!hasPlayed) {
            val position = Random.nextInt(0, 8)
            if (board[position] == 0) {
                board[position] = 2;
                disable(position)
                hasPlayed = true
                verifyWin()
            }
        }
    }

    fun verifyWin(): Boolean {
        if (checkWinner(1)) {
            val builder = AlertDialog.Builder(this) // Builder needs a context
            builder.setTitle("Ganador")
            builder.setMessage("Usuario")
            builder.setPositiveButton("Resetear") { _,_ ->
                resetBoard()
            }
            builder.show()
            return true
        } else if (checkWinner(2)) {
            val builder = AlertDialog.Builder(this) // Builder needs a context
            builder.setTitle("Ganador")
            builder.setMessage("Computadora")
            builder.setPositiveButton("Resetear") { _,_ ->
                resetBoard()
            }
            builder.show()
            return true
        } else {
            if (board[0] != 0 && board[1] != 0 && board[2] != 0 && board[3] != 0 && board[4] != 0 && board[5] != 0 && board[6] != 0 && board[7] != 0 && board[8] != 0) {
                val builder = AlertDialog.Builder(this) // Builder needs a context
                builder.setTitle("Empate")
                builder.setMessage("Fin del juego")
                builder.setPositiveButton("Resetear") { _,_ ->
                    resetBoard()
                }
                builder.show()
                return true
            }
            else
                return false
        }
    }

    fun onClickBtn11(view: View) {
        if (board[0] == 0) {
            board[0] = 1;
            btn11.setBackgroundColor(Color.parseColor("#ff0000"))
            if (!verifyWin())
                computerTurn()
        }
    }

    fun onClickBtn12(view: View) {
        if (board[1] == 0) {
            board[1] = 1;
            btn12.setBackgroundColor(Color.parseColor("#ff0000"))
            if (!verifyWin())
                computerTurn()
        }
    }

    fun onClickBtn13(view: View) {
        if (board[2] == 0) {
            board[2] = 1;
            btn13.setBackgroundColor(Color.parseColor("#ff0000"))
            if (!verifyWin())
                computerTurn()
        }
    }

    fun onClickBtn21(view: View) {
        if (board[3] == 0) {
            board[3] = 1;
            btn21.setBackgroundColor(Color.parseColor("#ff0000"))
            if (!verifyWin())
                computerTurn()
        }
    }

    fun onClickBtn22(view: View) {
        if (board[4] == 0) {
            board[4] = 1;
            btn22.setBackgroundColor(Color.parseColor("#ff0000"))
            if (!verifyWin())
                computerTurn()
        }
    }

    fun onClickBtn23(view: View) {
        if (board[5] == 0) {
            board[5] = 1;
            btn23.setBackgroundColor(Color.parseColor("#ff0000"))
            if (!verifyWin())
                computerTurn()
        }
    }

    fun onClickBtn31(view: View) {
        if (board[6] == 0) {
            board[6] = 1;
            btn31.setBackgroundColor(Color.parseColor("#ff0000"))
            if (!verifyWin())
                computerTurn()
        }
    }

    fun onClickBtn32(view: View) {
        if (board[7] == 0) {
            board[7] = 1;
            btn32.setBackgroundColor(Color.parseColor("#ff0000"))
            if (!verifyWin())
                computerTurn()
        }
    }

    fun onClickBtn33(view: View) {
        if (board[8] == 0) {
            board[8] = 1;
            btn33.setBackgroundColor(Color.parseColor("#ff0000"))
            if (!verifyWin())
                computerTurn()
        }
    }

    fun resetBoard() {
        board = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
        enable(0)
        enable(1)
        enable(2)
        enable(3)
        enable(4)
        enable(5)
        enable(6)
        enable(7)
        enable(8)

    }

}
