package demo.dsl

import demo.dsl.domain.StarWarsFilms
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {

    DBConnection.db

    transaction {

        addLogger(StdOutSqlLogger)

        SchemaUtils.create(StarWarsFilms)

        val idx = StarWarsFilms.insertAndGetId {
            it[name] = "The Last Jedi"
            it[sequelId] = 8
            it[director] = "Rian Johnson"
        }

        /*
        val idx2 = StarWarsFilms.insert {
            it[name] = "The Last Jedi"
            it[sequelId] = 8
            it[director] = "Rian Johnson"
        } get StarWarsFilms.id
        */

        val query: Query = StarWarsFilms.select { StarWarsFilms.id eq idx }

        query.forEach {
            println(it[StarWarsFilms.name])
        }


        val filmAndDirector: List<Pair<String, String>> =
            StarWarsFilms.slice(StarWarsFilms.name, StarWarsFilms.director)
                .selectAll().map {
                    it[StarWarsFilms.name] to it[StarWarsFilms.director]
                }

        filmAndDirector.forEach { println(it.first) }


        val directors =
            StarWarsFilms.slice(StarWarsFilms.director)
                .select { StarWarsFilms.sequelId.less(5) }.withDistinct().map {
                it[StarWarsFilms.director]
            }

        directors.forEach { println(it) }

        SchemaUtils.drop(StarWarsFilms)
    }

}