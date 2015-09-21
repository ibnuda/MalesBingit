/**
 * Created by Ikrur on 21/09/2015.
 */

package forms

import models.Tautan.Tautan
import play.api.data.Form
import play.api.data.Forms._

object FormUrl {
  val form = Form(
    mapping(
      "url" -> nonEmptyText,
      "kelas" -> nonEmptyText
    )(Tautan.apply)(Tautan.unapply)
  )
}
