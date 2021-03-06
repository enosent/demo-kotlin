package demo.exposed

import org.jetbrains.exposed.sql.Database

object DbSettings {
    val db by lazy {
        Database.connect(
            "jdbc:mysql://localhost:3306/test", driver = "com.mysql.jdbc.Driver", user = "dev", password = "123qwe"
        )
    }
}