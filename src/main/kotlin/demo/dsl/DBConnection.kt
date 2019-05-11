package demo.dsl

import org.jetbrains.exposed.sql.Database

object DBConnection {
    val db by lazy {
        Database.connect(
            "jdbc:mysql://localhost:3306/test", driver = "com.mysql.jdbc.Driver", user = "dev", password = "123qwe"
        )
    }
}