package nl.jorisebbelaar.gamebacklogkotlin.database

import android.content.Context
import androidx.lifecycle.LiveData
import nl.jorisebbelaar.gamebacklogkotlin.model.Game

class GameRepository(context: Context) {

    private var gameDao: GameDao

    init {
        val reminderRoomDatabase = GameRoomDatabase.getDatabase(context)
        gameDao = reminderRoomDatabase!!.gameDao()
    }

    fun getAllGames(): LiveData<List<Game>> = gameDao.getAllGames()

    suspend fun insertGame(game: Game) = gameDao.insertGame(game)

    suspend fun deleteGame(game: Game) = gameDao.deleteGame(game)

    suspend fun deleteAllGames() = gameDao.deleteAllGames()
}