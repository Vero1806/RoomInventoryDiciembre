package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface ItemDao {
    @Insert(onConflict = // prevención de errores
        OnConflictStrategy.IGNORE) // En caso de conflicto omitir el nuevo elemento si la clave primaria ya esta creada
    suspend fun insert (item: Item) //le pasamos como parametro el item

    @Update
    suspend fun update (item: Item)

    @Delete
    suspend fun delete (item: Item) //primero tabla y luego a la data class

    @Query("SELECT * from items WHERE id = :id")
    fun getItem (id: Int): Flow<Item> // declaramos el id como parametro inicial de la tabla (corrutina)
        //flow = suspend para que no deje de mostrar el select antes de hacer un insert o cualquier otra función

    @Query ("SELECT * FROM items ORDER BY name ASC")
    fun getItems() : Flow<List<Item>>

}

