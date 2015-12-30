package controllers

import play.api._
import play.api.mvc._
import models._
import scala.collection.immutable.ListMap

object Application extends Controller {

  def showCities = Action {

    val countriesAndCitiesUnsorted: List[(Country, City)] = City.list
    
    val countriesAndCities = countriesAndCitiesUnsorted.sortWith {

      case ((country0, city0), (country1, city1)) =>

        country0.name < country1.name ||
        (country0.name == country1.name && city0.population > city1.population)
    }

    val countriesToCities = countriesAndCities.foldLeft(ListMap.empty[Country, Seq[City]]) {

      case (theMap, (country, newCity)) => {

        val existingCities = theMap.getOrElse(country, Seq.empty[City])

        theMap + ((country, existingCities :+ newCity))
      }
    }

    Ok(views.html.cities(countriesToCities))
  }

}