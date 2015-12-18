package models

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

case class Country(id: Option[Int] = None, name: String)
case class City(id: Option[Int] = None, countryId: Int, name: String, population: Int)

object Country {

  val simple: RowParser[Country] = {
    get[Option[Int]]("country.id") ~
    str("country.name") map {
      case id~name => Country(id, name)
    }
  }
}

object City {

  val simple: RowParser[City] = {
    get[Option[Int]]("city.id") ~
    int("city.country_id") ~
    str("city.name") ~
    int("city.population") map {
      case id~countryId~name~population => City(id, countryId, name, population)
    }
  }
  
  val withCountry: RowParser[(Country, City)] = {
    Country.simple ~ City.simple map {
      case country~city => (country, city)
    }
  }

  def list: List[(Country, City)] = {

    DB.withConnection { implicit connection =>

      SQL(
        """
          SELECT *
          FROM city
            INNER JOIN country ON city.country_id = country.id
        """
      ).as(City.withCountry *)
    }
  }
}
