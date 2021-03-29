package com.example.myboard.Network

import android.util.Log
import com.github.nkzawa.emitter.Emitter
import com.github.nkzawa.socketio.client.IO
import org.json.JSONException
import java.net.SocketException

object WebSocket {
    //TODO 소켓 주소 적기
    private val mSocket = IO.socket("")

    fun connectSocket() {
        try {
            mSocket.connect()

            val result = mSocket.connected()
            if (result) Log.d("socket connected", "소켓 연결 성공")
            else Log.e("socket failed", "소캣 실패$result")
        } catch (se: SocketException) {
            Log.e("socket", "An exception occurred:\n ${se.printStackTrace()}")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    fun disconnectSocket() {
        mSocket.disconnect()
    }

    fun addOnNewUserEvent(onNewUser: Emitter.Listener) {
        mSocket?.on("MESSAGE", onNewUser)
    }

    fun emitUserId(userId: String) {
        mSocket?.emit("NAME", userId)
    }

    fun emitMessageText(messageText: String) {
        mSocket?.emit("SEND", messageText)
    }
}