package demo.exposed

import demo.exposed.domain.Cities
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {

    DbSettings.db

    transaction {

        // print sql to std-out
        addLogger(StdOutSqlLogger)

        SchemaUtils.create(Cities)

        // insert new city. SQL: INSERT INTO Cities (name) VALUES ('St. Petersburg')
        val idx = Cities.insert {
            it[name] = "St. Petersburg"
        } get demo.exposed.Cities.id

        idx!!.value


        // 'select *' SQL: SELECT Cities.id, Cities.name FROM Cities
        println("Cities: ${Cities.selectAll()}")

        SchemaUtils.drop(Cities)
    }

}