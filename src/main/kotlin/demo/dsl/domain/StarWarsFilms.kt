package demo.dsl.domain

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column
//import org.jetbrains.exposed.sql.Table

/*
object StarWarsFilms : Table() {
    val id: Column<Int> = integer("id").autoIncrement().primaryKey()
    val sequelId: Column<Int> = integer("sequel_id").uniqueIndex()
    val name: Column<String> = varchar("name", 50)
    val director: Column<String> = varchar("director", 50)
}
*/

object StarWarsFilms : IntIdTable() {
    val sequelId: Column<Int> = integer("sequel_id").uniqueIndex()
    val name: Column<String> = varchar("name", 50)
    val director: Column<String> = varchar("director", 50)
}